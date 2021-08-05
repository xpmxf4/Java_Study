package ch5;

import java.util.*;

public class MultiArrEx2 {
    public static void main(String[] args){
        final int SIZE = 5;
        int x = 0, y = 0, num = 0;

        int[][] bingo = new int[SIZE][SIZE];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                bingo[i][j] = SIZE * i + j + 1;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                x = (int) (Math.random() * 5);
                y = (int) (Math.random() * 5);

                int tmp = bingo[i][j];
                bingo[i][j] = bingo[x][y];
                bingo[x][y] = tmp;

            }
        }

        do{
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.printf("%5d", bingo[i][j]) ;
                }
                System.out.println();
            }
            System.out.println();

            System.out.printf("1~~%d의 숫자를 입력하세요.(종료:0)>", SIZE * SIZE);
            num = scanner.nextInt();

            outer:
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (bingo[i][j] == num) {
                        bingo[i][j] = 0;
                        break outer;
                    }
                }
            }

        }while(num!=0);


    }
}

