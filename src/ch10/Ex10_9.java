package ch10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ex10_9 {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

        try{
            Date d = df.parse("2022년 01월 15일"); // 하나라도 형식 틀리면 catch 로 넘어감
            System.out.println("df2.format(d) = " + df2.format(d)); // 날짜 -> 형식 문자열
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
