package optional;

import java.util.Optional;

public class OptionalProcessingMain {

    public static void main(String[] args) {

        Optional<String> optValue = Optional.of("HELLO");
        Optional<String> optEmpty = Optional.empty();

        // 값이 있으면 Consumer 실행, 없으면 Runnable 실행
        optValue.ifPresentOrElse(
                v -> System.out.println("value: "+ v)
                , () -> System.out.println("no value"));
        optEmpty.ifPresentOrElse(
                v -> System.out.println("value: "+ v)
                , () -> System.out.println("no value"));

    }
}
