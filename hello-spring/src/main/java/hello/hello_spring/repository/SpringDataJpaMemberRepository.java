package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author rua
 */
@Repository
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>,MemberRepository{
    @Override
    Optional<Member> findById(Long id);
}
