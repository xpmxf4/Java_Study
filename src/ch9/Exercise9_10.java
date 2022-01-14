package ch9;

import java.util.Arrays;

public class Exercise9_10 {
    static String format(String str, int length, int alignment) {
        if (length < str.length()) return str.substring(0, length);  // 1. length 가 작아서 짤리는 경우

        char[] newStr = str.toCharArray();
        char[] charArr = new char[length];
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = ' ';
        } // 2. char 배열 만들고, 공백으로 채움

        if (alignment == 0) {
            System.arraycopy(newStr, 0, charArr, 0, str.length());
        } else if (alignment == 2) {
            System.arraycopy(newStr, 0, charArr, charArr.length - newStr.length, str.length());
        } else {
            System.arraycopy(newStr, 0, charArr, (charArr.length - newStr.length) / 2, str.length());
        }


        return String.valueOf(charArr);

    }

    public static void main(String[] args) {
        String str = "가나다";

        System.out.println(format(str, 2, 0)); // 왼쪽 정렬
        System.out.println(format(str, 7, 0)); // 왼쪽 정렬
        System.out.println(format(str, 7, 1)); // 가운데 정렬
        System.out.println(format(str, 7, 2)); // 오른쪽 정렬

    }
}
