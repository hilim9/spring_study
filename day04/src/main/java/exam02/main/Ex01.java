package exam02.main;

import exam02.aopex.*;
import exam02.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator cal = ctx.getBean(RecCalculator.class);
        long result = cal.factorial(10);
        System.out.printf("cal=%d%n",result);

        ctx.close();
    }
}
