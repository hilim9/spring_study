package exam01.main;

import exam01.Greet;
import exam01.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ex01 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        // 이름(메서드명), 클래스 두 종류를 가지고 불러옴
        Greet g1 = ctx.getBean("greet", Greet.class);
        g1.hello("이이름");

        System.out.println();

        Greet g2 = ctx.getBean("greet", Greet.class);
        System.out.println(g1 == g2); // 싱글톤패턴으로 주소 관리(공유)

        System.out.println(System.identityHashCode(g1));
        System.out.println(System.identityHashCode(g2));

        
        ctx.close(); // 메모리에서 해제

    }
}
