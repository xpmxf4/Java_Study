package ch14;

// 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.

import java.util.*;
import java.util.stream.*;

public class Exercise14_4 {
    public static void main(String[] args){
        Stream<Integer> die = IntStream.rangeClosed(1, 6).boxed();

        die.flatMap(i -> Stream.of(1, 2, 3, 4, 5, 6).map(i2 -> new int[]{i, i2}))
                .filter(iArr -> iArr[0] + iArr[1] == 6)
                .forEach(arr -> System.out.println(Arrays.toString(arr)));


    }
}
