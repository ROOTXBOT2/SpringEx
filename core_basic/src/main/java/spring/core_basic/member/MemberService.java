package spring.core_basic.member;

/**
 * @author rua
 */
public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);

}
