package lambda.lambda5.map;

import java.util.List;

public class MapMainV5 {

    public static void main(String[] args) {

        // String -> String
        List<String> fruits = List.of("apple", "banana", "orange");
        List<String> upperFruits = GenericMapper.map(fruits, String::toUpperCase);
        System.out.println("upperFruits = " + upperFruits);

        // String -> Integer
        List<Integer> lengthFruits = GenericMapper.map(fruits, String::length);
        System.out.println("lengthFruits = " + lengthFruits);

        // Integer -> String
        List<Integer> integers = List.of(1, 2, 3);
        List<String> starList = GenericMapper.map(integers, "*"::repeat);
        System.out.println("starList = " + starList);
    }
}
