package ch5;

public class Exercise5_11$$ {
    public static void main(String[] args) {
        int[][] score = {
                {100, 100, 100},
                {20, 20, 20},
                {30, 30, 30},
                {40, 40, 40},
                {50, 50, 50}
        };

        int[][] result = new int[score.length + 1][score[0].length + 1];

        for (int i = 0; i < score.length; i++) {                // 0 <= i <= 5
            for (int j = 0; j < score[i].length; j++) {         // 0 <= j <= 3

                result[i][j] = score[i][j];                     // result 에 score 복사
                result[i][score[i].length] += result[i][j];     // 우측에 가로합 더하기

//                System.out.printf("result[score.length = 5][%d] = %d, result[%d][%d] = %d%n",j,result[score.length][j],i,j, result[i][j]);
                result[score.length][j] += result[i][j];        // 100 100 100 이 각각의 j 에 해당하는 곳으로 더해짐

                result[score.length][score[0].length] += result[i][j];
            }

        }

        for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.printf("%4d", result[i][j]);
                }
                System.out.println();
        } // main
    }
}