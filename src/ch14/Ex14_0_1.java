package ch14;

import java.util.function.*;

public class Ex14_0_1 {
    public static void main(String[] args) {
        Function<Integer, MyClass> s = MyClass::new;

        System.out.println(s.apply(2));

//        Function<Integer, int[]> f2 = i -> new int[i];
        Function<Integer, int[]> f2 = int[]::new;
        int[] arr = f2.apply(5);
        System.out.println("arr.length = " + arr.length);
    }
}

class MyClass {
    int iv;

    MyClass(int iv) {
        this.iv = iv;
    }
}