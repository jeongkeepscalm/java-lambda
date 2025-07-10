package lambda.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FunctionalMain {

    public static void main(String[] args) {

        /**
         * Functional Interface
         */
        // Function
        Function<String, Integer> getLength = v -> v.length();
        System.out.println(getLength.apply("hello"));

        // Consumer
        Consumer<String> justPrint = v -> System.out.println("entered value: " + v);
        justPrint.accept("test");

        // Supplier
        Supplier<Integer> getRandomNumber = () -> new Random().nextInt(10) + 1;
        System.out.println(getRandomNumber.get());

        // Runnable
        Runnable asyncProcess = () -> {
            // API 요청 비동기 처리
            System.out.println("Async job started...");
            // 예: 외부 API 호출, 결과 저장 등
            System.out.println("Async job done.");
        };
        asyncProcess.run();

        // Predicate
        Predicate<Integer> isEven = v -> v % 2 == 0;
        System.out.println(isEven.test(3));

        /**
         * Example
         */
        List<Integer> numbers = List.of(-3, -2, -1, 1, 2, 3, 5);
        List<Integer> evenNumberList = getFilteredList(numbers, v -> v % 2 == 0);
        List<Integer> negativeNumberList = getFilteredList(numbers, v -> v < 0);
        System.out.println("evenNumberList = " + evenNumberList);
        System.out.println("negativeNumberList = " + negativeNumberList);

        List<String> words = List.of("hello", "java", "lambda");
        List<String> upperCaseList = mappedString(words, v -> v.toUpperCase());
        List<String> editedStringList = mappedString(words, v -> "***" + v + "***");
        System.out.println("upperCaseList = " + upperCaseList);
        System.out.println("editedStringList = " + editedStringList);

        List<Integer> numberList = List.of(1, 2, 3, 4);
        int sum = reducedInteger(numberList, 0, (a, b) -> a + b);
        int multiplied = reducedInteger(numberList, 1, (a, b) -> a * b);
        System.out.println("sum = " + sum);
        System.out.println("multiplied = " + multiplied);

    }

    public static List<Integer> getFilteredList(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : list) {
            if (predicate.test(i)) result.add(i);
        }
        return result;
    }

    public static List<String> mappedString(List<String> list, UnaryOperator<String> unaryOperator) {
        List<String> result = new ArrayList<>();
        for (String v : list) {
            result.add(unaryOperator.apply(v));
        }
        return result;
    }

    public static int reducedInteger(List<Integer> list, int initial, BinaryOperator<Integer>
            binaryOperator) {
        int result = initial;
        for (int val : list) {
            result = binaryOperator.apply(result, val);
        }
        return result;
    }
}
