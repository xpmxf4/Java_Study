package ch9;

public class StringToNumber {
    public static void main(String[] args) {

        System.out.println("i = " + Integer.parseInt("100"));
        System.out.println("i = " + Integer.parseInt("100",10));    //위와 동일
        System.out.println("i = " + Integer.parseInt("100",2));     // 2진수
        System.out.println("i = " + Integer.parseInt("FF",16));     // 16진수

    }
}
