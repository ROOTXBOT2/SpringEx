package spring.core_basic.autowired;

import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.bean.override.convention.TestBean;
import spring.core_basic.member.Member;
import spring.core_basic.member.MemberService;

import java.util.Optional;

/**
 * @author rua
 */
public class AutowiredTest {
    @Test
    void AutoWiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{
        @Autowired(required = false) //의존관계가 없다면 메소드 자체가 호출이 안됨.
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 : " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){ //호출은 되되 Null이면 Null이 할당됨.
            System.out.println("noBean2 : " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){ //호출은 되되 Member빈이 있으면 할당 없으면 없다고 뜬다.
            System.out.println("noBean3 : " + noBean3);
        }
    }
}
