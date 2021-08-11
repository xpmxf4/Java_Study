package ch4;

// 숫자로 이루어진 문자열 str 이 있을 떄, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라.
// 만일 문자열이 "12345" 라면, '1+2+3+4+5' 의 결과인 15가 출력이 되어야 한다.
// (1) 에 알맞은 코드를 넣으시오.

public class Exercise4_9$$ {
    public static void main(String[] args) {
        String str = "12345";
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 48;                // 지금 sum 이 255 가 나오는 이유는 char 를 int 로 변환 했을 때 50몇이 나옴. char -> int 니까.
            sum = sum + num;                             // 그래서 위처럼 48을 빼준다. (int) str.chatAt(i) 를 할 필요도 없는 게, int 하고 계산하면 int 로 치환되서 계산함.
        }

        System.out.println("sum= " + sum);
    }
}
