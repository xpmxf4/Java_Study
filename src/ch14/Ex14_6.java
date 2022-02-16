package ch14Mac;

import java.io.*;
import java.util.stream.Stream;

public class Ex14_6 {
    public static void main(String[] args) {
        File[] files = {
                new File("Ex1.java"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1"),
                new File("Ex1.txt"),
        };

        Stream<File> fileStream = Stream.of(files);

        Stream<String> filenameStream = fileStream.map(File::getName);
//        filenameStream.forEach(System.out::println);

        fileStream = Stream.of(files);

        fileStream.map(File::getName)
                .filter(s -> s.contains("."))
                .peek(s-> System.out.printf("filename = %s%n", s))
                .map(s -> s.substring(s.indexOf(".")+1))
                .peek(s->System.out.printf("extension = %s%n", s))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);
    }
}
