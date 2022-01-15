package ch10;

import java.util.Calendar;

public class Ex10_1 {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR));
        System.out.println("월(0~11, 0 : 1월) : " + today.get(Calendar.MONTH));
        System.out.println("이 해의 몇 째 주 : " + today.get(Calendar.WEEK_OF_YEAR));
        System.out.println("이 달의 몇 째 주 : " + today.get(Calendar.WEEK_OF_MONTH));

        System.out.println("이 달의 몇 일 : " + today.get(Calendar.DAY_OF_MONTH));
        System.out.println("이 달의 몇 일 : " + today.get(Calendar.DATE));
        System.out.println("이 해의 몇 일 : " + today.get(Calendar.DAY_OF_YEAR));
        System.out.println("요일(1~7), 1 : 일요일 : " + today.get(Calendar.DAY_OF_WEEK));
        System.out.println("이 달의 몇 째 요일 " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));

        System.out.println("오전_오후(0:오전, 1:오후) : " + today.get(Calendar.AM_PM));
        System.out.println("시간(0~11) : " + today.get(Calendar.HOUR));
        System.out.println("시간(0~23) : " + today.get(Calendar.HOUR_OF_DAY));
        System.out.println("분 : " + today.get(Calendar.MINUTE));
        System.out.println("초 : " + today.get(Calendar.SECOND));

        System.out.println("GMT : " + today.get(Calendar.ZONE_OFFSET));
        System.out.println("이 달의 마지막 날 : " + today.getActualMaximum(Calendar.DATE));
    }
}
