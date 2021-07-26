package ch4;

import java.util.Scanner;

public class FlowEx27 {
    public static void main(String[] args){
        int num;
        int sum = 0;
        boolean flag = true;


        System.out.println("합계를 구할 숫자를 입력하세요");
        Scanner scanner = new Scanner(System.in);   // 이걸 적는 다고 터미널에서 입력하라고 하는 게 아니라,
        while (flag) {
            System.out.print(">>");
            num = scanner.nextInt();                // 이걸 적어야 터미널에서 입력을 받을 수 있는 것

            if (num != 0) {
                sum += num;
            } else {
                flag = false;
            }
        }
        System.out.printf("sum = %d", sum);
    }
}
