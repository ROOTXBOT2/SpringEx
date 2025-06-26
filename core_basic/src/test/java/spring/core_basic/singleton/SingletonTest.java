package spring.core_basic.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core_basic.AppConfig;
import spring.core_basic.member.MemberService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rua
 */

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService = appConfig.memberService();

        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println(memberService);
        System.out.println(memberService2);
        assertNotEquals(memberService, memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletoneServiceTest(){
        SingletonServiceT singletonServiceT = SingletonServiceT.getInstance();
        SingletonServiceT singletonServiceT2 = SingletonServiceT.getInstance();

        System.out.println(singletonServiceT);
        System.out.println(singletonServiceT2);
        assertEquals(singletonServiceT, singletonServiceT2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext appConfig = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = appConfig.getBean("memberService",MemberService.class);
        MemberService memberService2 = appConfig.getBean("memberService",MemberService.class);

        //참조값이 다른 것을 확인
        System.out.println(memberService);
        System.out.println(memberService2);
        assertEquals(memberService, memberService2);
    }
}
