package exam05.config;

import exam05.Message;
import exam05.main.Message2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtx {

    @Bean
    @Scope("prototype") // 새로운 객체 매번 생성
    public Message message() {
        return new Message();

    }

    // 외부 라이브러리, 외부 클래스 사용 시 아래와 같이 정의

    @Bean(initMethod = "init", destroyMethod = "close")
    public Message2 message2() {
        return new Message2();

    }
}
