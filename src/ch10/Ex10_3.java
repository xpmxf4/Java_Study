package ch10;

import java.util.Calendar;

public class Ex10_3 {   // 시간 계산
    public static void main(String[] args) {
        final int[] TIME_UNIT = {3600, 60, 1};
        final String[] TIME_UNIT_NAME = {"시간", "분", "초"};

        Calendar time1 = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();

        //시간 10시 20분 30초 로 set
        time1.set(Calendar.HOUR_OF_DAY, 10);
        time1.set(Calendar.MINUTE, 20);
        time1.set(Calendar.SECOND, 30);

        time2.set(Calendar.HOUR_OF_DAY, 20);
        time2.set(Calendar.MINUTE, 30);
        time2.set(Calendar.SECOND, 10);

        long differnce = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) / 1000;

        String tmp = "";
        for (int i = 0; i < TIME_UNIT.length; i++) {
            tmp += differnce / TIME_UNIT[i] + TIME_UNIT_NAME[i];
            differnce %= TIME_UNIT[i];
        }

        System.out.println("시분초로 변환하면 " + tmp + "입니다");
    }
}
