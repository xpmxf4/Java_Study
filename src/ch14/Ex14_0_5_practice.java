package ch14;

import java.util.stream.Stream;


public class Ex14_0_5_practice {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.iterate(0, n -> n + 2);
        integerStream.limit(10).forEach(System.out::println);
        System.out.println();

        Stream<Integer> integerStream1 = Stream.generate(() -> (int) (Math.random() * 10 + 1));
        integerStream1.limit(10).forEach(System.out::println);

    }
}
