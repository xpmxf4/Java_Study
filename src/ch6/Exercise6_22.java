package ch6;

public class Exercise6_22 {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));


        str = "1234o";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));
    }

    static boolean isNumber(String str) {
        if (str == null || str.equals("")) return false;
        for (int i = 0; i < str.length(); i++) {
            if ('9' < str.charAt(i) || str.charAt(i) < '0') return false;
        }
        return true;
    }
}
