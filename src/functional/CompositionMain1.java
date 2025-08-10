package functional;

import java.util.function.Function;

public class CompositionMain1 {

    public static void main(String[] args) {

        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> add = x -> x + 1;

        // (2 + 1) * (2 + 1) =  9
        Function<Integer, Integer> newFunc1 = square.compose(add);
        System.out.println("newFunc1 결과: " + newFunc1.apply(2));

        // 2 * 2 + 1 = 5
        Function<Integer, Integer> newFunc2 = square.andThen(add);
        System.out.println("newFunc2 결과: " + newFunc2.apply(2));
    }

}
