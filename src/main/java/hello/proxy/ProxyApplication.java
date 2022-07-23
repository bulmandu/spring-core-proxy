package hello.proxy;

import hello.proxy.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppV1Config.class) //클래스를 스프링 빈으로 등록한다.
@SpringBootApplication(scanBasePackages = "hello.proxy.app") // 위 Import 클래스와 component Scan 대상 패키지를 분리하기 위해서
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

}
