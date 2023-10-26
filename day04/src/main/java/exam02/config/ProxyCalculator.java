package exam02.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Order(2)
@Aspect // 공통 기능을 정의한 클래스
public class ProxyCalculator {

    /* @Pointcut("execution(* exam02.aopex..*(..))") // ANT 패턴
    public void publicTarget() {} */


    // @Around("execution(* exam02.aopex..*(..))")
    // @Around("publicTarget()")
    @Around("CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        //System.out.println("proxy!!");

        long stime = System.nanoTime();

        /* Signature sig = joinPoint.getSignature();
        System.out.println(sig.toLongString()); */

        Object[] args = joinPoint.getArgs();
        Long num = (Long) args[0]; // 매개변수의 값
        System.out.println(num.toString()); // 10

        try {
            Object result = joinPoint.proceed(); // factorial(...) - 핵심기능(대신 수행)

            return result;
        } finally {

            long etime = System.nanoTime();
            System.out.printf("걸린시간: %d%n", etime - stime);
        }

    }
}
