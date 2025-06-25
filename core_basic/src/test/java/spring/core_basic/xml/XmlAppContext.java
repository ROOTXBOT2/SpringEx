package spring.core_basic.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.core_basic.member.MemberService;
import spring.core_basic.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
/**
 * @author rua
 */

public class XmlAppContext {
    @Test
    void xmpAppContext(){
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = (MemberService) ac.getBean("memberService",MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
