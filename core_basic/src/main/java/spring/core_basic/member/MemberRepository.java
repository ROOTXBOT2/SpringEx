package spring.core_basic.member;

import java.util.Optional;

/**
 * @author rua
 */
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long memberId);
}
