package exam01.config;

import exam01.Greet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //
public class AppCtx { // ApplicationContext

    @Bean // 스프링 컨테이너가 관리하는 객체
    public Greet greet() {
        return new Greet();
    }
}
