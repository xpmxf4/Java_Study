package ch14;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise14_7 {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints(6, 1, 45);
//        intStream.forEachOrdered(System.out::println); forEachOrdered λ sequential, parallel μΌλ!
        intStream.sorted().forEach(System.out::println);
    }
}
