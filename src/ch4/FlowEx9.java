package ch4;

import java.util.*;

public class FlowEx9 {
    public static void main(String[] args){
        char grade = ' ';
        System.out.print("당신의 점수를 입력하시오");

        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();

        switch (score / 10) {
            case 10: case 9:    //  이걸 일일히 case 100, 99, 98 ... 이건 극혐이니까, 이렇게 스마트하게 조건식으로 나누는 것이 중요하다.
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            default:
                grade = 'D';
        }

        System.out.printf("당신의 학점은 %c입니다", grade);
    }
}
