package ch4;

import java.util.*;

public class FlowEx3 {
    public static void main(String[] args){
        System.out.print("숫자를 하나 입력하세요>");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();              // input 안에 입력한 값을 int 로 넣음

        if (input == 0) {
            System.out.println("입력하신 숫자는 0임");
        } else {
            System.out.println("0을 입력하지 않아버림");
        }
    }
}
