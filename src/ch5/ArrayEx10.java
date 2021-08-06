package ch5;

import java.util.Arrays;

public class ArrayEx10 {
    public static void main(String[] args) {
        int[] numArr = new int[5];                                      // 요소가 정수인 크기가 5인 배열 선언

        for (int i = 0; i < numArr.length; i++) {
            System.out.print(numArr[i] = (int) (Math.random() * 10));   // 0~9 사이 랜덤한 값 부여
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < numArr.length-1; i++) {                     // numArr 길이(5) - 1 = 4 만큼 loop 실행
            boolean changed = false;

            for (int j = 0; j < numArr.length - 1 - i; j++) {           // numArr 길이(5) - 1 - i = 4 - i 만큼 loop 실행
                if (numArr[j] > numArr[j + 1]) {                        // i = 0, j = 0 일때, numArr[0] > numArr[0] 이면

                    int temp = numArr[j];
                    numArr[j] = numArr[j + 1];                          // numArr[j] 하고 numArr[j+1] 하고 위치 전환
                    numArr[j + 1] = temp;
                    changed = true;
                }
            }

            if(!changed) break;

            for (int k = 0; k < numArr.length; k++) {
                System.out.print(numArr[k]);
            }
            System.out.println();
        }
    }

}
