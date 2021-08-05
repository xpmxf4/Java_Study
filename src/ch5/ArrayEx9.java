package ch5;

import java.util.Arrays;

public class ArrayEx9 {
    public static void main(String[] args) {
        int[] code = {-4, 1, -3, 6, 1};
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int randomInt = (int) (Math.random() * code.length);
            arr[i] = code[randomInt];
        }
        System.out.println(Arrays.toString(arr));

    }
}
