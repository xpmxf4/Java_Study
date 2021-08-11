package ch5;

// arr 의 총 갯수를 새로운 변수 선언을 통해는 할 수 있는 데, 주어진 조건에서 새로운 변수 사용 없이
// 하는 것는 모르겠음

public class Exercise5_4$$ {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 5, 5, 5, 5},
                {10, 10, 10, 10, 10},
                {20, 20, 20, 20, 20},
                {30, 30, 30, 30, 30}
        };

        int total = 0;
        float average = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                total += arr[i][j];
                average++;
            }
        }

        average = total / average;

        System.out.println("total = " + total);
        System.out.println("average = " + average);

    }
}
