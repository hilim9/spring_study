package exam01.main;

import exam01.Greet;
import exam01.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ex01 {
    public static void main(String[] args) {

        // 스프링 컨테이너 (관련 객체 설정)
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Greet g1 = ctx.getBean("greet", Greet.class); // 이름과 클래스를 종류를 가지고 불러옴
        g1.hello("이이름");
        
        ctx.close();
    }
}
