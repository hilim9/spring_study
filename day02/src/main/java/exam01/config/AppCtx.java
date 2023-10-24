package exam01.config;

import exam01.Greet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 클래스로 인식하게 해주는 애노테이션
public class AppCtx {

    @Bean // 스프링 컨테이너가 관리하는 객체
    public Greet greet() {
        return new Greet();
    }
}
