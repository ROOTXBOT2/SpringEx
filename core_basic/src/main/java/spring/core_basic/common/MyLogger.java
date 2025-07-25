package spring.core_basic.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author rua
 */

@Component
@Scope(value="request",proxyMode= ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("["+uuid+"] "+ "["+requestURL+"] "+message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();//겹칠 수 있지만 로또를 세번 연속 맞을 만한 확률
        System.out.println("["+uuid+"] request scope bean create: "+this);
    }

    @PreDestroy
    public void close(){
        System.out.println("["+uuid+"] request scope bean close: "+this);
    }
}
