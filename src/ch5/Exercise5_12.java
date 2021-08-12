package ch5;


import java.util.Scanner;

public class Exercise5_12 {
    public static void main(String[] args) {
        int count = 0;

        String[][] words = {
                {"chair", "의자"},
                {"computer", "컴퓨터"},
                {"integer", "정수"}
        };
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < words.length; i++) {
            System.out.printf("Q%d. %s 의 뜻은 ? ", i, words[i][0]);

            String answer = scanner.nextLine();

            if (answer.equals(words[i][1])) {
                System.out.println("정답입니다!");
                count++;
            }else{
                System.out.printf("오답입니다! 정답은 %s 였습니다.%n", words[i][1]);
            }
        }

        System.out.println("3 문제 중 "+count+ " 문제 맞히셨습니다! ");
    }
}
