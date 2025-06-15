package hello.hello_spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author rua
 */
@Aspect

public class TimeTraceAop {
    @Around("execution(* hello.hello_spring..*(..)) && !target(hello.hello_spring.service.SpringConfig)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
         long start = System.currentTimeMillis();
         try{
             return joinPoint.proceed();
         }finally {
             long finish = System.currentTimeMillis();
             long timeMs = finish - start;
             System.out.println("END: " + joinPoint.getSignature() + timeMs + "ms");
        }
    }
}
