package ch4;

import java.util.*;

public class FlowEx32 {
    public static void main(String[] args){
        int menu = 0;
        int num = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1,2,3 중 원하는 메뉴를 선택하세요");
            menu = scanner.nextInt();

            if (menu == 0) {
                System.out.println("메뉴 선정 프로그램을 종료합니다");
                break;
            } else if (menu < 1 || menu > 3) {
                System.out.println("없는 메뉴를 선택하셨습니다");
                continue;
            }
            break;
        }
        System.out.printf("선택하신 메뉴는 %s 입니다",menu);
    }
}
