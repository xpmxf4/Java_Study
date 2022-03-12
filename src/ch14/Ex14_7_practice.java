package ch14;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex14_7_practice {
    public static void main(String[] args) {
        Stream<String[]> strArrStrm = Stream.of(
                new String[]{"abc", "def", "ghi"},
                new String[]{"ABC", "GHI", "JKL"}
        );

        Stream<String> strStream = strArrStrm.flatMap(Arrays::stream);

        strStream
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };
        Stream<String> lineStream = Arrays.stream(lineArr);
//        lineStream.forEach(System.out::println);

        lineStream
                .flatMap(line -> Stream.of(line.split(" +")))
                .map(String::toLowerCase)
//                .distinct()
//                .sorted()
                .forEach(System.out::println);

    }
}
