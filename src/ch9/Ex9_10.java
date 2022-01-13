package ch9;

public class Ex9_10 {
    public static void main(String[] args) {
        int iVal = 100;
//        String strVal = iVal + "";
        String strVal = String.valueOf(iVal);

        double dVal = 200.0;
        String strVal2 = dVal + "";

        //문자열을 숫자로 바꾸는 법
        double sum = Integer.parseInt(strVal) + Double.parseDouble(strVal2);

        double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);

        System.out.println("strVal = " + strVal);
        System.out.println("sum = " + sum);
        System.out.println("sum2 = " + sum2);
        System.out.println(String.join("", strVal, "+" , strVal2, "=")+ sum);
    }
}
