package lambda.start;

import lambda.Procedure;

import java.util.Random;

public class ExRefMainV1 {

    public static void Hello(Procedure procedure) {
        long startNs = System.nanoTime();
        procedure.run();
        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    static class A implements Procedure {
        @Override
        public void run() {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("dice = " + randomValue);
        }
    }
    static class B implements Procedure {
        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Procedure a = new A();
        Procedure b = new B();
        Hello(a);
        Hello(b);
    }
}
