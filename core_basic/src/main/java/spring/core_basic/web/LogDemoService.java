package spring.core_basic.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import spring.core_basic.common.MyLogger;

/**
 * @author rua
 */
@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String testId) {

        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = "+testId);
    }
}
