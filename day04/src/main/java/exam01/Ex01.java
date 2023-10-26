package exam01;

public class Ex01 {
    public static void main(String[] args) {

        // 핵심기능: 팩토리얼 연산

        long stime = System.nanoTime();

        ImplCalculator cal1 = new ImplCalculator();
        long result1 = cal1.factorial(10); // 핵심기능
        System.out.printf("cal2: %d%n",result1);

        long etime = System.nanoTime();
        System.out.printf("cal1 걸린시간: %d%n",etime - stime);

        stime = System.nanoTime();

        RecCalculator cal2 = new RecCalculator();
        long result2 = cal2.factorial(10); // 핵심기능
        System.out.printf("cal2: %d%n",result2);

        etime = System.nanoTime();
        System.out.printf("cal2 걸린시간: %d%n",etime - stime);









    }
}
