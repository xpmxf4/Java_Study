package ch14;

import java.util.Optional;

public class Ex14_0_8 {
    public static void main(String[] args) {
//        int[] arr = {};
        int[] arr = new int[0];
        System.out.println("arr.length = " + arr.length);

//        Optional<String> opt = null;    // ok, 하지만 바람직x
//        Optional<String> opt = Optional.empty();
        Optional<String> opt = Optional.of("not empty!");
        System.out.println("opt = " + opt);
//        System.out.println("opt.get() = " + opt.get());
//        System.out.println("opt.orElse(\"asdf\") = " + opt.orElse("asdf"));
        System.out.println();

        String str = "";

//        try {
//            str = opt.get();
//        } catch (Exception e) {
//            str = "";
//        }


//        str = opt.orElse("It is empty!");
        str = opt.orElseGet(String::new);
        System.out.println("str = " + str);
    }
}
