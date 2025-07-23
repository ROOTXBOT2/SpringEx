package spring.core_basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import spring.core_basic.AppConfig;

import static org.assertj.core.api.Assertions.*;

/**
 * @author rua
 */
public class SingletonTest {
    @Test
    void SingletonBeanFind(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean singletonBean1 = annotationConfigApplicationContext.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = annotationConfigApplicationContext.getBean(SingletonBean.class);

        System.out.println("singletonBean1" + singletonBean1);
        System.out.println("singletonBean2" + singletonBean2);

        assertThat(singletonBean1).isSameAs(singletonBean2);
        annotationConfigApplicationContext.close();
    }
    @Scope("singleton")
    static class SingletonBean{
        @PostConstruct
        public void init(){
            System.out.println("SingletonBean init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean destroy");
        }
    }
}
