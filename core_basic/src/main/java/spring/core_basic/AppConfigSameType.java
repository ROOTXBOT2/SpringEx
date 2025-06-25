package spring.core_basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.core_basic.member.MemberRepository;
import spring.core_basic.member.MemberService;
import spring.core_basic.member.MemberServiceImpl;
import spring.core_basic.member.MemoryMemberRepository;

/**
 * @author rua
 */
public class AppConfigSameType {
    @Configuration
    public class AppConfig {

        @Bean
        public MemberRepository memberService1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberService2() {  // 동일한 타입!
            return new MemoryMemberRepository();
        }
    }
}
