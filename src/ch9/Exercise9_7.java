package ch9;

public class Exercise9_7 {
    static boolean contains(String str1, String str2) {
        return str1.indexOf(str2) != -1;
    }

    public static void main(String[] args) {
        System.out.println(contains("12345","23"));
        System.out.println(contains("12345","67"));
    }
}
