//문제점 : 숫자들의 위치가 잘 섞이지 않는다

package ch11;

import java.util.*;

public class Exercise11_10$$ {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        int[][] board = new int[5][5];

        for (int i = 0; set.size() < 25; i++) {
            set.add((int) (Math.random() * 30) + 1 + "");
        }
        System.out.println("set = " + set);
        Iterator it = set.iterator();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt((String) it.next());
                System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]);
            }
            System.out.println();
        }

    }
}
