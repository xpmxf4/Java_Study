package ch10;

import java.util.*;
import java.text.*;

public class Exercise10_5 {
    static int getDayDiff(String yyyymmdd1, String yyyymmdd2){
        int diff = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        // 근데 이렇게 하니까 어지롭다. 문제풀이대로 subString 으로 해결하는 게 성능도 더 좋다.
        Date date1 = null;
        Date date2 = null;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.clear();
        cal2.clear();

        try {
            date1 = sdf.parse(yyyymmdd1);
            date2 = sdf.parse(yyyymmdd2);
            cal1.setTime(date1);
            cal2.setTime(date2);
            diff = (int)((cal1.getTimeInMillis() - cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24)) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(getDayDiff("20010103", "20010101"));
        System.out.println(getDayDiff("20010103", "20010103"));
        System.out.println(getDayDiff("20010103", "200103"));

    }
}