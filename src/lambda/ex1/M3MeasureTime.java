package lambda.ex1;

import lambda.Procedure;

import java.util.Arrays;

public class M3MeasureTime {

    static void measureTime(Procedure p) {
        long startTime = System.nanoTime();
        p.run();
        long endTime = System.nanoTime();
        System.out.println("실행 시간: " + (endTime - startTime));
    }

    public static void main(String[] args) {
        Procedure p1 = () -> {
            int N = 100;
            long sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += i;
            }
            System.out.println("sum = " + sum);
        };
        Procedure p2 = () -> {
            int[] arr = { 4, 3, 2, 1 };
            System.out.println("원본 배열: " + Arrays.toString(arr));
            Arrays.sort(arr);
            System.out.println("배열 정렬: " + Arrays.toString(arr));
        };
        measureTime(p1);
        measureTime(p2);
    }

    // p.64 부터

}
