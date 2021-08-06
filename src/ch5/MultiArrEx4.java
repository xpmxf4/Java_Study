package ch5;

import java.util.*;

public class MultiArrEx4 {
    public static void main(String[] args) {
        String[][] words = {
                {"chair", "의자"},
                {"computer", "컴퓨터"},
                {"integer", "상수"}
        };
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < words.length; i++) {
            System.out.printf("Q%d %s의 뜻은?", i, words[i][0]);

            String tmp = scanner.nextLine();

            if (tmp.equals(words[i][1])) {
                System.out.print("정답입니다");
            }else{
                System.out.printf("틀렸습니다. 정답은 %s 였습니다. ", words[i][1]);
            }

            System.out.println("다음 문제로 넘어가겠습니다.ㄱ");
        }
    }
}
