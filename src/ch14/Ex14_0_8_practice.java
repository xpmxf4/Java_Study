package ch14;

import java.util.Optional;

public class Ex14_0_8_practice {
    public static void main(String[] args) {
        int[] arr = new int[0];
        System.out.println("arr.length = " + arr.length);

        Optional<String> opt = null;
        Optional<String> opt1 = Optional.empty();
        Optional<String> opt2 = Optional.of("Not Empty");
        System.out.println("opt2 = " + opt2);
        System.out.println("opt2.get() = " + opt2.get());
        System.out.println("opt1.orElse(\"Empty!\") = " + opt1.orElse("Empty!"));
        System.out.println();


        String str = "";
        
        str = opt2.orElseGet(String::new);
        System.out.println("str = " + str);
    }
}
