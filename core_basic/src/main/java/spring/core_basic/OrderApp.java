package spring.core_basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core_basic.member.MemberService;
import spring.core_basic.order.Order;
import spring.core_basic.member.Grade;
import spring.core_basic.member.Member;
import spring.core_basic.order.OrderService;

/**
 * @author rua
 */
public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);

        Member member1 = new Member( Grade.VIP,"memberA");
        Member member2 = new Member( Grade.BASIC,"memberB");

        memberService.join(member1);
        memberService.join(member2);

        Order order1 = orderService.createOrder(member1.getId(),"itemA",20000);
        Order order2 = orderService.createOrder(member2.getId(),"itemB",6000);
        System.out.println(order1);
        System.out.println(order2);
    }
}
