package ch14;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_9_practice {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance",
                "Java",
                "Lambda",
                "stream",
                "OptionalDouble",
                "IntStream",
                "count",
                "sum"
        };

        Stream
                .of(strArr)
                .parallel()
                .forEach(System.out::println);

        boolean noEmptyStr = Stream.of(strArr)
                .noneMatch(s -> s.length() == 0);
        
        Optional<String> sWord = Stream.of(strArr)
                .parallel()
                .filter(s -> s.charAt(0) == 's')
                .findAny();

        System.out.println("noEmptyStr = " + noEmptyStr);
        System.out.println("sWord = " + sWord.orElse("doesn't exist"));
        System.out.println();

        // Stream<String> -> IntStream(기본형 스트림)
        IntStream intStream = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);

        int sum = intStream.reduce(0, (a, b) -> a + b);
        int count = intStream1.reduce(0, (a, b) -> a + 1);
        System.out.println("sum = " + sum);
        System.out.println("count = " + count);
        System.out.println();

        OptionalInt max = intStream2.reduce(Integer::max);
        OptionalInt min = intStream3.reduce((a,b) -> Math.min(a,b));
        System.out.println("max = " + max.orElseGet(() -> 0));
        System.out.println("min = " + min.orElse(0));

    }
}
