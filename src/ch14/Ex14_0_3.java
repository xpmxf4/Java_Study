package ch14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Collection 인터페이스는 Stream<E> stream() 메서드를 가지고 있고,
// Collection 인터페이스를 구현한 list, Set 은 stream() 을 상속한다.
// 그 사용법을 보는 예제.

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
