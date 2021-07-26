package ch4;

import java.util.*;
public class FlowEx25 {
    public static void main(String[] args){
        System.out.print("숫자를 입력해주세요>");
        int num = 0, sum = 0;

        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();

        while (num != 0) {
            sum += num % 10;
            System.out.printf("sum = %2d num = %d%n", sum, num);
            num /= 10;
        }

        System.out.printf("sum = %d", sum);
    }
}
