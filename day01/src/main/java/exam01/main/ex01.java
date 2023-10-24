package exam01.main;

import exam01.Greet;
import exam01.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ex01 {
    public static void main(String[] args) {

        // 스프링 컨테이너 (관련 객체 설정)
        // 매개변수에 Class class를 설정한 이유: 클래스의 정보를 확인한 후 생성하기 때문
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Greet g1 = ctx.getBean("greet", Greet.class); // 이름(메서드명), 클래스 두 종류를 가지고 불러옴
        g1.hello("이이름");
        
        ctx.close();
    }
}
