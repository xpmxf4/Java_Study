package ch10;

import java.util.*;

public class Ex10_5$$ {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage : java Ex10_5 2019 9");
            return;
        }
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int START_DAY_OF_WEEK = 0;  // 1 일의 요일
        int END_DAY = 0;            // 마지막날의 요일

        Calendar sDay = Calendar.getInstance();
        Calendar eDay = Calendar.getInstance();

        // 월의 경우 0 부터 11 까지의 값을 가지므로 1을 빼줘야 한다.
        // 예를 들어, 2019년 11월 1일은 sDay.set(year, month-1, 1);
        sDay.set(year, month - 1, 1);   //2019.9.1
        eDay.set(year, month, 1);              //2019.10.1

        // 다음날의 첫날 (
        eDay.add(Calendar.DATE, -1);        //2019.10.30

        // 첫 번째 요일이 무슨 요일인지 알아낸다. 1일이 무슨 요일인지 알아내기
        START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

        END_DAY = eDay.get(Calendar.DATE);

        // eDay 에 지정된 날짜를 얻어온다.
        System.out.println("      " + year + "년 " + month + "월");
        System.out.println(" SU MO TU WE TH FR SA");

        for (int i = 1; i < START_DAY_OF_WEEK; i++)
            System.out.print("   ");

        for (int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
            System.out.print(i < 10 ? "  " + i : " " + i);
            if (n % 7 == 0) System.out.println();
        }
    }
}
