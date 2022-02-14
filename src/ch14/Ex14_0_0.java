package ch14;

import java.util.function.Function;

public class Ex14_0_0 {
    public static void main(String[] args) {
//        Function<String, Integer> f = (String s) -> Integer.parseInt(s);
//        Function<String, Integer> f = 클래스이름::메서드이름;
//        Function<String, Integer> f = Integer::parseInt;
        Function<String, Integer> f = s -> Integer.parseInt(s);

        System.out.println(f.apply("100") + 200);

    }
}
