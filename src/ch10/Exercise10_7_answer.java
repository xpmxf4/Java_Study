package ch10;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Exercise10_7_answer {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2016, 12, 1);
        System.out.println(date.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.TUESDAY)));
    }
}
