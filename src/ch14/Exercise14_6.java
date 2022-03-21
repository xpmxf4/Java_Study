package ch14;

import java.util.stream.Stream;

public class Exercise14_6 { // 문자열 배열 strArr 의 문자열 중에서 가장 긴 것의 길이를 출력하시오
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};
        int result = Stream.of(strArr)
                .map(String::length)
                .reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(result);
    }
}
