package ch14Mac;

import java.util.*;
import java.util.stream.IntStream;

public class Ex14_0_4 {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints(5,10);
        intStream
                .limit(5)           // 5 개만 자르기
                        .forEach(System.out::println);

        System.out.println();

        IntStream intStream1 = new Random().ints(5,1, 11);
        intStream1.forEach(System.out::println);
    }
}
