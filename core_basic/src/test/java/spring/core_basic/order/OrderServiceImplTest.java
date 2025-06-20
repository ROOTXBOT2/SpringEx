package spring.core_basic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.core_basic.AppConfig;
import spring.core_basic.member.*;

/**
 * @author rua
 */
class OrderServiceImplTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.membverService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder() {
        Member member1 = new Member( Grade.VIP,"memberA");
        Member member2 = new Member( Grade.BASIC,"memberB");

        memberService.join(member1);
        memberService.join(member2);

        Order order1 = orderService.createOrder(member2.getId(),"itemA",10000);
        Order order2 = orderService.createOrder(member1.getId(),"itemB",6000);

        Assertions.assertThat(order1.getDiscountPrice()).isEqualTo(0);

        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(600);

        System.out.println(order1.caclulatePrice());
        System.out.println(order2.caclulatePrice());

    }

}