package ch7.practice;

class Outer2{
    static class Inner2{
        int iv = 200;
    }
}

public class Exercise7_26 {
    public static void main(String[] args) {
        Outer2.Inner2 ii = new Outer2.Inner2();
        System.out.println(ii.iv);
    }
}
