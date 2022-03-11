package ch14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_0_3_practice {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();

        intStream.forEach(System.out::print);

        intStream = list.stream();
        intStream.forEach(System.out::print);

        intStream = list.stream();
        intStream.forEach(i -> System.out.print(i));
        System.out.println();

        String[] strArr = {"A", "B", "C", "D"};
        Stream<String> strStream = Stream.of(strArr); // String.stream() 은 없다.
        strStream.forEach(System.out::println);

        int[] intArr = {1, 2, 3, 4, 5};
        IntStream intStream1 = Arrays.stream(intArr); // 하지만 Arrays.stream() 은 존재함.
        intStream1.forEach(System.out::println);

        Stream<int[]> intStream1234 = Stream.of(intArr);    // 기본형 배열을 집어넣게 되면, 앞에 타입이 달라진다!

    }
}
