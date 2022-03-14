package ch14;

import java.util.*;
import static java.util.stream.Collectors.groupingBy;
import java.util.stream.Stream;

class Student3 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    Student3(String name, boolean isMale, int hak, int ban, int score){
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    String getName(){return name;}
    boolean isMale(){return isMale;}
    int getHak(){return hak;}
    int getBan(){return ban;}
    int getScore(){return score;}

    public String toString(){
        return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
    }

    enum level {HIGH, MID, LOW,}        // 성적을 상, 중, 하 로 분류함
}

public class Ex14_11 {
    public static void main(String[] args) {
        Student3[] stuArr = {
                new Student3("나자바", true,  1, 1, 300),
                new Student3("김지미", false, 1, 1, 250),
                new Student3("김자바", true,  1, 1, 200),
                new Student3("이지미", false, 1, 2, 150),
                new Student3("남자바", true,  1, 2, 100),
                new Student3("안지미", false, 1, 2,  50),
                new Student3("황지미", false, 1, 3, 100),
                new Student3("강지미", false, 1, 3, 150),
                new Student3("이자바", true,  1, 3, 200),

                new Student3("나자바", true,  2, 1, 300),
                new Student3("김지미", false, 2, 1, 250),
                new Student3("김자바", true,  2, 1, 200),
                new Student3("이지미", false, 2, 2, 150),
                new Student3("남자바", true,  2, 2, 100),
                new Student3("안지미", false, 2, 2,  50),
                new Student3("황지미", false, 2, 3, 100),
                new Student3("강지미", false, 2, 3, 150),
                new Student3("이자바", true,  2, 3, 200)
        };
        System.out.println("1. 단순 그룹화");

    } // end of main
}
