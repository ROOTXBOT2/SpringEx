package spring.core_basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring.core_basic.order.OrderService;

/**
 * @author rua
 */
@Configuration
@ComponentScan(
        basePackages = "spring.core_basic.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
