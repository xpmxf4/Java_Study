package ch7;

public class Exercise7_26 {
    public static void main(String[] args) {
        Outer33.Inner33 inner = new Outer33.Inner33();
        System.out.println(inner.iv);
    }
}

class Outer33 {
    static class Inner33 {
        int iv=200;
    }
}