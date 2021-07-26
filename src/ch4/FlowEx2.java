package ch4;

import java.util.Scanner;

public class FlowEx2 {
    public static void main(String[] args){
        int input ; //  int 자료형의 input 이라는 변수를 선언만 한 것 이라고 이해하는 데, 이걸 초기화도 해야 되지 않나?
                    //  print 로 찍으면, initialized(초기화)가 안되었다고 뜬다.
                    //  즉 선언은 되는 데, 프린트를 못 찍음!

        System.out.print("숫자를 하나 입력하세요.>");

        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        input = Integer.parseInt(tmp);

        if (input == 0) {
            System.out.println("입력하신 숫자는 0입니다");
        }

        if (input != 0) {
            System.out.println("입력하신 숫자는 0이 아니고");
            System.out.printf("%d입니다", input);
        }
    }
}
