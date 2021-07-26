package ch3;

import java.util.Scanner;

public class OperatorEx25 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char ch = ' ';

        System.out.printf("문자를 하나 입력하세요.>");

        String input = scanner.nextLine();
        ch = input.charAt(0);   //scanner 로 받으면 String 으로 들어가지만, ch는 문자열이 아닌 문자이기 때문에 chatAt() 을 통해 문자로 바꾼다.

        if('0'<= ch && ch <= '9'){
            System.out.printf("입력하신 문자는 숫자입니다.%n");
        }
        if('a' <= ch && ch <= 'z'){
            System.out.printf("입력하신 문자는 영문자입니다.%n");
        }
    }
}
