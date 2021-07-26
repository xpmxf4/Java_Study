package ch4;

import java.util.*;

public class FlowEx8 {
    public static void main(String[] args){
        System.out.print("당신의 주민번호를 입력하센");

        Scanner scanner = new Scanner(System.in);
        String regNo = scanner.nextLine();

        char gender = regNo.charAt(7);

        switch (gender) {   // char는 문자이다. 하지만 char 타입은 사실 유니코드로 저장이 되기 때문에, switch 조건식안에 넣을 수 있음!
            case '1': case '3':
                System.out.println("당신은 남자입니다");
                break;
            case '2': case '4':
                System.out.println("당신은 여자입니다");
                break;
            default:
                System.out.println("유효하지 않은 숫자입니다");

        }
    }
}
