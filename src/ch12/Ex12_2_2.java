package ch12;

import java.util.*;

public class Ex12_2_2 {
    public static void main(String[] args) {
//        HashMap<String, Student22> map = new HashMap<String, Student22>(); 이지만, 1.7 부터 아래처럼 생략 가능함!
        HashMap<String, Student22> map = new HashMap<>();

        map.put("자바왕", new Student22("자바왕", 1, 1, 100, 100, 100));
        System.out.println("testing : " + map.put("박채훈", new Student22("박채훈", 2, 2, 90, 90, 90)));
//        Student22 s = (Student22)map.get("자바왕"); 옛날엔 이렇게
        Student22 s = map.get("자바왕");

        System.out.println("map = " + map);
    }
}

class Student22 {
    String name = "";
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    Student22(String name, int ban, int no, int kor, int eng, int math){
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}
