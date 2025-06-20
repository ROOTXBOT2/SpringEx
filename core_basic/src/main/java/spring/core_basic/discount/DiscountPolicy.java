package spring.core_basic.discount;

import spring.core_basic.member.Member;

/**
 * @author rua
 */
public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);

}
