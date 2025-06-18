package spring.core_basic;

import spring.core_basic.discount.Order;
import spring.core_basic.discount.OrderService;
import spring.core_basic.discount.OrderServiceImpl;
import spring.core_basic.member.Grade;
import spring.core_basic.member.Member;
import spring.core_basic.member.MemberService;
import spring.core_basic.member.MemberServiceImpl;

/**
 * @author rua
 */
public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Member member1 = new Member( Grade.VIP,"memberA");
        Member member2 = new Member( Grade.BASIC,"memberB");

        memberService.join(member1);
        memberService.join(member2);

        Order order1 = orderService.createOrder(member1.getId(),"itemA",10000);
        Order order2 = orderService.createOrder(member2.getId(),"itemB",6000);

    }
}
