package ch10;

import java.util.Calendar;

public class Ex10_2 {   // 날짜 계산
    public static void main(String[] args) {
        final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();    //오늘

        date1.set(2019, 3, 29); //2019년 4월 29일
        System.out.println("date1 은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"요일");
        System.out.println("date2 : " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일");

        long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
        long dayDiff = difference / (24 * 60 * 60);

        System.out.println(difference + " s 가 지났습니다 (double)");
        System.out.println("dayDiff = " + dayDiff);
    }

    public static String toString(Calendar date){
        return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";
    }
}
