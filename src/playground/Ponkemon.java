package playground;

import java.util.*;

public class Ponkemon {
    public static void main(String[] args) {
        System.out.println("solution(pro1) = " + solution(pro1));
        System.out.println();
        System.out.println("solution(pro2) = " + solution(pro2));
        System.out.println();
        System.out.println("solution(pro3) = " + solution(pro3));
    }

    public static int solution(int[] nums) {
        int takeSize = nums.length / 2;
        HashSet<Integer> existedIntArr = new HashSet<>();
        int count = 0;

        for(int i : nums){
            if (!existedIntArr.contains(i)) {
                count++;
                existedIntArr.add(i);
            }
        }

        System.out.println("takeSize = " + takeSize);
        System.out.println("count = " + count);

        return Math.min(takeSize, count);
    }

    public static final int[] pro1 = {3, 1, 2, 3};
    public static final int[] pro2 = {3, 3, 3, 2, 2, 4};
    public static final int[] pro3 = {3, 3, 3, 2, 2, 2};

}
