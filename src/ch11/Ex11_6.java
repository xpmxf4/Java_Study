package ch11;

import java.util.*;

public class Ex11_6 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4,};
        int[][] arr2D = {{11, 12, 13}, {21, 22, 23}};

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        System.out.println("Arrays.toString(arr2D) = " + Arrays.toString(arr2D));
        System.out.println("Arrays.deepToString(arr2D) = " + Arrays.deepToString(arr2D));

        int[] arr2 = Arrays.copyOf(arr, 5); // [0,1,2,3,5]
        int[] arr3 = Arrays.copyOf(arr, 3); // [0,1,2]
        int[] arr4 = Arrays.copyOf(arr, 7); // [0,1,2,3,4,0,0]
        int[] arr5 = Arrays.copyOfRange(arr, 2, 4); // [2,3]
        int[] arr6 = Arrays.copyOfRange(arr, 0, 7); // [2,3]

        System.out.println("Arrays.toString(2) = " + Arrays.toString(arr2));
        System.out.println("Arrays.toString(3) = " + Arrays.toString(arr3));
        System.out.println("Arrays.toString(4) = " + Arrays.toString(arr4));
        System.out.println("Arrays.toString(5) = " + Arrays.toString(arr5));
        System.out.println("Arrays.toString(6) = " + Arrays.toString(arr6));

        int[] arr7 = new int[5];
        Arrays.fill(arr7, 9);
        System.out.println("Arrays.toString(arr7) = " + Arrays.toString(arr7));

        Arrays.setAll(arr7, i -> (int) (Math.random() * 6) + 1);
        System.out.println("Arrays.toString(arr7) = " + Arrays.toString(arr7));

        for (int i : arr7) {
            char[] graph = new char[i];
            Arrays.fill(graph, '*');
            System.out.println(new String(graph) + i);
        }

        String[][] str2D = {{"aaa", "bbb"}, {"AAA", "BBB"}};
        String[][] str2D2 = {{"aaa", "bbb"}, {"AAA", "BBB"}};

        System.out.println("Arrays.equals(str2D, str2D2) = " + Arrays.equals(str2D, str2D2));
        System.out.println("Arrays.deepEquals(str2D, str2D2) = " + Arrays.deepEquals(str2D, str2D2));

        char[] chArr = {'A', 'D', 'C', 'B', 'E'};

        System.out.println("Arrays.toString(chArr) = " + Arrays.toString(chArr));
        System.out.println("Arrays.binarySearch(chArr,) = " + Arrays.binarySearch(chArr,'B'));

        Arrays.sort(chArr);
        System.out.println("Arrays.toString(chArr) = " + Arrays.toString(chArr));
        System.out.println("Arrays.binarySearch() = " + Arrays.binarySearch(chArr, 'B'));

    }
}
