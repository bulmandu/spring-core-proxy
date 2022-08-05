package hello.proxy.cglib;

import hello.proxy.cglib.code.TimeMethodInterceptor;
import hello.proxy.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class ChlibTest {

    @Test
    void cglib(){
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();

        // 구체 클래스를 기반으로 ConcreteService를 상속받은 프록시를 만듬.
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));

        // 부모타입을 ConcreteService로 지정해주었기 때문에 부모타입으로 상속받아서 프록시를 만듬
        ConcreteService proxy = (ConcreteService) enhancer.create(); // => proxy 생성

        log.info("targetClass={}", target.getClass());

        // proxyClass=class hello.proxy.common.service.ConcreteService$$EnhancerByCGLIB$$25d6b0e3
        log.info("proxyClass={}", proxy.getClass());

        proxy.call();

    }
}
