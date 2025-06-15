package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rua
 */
class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository ;

    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }
    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    @DisplayName("회원가입 테스트")
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findMember(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    @DisplayName("중복 회원 예외")
    public void joinException() {
        //given
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");

        //when
        memberService.join(member1);
        //오른쪽을 했을때 왼쪽의 오류가 뜨는가? True일 경우 예외처리가 정상적으로 되는 걸 확인한 것
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        try {
//            memberService.join(member1);
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다");
//        }

        //then

    }

    @Test
    @DisplayName("전체 회원 조회")
    void findMembers() {
    }

    @Test
    @DisplayName("단일 회원 조회")
    void findMember() {
    }
}