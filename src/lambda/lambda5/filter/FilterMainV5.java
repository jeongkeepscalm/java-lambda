package lambda.lambda5.filter;

import java.util.List;

public class FilterMainV5 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> numbersResult = GenericFilter.filter(numbers, n -> n % 2 == 0);
        System.out.println("numbersResult = " + numbersResult);

        List<String> strings = List.of("A", "BB", "CCC");
        List<String> stringsResult = GenericFilter.filter(strings, v -> v.length() >= 2);
        System.out.println("stringsResult = " + stringsResult);
    }

}
