package ch14;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_9 {
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

        Stream.of(strArr).forEach(System.out::println);
        System.out.println();
//        Stream.of(strArr).parallel().forEachOrdered(System.out::println);
//        System.out.println();

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
        Optional<String> sWord = Stream.of(strArr).parallel().filter(s -> s.charAt(0) == 's').findAny();
        System.out.println("noEmptyStr = " + noEmptyStr);
        System.out.println("sWord = " + sWord.orElse("doesn't exist"));
        System.out.println();

        // Stream<String> -> IntStream(기본형 스트림)
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int sum = intStream1.reduce(0, (a, b) -> a + b);
        int count = intStream2.reduce(0, (a, b) -> a + 1);
        System.out.println("sum = " + sum);
        System.out.println("count = " + count);
        System.out.println();

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce((a, b) -> Integer.min(a, b));
        System.out.println("max = " + max.getAsInt());
        System.out.println("min = " + min.getAsInt());
    }
}
