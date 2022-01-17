package ch10;

import java.util.*;
import java.text.*;

public class Exercise10_4$$ {
    public static void main(String[] args) {
//        String[] WEEK_OF_DAYS = {"일", "월", "화", "수", "목", "금", "토"};
        Scanner s = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat df2 = new SimpleDateFormat("입력하신 날짜는 E요일 입니다");
        Calendar cal = Calendar.getInstance();
        cal.clear();

        System.out.println("날짜를 yyyy/MM/dd 의 형태로 입력해주세요. (입력예:2007/05/11)");
        System.out.print(">>");
        Date d = null;

        while (true) {
            String input = s.nextLine();

            if (input.equals("q")) {
                System.out.println("시스템을 종료합니다.");
                break;
            } else {
                try {
//                    Date d = df.parse(input);
                    d = df.parse(input);
                    cal.setTime(d);
                    System.out.println(df2.format(d));
                    break;
                } catch (Exception e) {
                    System.out.println("날짜를 yyyy/MM/dd 의 형태로 입력해주세요. (입력예:2007/05/11)");
                    System.out.print(">>");
                }
            }

        }

    }
}
