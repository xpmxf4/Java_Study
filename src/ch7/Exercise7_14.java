package ch7;

public class Exercise7_14 {
    public static void main(String[] args) {
        SutdaCard22 card = new SutdaCard22(1, true);
        System.out.println(card);
    }
}

class SutdaCard22 {
    final int NUM;
    final boolean ISKWANG;

    SutdaCard22() {
        this(1, true);
    }

    SutdaCard22(int NUM, boolean ISKWANG) {
        this.NUM = NUM;
        this.ISKWANG = ISKWANG;
    }

    public String toString() {
        return NUM + (ISKWANG ? "K" : "");
    }
}
