package spring.core_basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rua
 */
public class PrototypeTest {
    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(PrototypeBean.class);


        PrototypeBean PrototypeBean1 = annotationConfigApplicationContext.getBean(PrototypeBean.class);

        PrototypeBean PrototypeBean2 = annotationConfigApplicationContext.getBean(PrototypeBean.class);

        System.out.println("PrototypeBean1" + PrototypeBean1);
        System.out.println("PrototypeBean2" + PrototypeBean2);

        assertThat(PrototypeBean1).isNotSameAs(PrototypeBean2);
        annotationConfigApplicationContext.close();
    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean destroy");
        }
    }


}
