package ch4;

import java.util.*;

public class FlowEx28 {
    public static void main(String[] args){
        int input = 0;

        int answer = (int) (Math.random() * 100 + 1);   // 1과 100사이
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("1과 100 사이의 정수를 입력하세요>");
            input = scanner.nextInt();

            if (input > answer) {
                System.out.println("입력한 숫자는 정답보다 큽니다");

            } else {
                System.out.println("입력한 숫자는 정답보다 작습니다");
            }
        } while (input != answer);

        System.out.println("정답입니다");
    }
}
