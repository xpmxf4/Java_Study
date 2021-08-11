package ch4;

public class Exercise4_14 {
    public static void main(String[] args) {
        int answer = (int) (Math.random() * 100 )+ 1;           // (Math.random()*100) +1 과 (Math.random() * 100 + 1) 의 차이를 확실히 알고 있자.
        int input = 0;
        int count = 0;

        java.util.Scanner s = new java.util.Scanner(System.in);

        do {
            count++;
            System.out.print("1 과 100 사이의 값을 입력하세요 > ");
            input = s.nextInt();                                // 입력받은 값을 변수 input 에 저장한다.

            if (input < answer) {
                System.out.println("더 큰 수를 입력하세요.");
            } else if (input > answer) {
                System.out.println("더 작은 수를 입력하세요");
            } else {
                System.out.println("정답입니다!");
                break;
            }

        } while (true);
        System.out.println("시도횟수는 " + count + " 번 입니다.");

    }
}
