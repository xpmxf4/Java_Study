package ch4;

import java.util.*;

public class FlowEx7 {
    public static void main(String[] args){
        System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력하세요");

        Scanner scanner = new Scanner(System.in);
        int user = scanner.nextInt();
        int com = (int) (Math.random() * 3 + 1);    // 이거 +1 을 괄호안에 넣나 안 넣나 똑같지 않나?

        switch (user - com) {
            case 2: case -1:
                System.out.println("com이 이김");
                break;
            case 1: case -2:
                System.out.println("당신이 이겼습니다");
                break;
            default:
                System.out.println("비김");

        }
    }
}
