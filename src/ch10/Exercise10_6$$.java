package ch10;

import java.util.*;

public class Exercise10_6$$ {
    public static void main(String[] args) {
        Calendar bDay = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        bDay.clear();
        today.clear();

        bDay.set(2000, 0, 1);
        today.set(2016, 0, 29);

        // casting 이 잘돗
        int diffDays = (int) ((today.getTimeInMillis() - bDay.getTimeInMillis()) / (1000 * 24 * 60 * 60));
        System.out.println(diffDays+" days");

    }
}
