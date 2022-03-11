package ch14;

import java.util.function.Function;

public class Ex14_0_1_practice {
    public static void main(String[] args) {
        Function<Integer, MyClass2> f = MyClass2::new;
        System.out.println("f.apply(2).getIv() = " + f.apply(2).getIv());
        
        Function<Integer, int[]> f2 = int[]::new;
        int[] arr = f2.apply(10);
        System.out.println("arr.length = " + arr.length);
    }
}

class MyClass2 {
    int iv;
    
    MyClass2(int iv){
        this.iv = iv;
    }

    public int getIv() {
        return iv;
    }
}
