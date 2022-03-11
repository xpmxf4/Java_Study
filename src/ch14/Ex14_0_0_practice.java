package ch14;

import java.util.function.*;

public class Ex14_0_0_practice {
    public static void main(String[] args) {
        Function<String, Integer> f = s -> Integer.parseInt(s);
        Function<String, Integer> f2 = Integer::parseInt;

        System.out.println("f.apply(\"12\") = " + f.apply("12"));
        System.out.println("f2.apply(\"12\") = " + f2.apply("12"));
    }
}
