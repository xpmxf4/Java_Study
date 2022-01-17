package ch10;

import java.util.*;
import java.text.*;

public class Exercise10_2 {
    public static void main(String[] args) {
        Calendar fromCal = Calendar.getInstance();
        Calendar toCal = Calendar.getInstance();

        fromCal.set(2010, 0, 1);
        toCal.set(2010, 0, 1);
        printResult(fromCal, toCal);

        fromCal.set(2010, 0, 21);
        toCal.set(2010, 0, 21);
        printResult(fromCal, toCal);

        fromCal.set(2010, 0, 1);
        toCal.set(2010, 2, 1);
        printResult(fromCal, toCal);

        fromCal.set(2010, 0, 1);
        toCal.set(2010, 2, 23);
        printResult(fromCal, toCal);

        fromCal.set(2010, 0, 23);
        toCal.set(2010, 2, 21);
        printResult(fromCal, toCal);

        fromCal.set(2011, 0, 22);
        toCal.set(2010, 2, 21);
        printResult(fromCal, toCal);
    }

    static int payCheckCount(Calendar from, Calendar to) {

        if (from == null || to == null) return 0;
        if (from.equals(to) && from.get(Calendar.DAY_OF_MONTH) == 21) {
            return 1;
        }

        int fromYear = from.get(Calendar.YEAR);
        int fromMon = from.get(Calendar.MONTH);
        int fromDay = from.get(Calendar.DAY_OF_MONTH);
        int toYear = to.get(Calendar.YEAR);
        int toMon = to.get(Calendar.MONTH);
        int toDay = to.get(Calendar.DAY_OF_MONTH);


//        int monDiff = to.get(Calendar.MONTH) - from.get(Calendar.MONTH);
        int monDiff = (toYear * 12 + toMon) - (fromYear * 12 + fromMon);

        if (monDiff < 0) return 0;
        if (from.get(Calendar.DAY_OF_MONTH) <= 21 && to.get(Calendar.DAY_OF_MONTH) >= 21) monDiff++;
        if (from.get(Calendar.DAY_OF_MONTH) > 21 && to.get(Calendar.DAY_OF_MONTH) < 21) monDiff--;

        return monDiff;
    }

    static void printResult(Calendar from, Calendar to) {
        Date fromDate = from.getTime();
        Date toDate = to.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print(sdf.format(fromDate) + " ~ "
                + sdf.format(toDate) + ":");
        System.out.println(payCheckCount(from, to));
    }
}
