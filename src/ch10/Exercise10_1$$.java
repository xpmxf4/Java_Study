package ch10;

import java.text.SimpleDateFormat;
import java.util.*;

public class Exercise10_1$$ {
    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar cal = Calendar.getInstance();
//        cal.clear();
//        cal.set(Calendar.YEAR, 2010);
//
//        for (int i = 0; i < 12; i++) {
//            cal.set(Calendar.MONTH, i);
//            cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 2);
//            Date date = new Date(cal.getTimeInMillis());
//            System.out.println(sdf.format(date) + "은 2번째 일요일입니다.");
//        }

        Calendar cal = Calendar.getInstance();

        cal.clear();
        cal.set(2010, 0, 1);

        for (int i = 0; i < 12; i++) {
            int weekday = cal.get(Calendar.DAY_OF_WEEK);    // 1~7

            int secondSunday = (weekday == 1) ? 8 : 16 - weekday;

            cal.set(Calendar.DAY_OF_MONTH, secondSunday);

            Date d = cal.getTime();
            System.out.println(new SimpleDateFormat("yyyy-MM-dd 은 F번째 E요일입니다").format(d));

            cal.add(Calendar.MONTH, 1);
            cal.set(Calendar.DAY_OF_MONTH, 1);
        }

    }
}
