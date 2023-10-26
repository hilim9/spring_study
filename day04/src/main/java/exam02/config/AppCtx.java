package exam02.config;

import exam02.aopex.Calculator;
import exam02.aopex.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
// proxy는 sub 클래스가 아니라 인터페이스 기반으로 만들어져 있다
public class AppCtx {

    @Bean
    public Calculator calculator() {

        return new RecCalculator();
    }

    @Bean
    public ProxyCached proxyCached() {
        return new ProxyCached();
    }

    @Bean
    public ProxyCalculator proxyCalculator() {

        return new ProxyCalculator();
    }

}
