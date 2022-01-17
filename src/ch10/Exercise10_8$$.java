package ch10;

import java.util.*;

public class Exercise10_8$$ {
    public static void main(String[] args) {
        Calendar seoul = Calendar.getInstance();
        Calendar newYork = Calendar.getInstance();

        TimeZone tz = TimeZone.getTimeZone("America/New_York");
        newYork.setTimeZone(tz);

        Date seoulD = new Date(seoul.getTimeInMillis());
        Date newYorkD = new Date(newYork.getTimeInMillis());
        System.out.println("seoulD = " + seoulD);
        System.out.println("newYorkD = " + newYorkD);

        System.out.println(seoul.get(Calendar.HOUR_OF_DAY));
        System.out.println(newYork.get(Calendar.HOUR_OF_DAY));
    }
}
