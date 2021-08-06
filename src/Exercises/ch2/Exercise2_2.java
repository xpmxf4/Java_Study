package Exercises.ch2;

//[2-2] 주민등록번호를 숫자로 저장하고자 한다 이 값을 저장하기 위해서는 어떤 자료형 .
//(data type) 을 선택해야 할까? regNo 라는 이름의 변수를 선언하고 자신의 주민등록번호로
//초기화 하는 한 줄의 코드를 적으시오.

import java.util.*;

public class Exercise2_2 {
    public static void main(String[] args) {
        //숫자로 저장해야 하니까 정수형중 int를 선택함. 주민번호 13자리를 저장하는 데 byte,short는 부족함.
        //그리고 주민번호라 13자리 넘어갈 일도 없으니
        //int 가 나음

        System.out.print("주민번호를 입력해주세요.>");
        Scanner scanner = new Scanner(System.in);

        long regNo = scanner.nextLong();

        System.out.print(regNo);
//        System.out.printf("입력된 주민번호는 %d 입니다", regNo);
    }
}
