package ch5;

import java.util.Arrays;

//두 행렬 2x3  과 3x2 의 곱셈을 해결하는 것
public class MultiArrEx3 {
    public static void main(String[] args) {
        int[][] m1 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] m2 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[][] m3 = new int[2][2];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0 ; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    m3[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }


        System.out.println();
        for(int[] i :m3)
            System.out.println(Arrays.toString(i));
    }
}
