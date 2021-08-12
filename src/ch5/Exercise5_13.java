package ch5;

import java.util.*;

public class Exercise5_13 {
    public static void main(String[] args) {
        String[] words = {"television", "computer", "mouse", "phone"};

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < words.length; i++) {
            char[] question = words[i].toCharArray();

            for(int j = 0 ; j < question.length; j++){
                int randomIndex = (int) (Math.random() * question.length);
                char tmp = question[j];
                question[j] = question[randomIndex];
                question[randomIndex] = tmp;
            }

            System.out.printf("Q%d. %s의 정답을 입력하세요.>", i+1, new String(question));
            String answer = scanner.nextLine();

            if (answer.trim().equals(words[i])) {       // trim 은 좌우공백 없애줌. 문자열 중간에 공백은 못 없앰
                System.out.println("정답입니다!");
            }else{
                System.out.println("오답입니다!");
            }
        }
    }
}
