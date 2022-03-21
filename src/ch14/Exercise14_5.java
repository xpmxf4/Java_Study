package ch14;

import java.util.stream.Stream;

public class Exercise14_5 { // 문자열 배열 strArr 의 모든 문자열의 길이를 더한 결과를 출력하시오
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        int result = Stream.of(strArr)
                .map(String::length)
                .reduce(0, Integer::sum);

        System.out.println("sum="+result);
    }
}
