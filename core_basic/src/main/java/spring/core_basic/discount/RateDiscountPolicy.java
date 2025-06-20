package spring.core_basic.discount;

import spring.core_basic.member.Grade;
import spring.core_basic.member.Member;

/**
 * @author rua
 */
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent /100;
        } else {
            return 0;
        }
    }
}
