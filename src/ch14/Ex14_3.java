package ch14;

import java.util.function.*;

public class Ex14_3 {
    public static void main(String[] args) {
        Function<String, Integer> f = s -> Integer.parseInt(s, 16);
        Function<Integer, String> g = i -> Integer.toBinaryString(i);

        Function<String, String> h1 = f.andThen(g);
        Function<Integer, Integer> h2 = f.compose(g);
        System.out.println("h1.apply(\"BB\") = " + h1.apply("FF"));
        System.out.println("h2 = " + h2.apply(2));

        Function<String, String> f2 = x -> x;   // 항등함수
        System.out.println("f2.apply() = " + f2.apply("2"));

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate();   // i >= 100

        Predicate<Integer> all = notP.and(q.or(r)); //  p && (q || r)
        System.out.println("all.test(150) = " + all.test(150));

        String str1 = "abc";
        String str2 = "abc";

//        Predicate<String> p2 = Predicate.isEqual(str1);
//        boolean result = p2.test(str2);
//        System.out.println(result);

        System.out.println(Predicate.isEqual(str1).test(str2));

    }

}
