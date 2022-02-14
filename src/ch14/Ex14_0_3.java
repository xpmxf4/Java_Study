package ch14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_0_3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();  //list -> stream

        intStream.forEach(System.out::print);

        intStream = list.stream();
        intStream.forEach(System.out::print);

        intStream = list.stream();
        intStream.forEach((i)->System.out.print(i));
        System.out.println();

        String[] strArr = {"A", "B", "C", "D"};
//        Stream<String> strStream = Stream.of(strArr);

        int[] intArr = {1, 2, 3, 4, 5};
        IntStream intStream2 = Arrays.stream(intArr);
//        IntStream intStream3 = Stream.of(intArr);
        intStream2.forEach(System.out::print);

        Stream intStream99 = Stream.of(intArr);

    }
}
