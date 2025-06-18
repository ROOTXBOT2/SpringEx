package spring.core_basic.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.core_basic.member.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rua
 */
class OrderServiceImplTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Member member1 = new Member( Grade.VIP,"memberA");
        Member member2 = new Member( Grade.BASIC,"memberB");

        memberService.join(member1);
        memberService.join(member2);

        Order order1 = orderService.createOrder(member1.getId(),"itemA",10000);
        Order order2 = orderService.createOrder(member2.getId(),"itemB",6000);

        Assertions.assertThat(order1.getDiscountPrice()).isEqualTo(1000);

        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(0);
    }
}