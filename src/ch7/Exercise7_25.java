package ch7;

public class Exercise7_25 {
    public static void main(String[] args) {
        Outer22 outer = new Outer22();
        Outer22.Inner22 inner = outer.new Inner22();

        System.out.println(inner.iv);
    }
}

class Outer22 {
    class Inner22 {
        int iv=100;
    }
}