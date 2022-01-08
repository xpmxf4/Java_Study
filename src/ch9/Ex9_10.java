package ch9;

public class Ex9_10 {
    public static void main(String[] args) {
        int iVal = 100;
//        String strVal = String.valueOf(iVal);
        String strVal = iVal + "";

        double dVal = 200.0;
        String strVal2 = dVal + "";

        double sum = Integer.parseInt(strVal) + Double.parseDouble(strVal2);
        double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);

        System.out.println(String.join("^", new String[]{strVal, "+", strVal2}));
    }
}
