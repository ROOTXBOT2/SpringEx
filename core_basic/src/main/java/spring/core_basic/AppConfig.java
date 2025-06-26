package spring.core_basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.core_basic.discount.DiscountPolicy;
import spring.core_basic.discount.FixDisxountPolicy;
import spring.core_basic.discount.RateDiscountPolicy;
import spring.core_basic.member.MemberRepository;
import spring.core_basic.member.MemberService;
import spring.core_basic.member.MemberServiceImpl;
import spring.core_basic.member.MemoryMemberRepository;
import spring.core_basic.order.OrderService;
import spring.core_basic.order.OrderServiceImpl;

/**
 * @author rua
 */
@Configuration // 스프링에서는 설정 메서드에 이걸 사용하게 되어있음.
public class AppConfig {
    @Bean
    public MemberService memberService(){
        // 1번
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(getMemberRepository());
    }

    @Bean
    public MemberRepository getMemberRepository() {
        //2~3번?
        System.out.println("call AppConfig.getMemberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        //1번?
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(getDiscountPolicy(), getMemberRepository());
    }

    @Bean
    public DiscountPolicy getDiscountPolicy() {
//        return new FixDisxountPolicy();
        return new RateDiscountPolicy();
    }
}
