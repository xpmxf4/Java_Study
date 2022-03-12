package ch14;

import java.io.File;
import java.util.stream.Stream;

public class Ex14_6_practice {
    public static void main(String[] args) {
        File[] files = {
                new File("Ex1.java"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1"),
                new File("Ex1.txt"),
        };

        Stream<File> fileStream = Stream.of(files);

        Stream<String> filenameString = fileStream.map(File::getName);
//        filenameString.forEach(System.out::println);

        fileStream = Stream.of(files);

        fileStream.map(File::getName)
                .filter(i -> i.contains("."))
//                .peek(i -> System.out.printf("filename = %s\n", i))
                .map(i -> i.substring(i.indexOf(".") + 1))
//                .peek(i -> System.out.printf("filename = %s\n", i))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);
    }
}
