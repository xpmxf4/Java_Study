package ch14;

import java.util.Random;
import java.util.function.*;
import java.util.stream.IntStream;

public class Ex14_0_4_practice {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints(5, 10);
        intStream
                .limit(5)
                .forEach(System.out::print);

        System.out.println();

        IntStream intStream1 = new Random().ints(5, 1, 11);
        intStream1.forEach(System.out::print);
    }
}
