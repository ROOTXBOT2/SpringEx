package spring.core_basic.discount;

import spring.core_basic.member.Grade;
import spring.core_basic.member.Member;

/**
 * @author rua
 */
public class FixDisxountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
