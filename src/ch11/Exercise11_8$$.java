package ch11;

import java.util.*;

public class Exercise11_8$$ {
    public static void calculateSchoolRank(List list) {
        Collections.sort(list); // 먼저 list 를 총점기준 내림차순으로 정렬한다.

        int prevRank = -1; // 이전 전교등수
        int prevTotal = -1; // 이전 총점
        int length = list.size();

//        int sameTime = 0;
//        for (int i = 0; i < length; i++) {
//            Student4 cameIn = (Student4) list.get(i);
//
//            if (cameIn.getTotal() == prevTotal) {
//                cameIn.schoolRank = prevRank;
//                sameTime++;
//            } else if (cameIn.getTotal() > prevTotal) {   // 맨 처음
//                cameIn.schoolRank = 1;
//                prevTotal = cameIn.getTotal();
//                prevRank = 1;
//            } else {  // cameIn.getTotal() < prevTotal
//                cameIn.schoolRank = ++prevRank + sameTime;
//                prevTotal = cameIn.getTotal();
//                sameTime = 0;
//            }
//        }
        for (int i = 0; i < length; i++) {
            Student4 stu = (Student4) (list.get(i));

            if (stu.getTotal() == prevTotal) {
                stu.schoolRank = prevRank;

            } else {
                stu.schoolRank = i+1;
            }

            prevRank = stu.schoolRank;
            prevTotal = stu.total;
        }
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student4("이자바", 2, 1, 70, 90, 70));
        list.add(new Student4("이자바", 2, 1, 70, 90, 70));
        list.add(new Student4("확인용", 2, 1, 30, 30, 30));
        list.add(new Student4("안자바", 2, 2, 60, 100, 80));
        list.add(new Student4("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student4("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student4("김자바 ", 1, 2, 80, 80, 90));


        calculateSchoolRank(list);
        Iterator it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());

    }
}

class Student4 implements Comparable {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;
    int total; // 총점
    int schoolRank; // 전교등수

    Student4(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        total = kor + eng + math;
    }

    int getTotal() {
        return total;
    }

    float getAverage() {
        return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
    }

    public int compareTo(Object o) {
        if (o instanceof Student4) {
            Student4 cameIn = (Student4) o;
            return cameIn.getTotal() - this.getTotal();   // 내림차순 구현
        }

        return -1;  // 여기 처리를 어떻게 하지
    }

    public String toString() {
        return name
                + "," + ban
                + "," + no
                + "," + kor
                + "," + eng
                + "," + math
                + "," + getTotal()
                + "," + getAverage()
                + "," + schoolRank;
    }
} // class Student
