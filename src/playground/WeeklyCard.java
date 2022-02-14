package playground;

import java.util.Arrays;

public class WeeklyCard {
    public static void main(String[] args) {
        System.out.println("solution(pro1) = " + solution(pro1));
    }

//    public static int solution(int[][] sizes) {
//        int answer = 0;
//        int sizes_length = sizes.length;
//        int big = 0;
//        int small = 0;
//
//        for (int[] size : sizes) {
//            Arrays.sort(size);
//        }
//
//        for (int i = 0; i < sizes_length; i++) {
//            if (small < sizes[i][0]) {
//                small = sizes[i][0];
//            }
//            if (big < sizes[i][1]) {
//                big = sizes[i][1];
//            }
//        }
//
//        answer = small * big;
//
//        return answer;
//    }

    public static int solution(int[][] sizes) {
        int length = 0;
        int height = 0;

        for (int[] size : sizes) {
            length = Math.max(length, Math.max(size[0], size[1]));
            height = Math.max(height, Math.min(size[0], size[1]));
        }

        return length * height;
    }

    public final static int[][] pro1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

}