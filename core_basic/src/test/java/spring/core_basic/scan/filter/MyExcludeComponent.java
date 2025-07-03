package spring.core_basic.scan.filter;

import java.lang.annotation.*;

/**
 * @author rua
 */

//이게 붙은건 컴포넌트 스캔에서 제외할 꺼야.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
