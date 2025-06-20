package spring.core_basic;

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

public class AppConfig {
    public MemberService membverService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    private MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(getDiscountPolicy(), getMemberRepository());
    }

    private DiscountPolicy getDiscountPolicy() {
//        return new FixDisxountPolicy();
        return new RateDiscountPolicy();
    }
}
