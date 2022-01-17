package ch10;

import java.util.Calendar;

public class Exercise10_7 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.clear();

        cal.set(Calendar.YEAR, 2016);
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 4);
        cal.set(Calendar.DAY_OF_WEEK, 3);

        System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DAY_OF_MONTH));
    }
}
