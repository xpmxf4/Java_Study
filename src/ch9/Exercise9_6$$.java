package ch9;

import java.util.Arrays;

class Exercise9_6$$ {
    public static String fillZero(String src, int length) {


        if (src == null || src.length() == length) return src;   // 1
        if (length <= 0) return "";                              // 2
        if (src.length() >= length) {                            // 3
            // 어차피 return 으로 돌려주기만 하면 됨.
            // 따라서 굳이 StringBuffer 로 할 필요가 없다.
            return src.substring(0, length);
        }
        char[] arr = new char[length];
        for (int i = 0; i < length; i++) {
            arr[i] = 0;
        }

        System.arraycopy(src.toCharArray(), 0, arr, src.length(), src.length());

        return new String(arr);
    }

    public static void main(String[] args) {
        String src = "12345";
        System.out.println(fillZero(src, 10));
        System.out.println(fillZero(src, -1));
        System.out.println(fillZero(src, 3));
    }
}