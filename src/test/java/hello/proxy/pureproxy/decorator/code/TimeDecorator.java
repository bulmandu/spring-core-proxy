package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONUtil;

@Slf4j
public class TimeDecorator implements Component {

    private Component component;

    public TimeDecorator(Component component){
        this.component = component;
    }

    @Override
    public String operator(){
        log.info("TimeDecorator 실행");
        long startTime = System.currentTimeMillis();

        String result = component.operator();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeDecorator 종료 resultTime={}ms", resultTime);
        return result;
    }
}
