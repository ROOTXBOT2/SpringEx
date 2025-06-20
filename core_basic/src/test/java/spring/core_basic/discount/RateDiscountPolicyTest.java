package spring.core_basic.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.core_basic.member.Grade;
import spring.core_basic.member.Member;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author rua
 */
class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("10% 할인 성공 확인")
    void vip_o() {
        Member member1 = new Member( Grade.VIP,"memberA");
        int discount = rateDiscountPolicy.discount(member1,10000);
        Assertions.assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("10% 할인 실패 확인")
    void vip_x() {
        Member member2 = new Member( Grade.BASIC,"memberB");
        int discount = rateDiscountPolicy.discount(member2,10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }
}