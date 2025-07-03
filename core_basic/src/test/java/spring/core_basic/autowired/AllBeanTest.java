package spring.core_basic.autowired;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core_basic.AutoAppConfig;
import spring.core_basic.discount.DiscountPolicy;
import spring.core_basic.member.Grade;
import spring.core_basic.member.Member;
import org.assertj.core.api.Assertions;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

/**
 * @author rua
 */

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ar = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);
        DiscountService discountService = ar.getBean(DiscountService.class);

        Member userA = new Member(Grade.VIP, "UserA");
        int discountPrice = discountService.discount(userA,10000,"fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountService.discount(userA,20000,"rateDiscountPolicy");
        assertThat(rateDiscountPrice).isEqualTo(2000);

    }
    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap: "+policyMap);
            System.out.println("policies: "+policies);
        }

        public int discount(Member member, int discountPrice, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member,discountPrice);
        }
    }
}
