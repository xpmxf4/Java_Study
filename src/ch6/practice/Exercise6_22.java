package ch6.practice;

public class Exercise6_22 {
    static boolean isNumber(String str){
        if (str.equals("") || str == null) {
            return false;
        }


        for(int i = 0 ; i < str.length() ; i++){
            if(!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "123";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));

        str = "1234o";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));
    }
}
