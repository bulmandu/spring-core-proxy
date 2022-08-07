package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

    @Override // MethodInvocation 에 target 정보가 이미 들어있음
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        // target을 알아서 찾아줌
        // target 클래스 실제 비지니스 로직을 호출하고 그 결과를 받아줌
        Object result = invocation.proceed();


        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeProxy 종료 resultTime={}", resultTime);
        return result;
    }
}
