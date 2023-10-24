package exam02.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("exam02.models") // 범위내의 관리 객체를 알아서 등록
public class AppCtx3 {


}
