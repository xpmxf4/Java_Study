package ch10;

import java.text.DecimalFormat;

public class Ex10_7 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        DecimalFormat df2 = new DecimalFormat("#.###E0");

        try{
            System.out.println(Double.parseDouble("1<<<234567.89"));
            Number num = df.parse("1,234,567.89");  // 형식 문자열 -> 숫자
            System.out.print("1,234,567.89" + " -> ");

            double d = num.doubleValue();   // d = 1234567.89
            System.out.print(d + " -> ");

            System.out.println(df2.format(num));    // 숫자 -> 형식 문자열
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
}
