package ch5;

//[5-5] 다음은 1 과 9 사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는
//프로그램이다 (1)~(2) 에 알맞은 코드를 넣어서 프로그램을 완성하시오.
//[ ] 참고 Math.random() 을 사용했기 때문에 결과가 다를수도 있다.

import java.util.Arrays;

public class Exercise5_5$$ {
    public static void main(String[] args) {
        int[] ballArr = {1,2,3,4,5,6,7,8,9};
        int[] ball3 = new int[3];

        // ballArr . 배열 의 임의의 요소를 골라서 위치를 바꾼다
        for(int i=0; i< ballArr.length;i++) {                       // 0 <= i < 9, i++
            int j = (int)(Math.random() * ballArr.length);          // 0 이상 9 미만
            int tmp = 0;

            tmp = ballArr[i];
            ballArr[i] = ballArr[j];
            ballArr[j] = tmp;
        }

        //배열 ballArr 의 앞에서 3개의 수를 배열 ball3로 복사한다
        /* (2) */

//        ball3[0] = ballArr[0];
//        ball3[1] = ballArr[1];
//        ball3[2] = ballArr[2];
        System.arraycopy(ballArr, 0,ball3,0,3);

        for(int i=0;i<ball3.length;i++) {
            System.out.print(ball3[i]);
        }
    }
}