package ch10;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Exercise10_6_answer {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(2000, 1, 1);
        LocalDate now = LocalDate.now();

        long days = birthday.until(now, ChronoUnit.DAYS);

        System.out.println("birthday = " + birthday);
        System.out.println("now = " + now);
        System.out.println("days = " + days);
    }
}
