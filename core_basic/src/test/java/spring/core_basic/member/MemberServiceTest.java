package spring.core_basic.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rua
 */
class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();
    @Test
    @DisplayName("회원 가입 및 호출 테스트")
    void test() {
        //given
        Member member = new Member(Grade.VIP, "member1");
        Member member2 = new Member(Grade.BASIC, "member2");
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        memberService.join(member2);
        Member findMember2 = memberService.findMember(member2.getId());

        //then
        Assertions.assertEquals(member, findMember); //인스턴스의 주소값 비교.
        Assertions.assertEquals(member2, findMember2); //메모리 기반이어서 가능한 작업.
    }

}