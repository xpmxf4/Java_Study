package ch10;

import java.text.*;
import java.util.*;

public class Exercise10_3$$ {
    public static void main(String[] args) {
        String data = "123,456,789.5";
        DecimalFormat df = new DecimalFormat("#,###.##");   // '.' 이전에는 3자리씩 끊어서 하기
        DecimalFormat df2 = new DecimalFormat("#,####");    // '.' 이전에는 4자리씩 끊어서 하기
        System.out.println("data : " + data);

        try{
            Number num = df.parse(data);    // 형식 문자열 -> 숫자
            double d = num.doubleValue()+0.5;
            String result = df2.format(d);   // 숫자 -> 형식 문자열
            System.out.println("반올림 : " + d);
            System.out.println("만단위 : " + result);
        }catch(Exception e){}


    }
}
