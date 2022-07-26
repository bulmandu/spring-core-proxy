package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {

    private Component component;

    public MessageDecorator(Component component){
        this.component = component;
    }
    @Override
    public String operator() {
        log.info("Message Decorator 실행");

        // "Data" -> "****Data****"
        String result = component.operator();
        String decoResult = "****" + result + "****";
        log.info("MessageDecorator 적용 전={}, 적용 후={}", result, decoResult);
        return decoResult;
    }
}
