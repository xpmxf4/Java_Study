package ch4;

// Math.random() 을 이용해서 1 부터 6 사이의 임의의 정수를
// 변수 value 에 저장하는 코드를 완성하라. (1) 에 알맞은 코드를 넣으시오.

public class Exercise4_7 {
    public static void main(String[] args) {
        int value = (int) (Math.random() * 5 + 1);

        System.out.println("value : " + value);
    }
}
