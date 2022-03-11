package ch14;

import java.util.*;

public class Ex14_8_practice {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);

        System.out.println("optStr = " + optStr.get());
        System.out.println("optInt = " + optInt.get());

        System.out.println();
        System.out.println();

        int result1 = Optional.of("123")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt)
                .get();
        int test = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt)
//                .get(); // empty
                .orElseGet(() -> (int) (Math.random() * 5));
        int result2 = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt)
                .orElse(-1);

        System.out.println("result1 = " + result1);
        System.out.println("test = " + test);
        System.out.println("result2 = " + result2);

        Optional.of("456")
                .map(Integer::parseInt)
                .ifPresent(x -> System.out.printf("result=%3d", x));
        System.out.println();

        OptionalInt optInt1 = OptionalInt.of(0);
        OptionalInt optInt2 = OptionalInt.empty();

        System.out.println("optInt1.isPresent() = " + optInt1.isPresent());
        System.out.println("optInt2.isPresent() = " + optInt2.isPresent());
        System.out.println("optInt1 = " + optInt1);
        System.out.println("optInt2 = " + optInt2);
        System.out.println("+optInt1.equals(optInt2) = " +optInt1.equals(optInt2));
    }
}
