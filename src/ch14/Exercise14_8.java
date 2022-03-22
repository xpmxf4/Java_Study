package ch14;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student4 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    Student4(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    String getName() {
        return name;
    }

    boolean isMale() {
        return isMale;
    }

    int getHak() {
        return hak;
    }

    int getBan() {
        return ban;
    }

    int getScore() {
        return score;
    }

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
    }

    enum level {HIGH, MID, LOW,}        // 성적을 상, 중, 하 로 분류함
}

public class Exercise14_8 {
    public static void main(String[] args) {
        Student4[] stuArr = {
                new Student4("나자바", true,  1, 1, 300),
                new Student4("김지미", false, 1, 1, 250),
                new Student4("김자바", true,  1, 1, 200),
                new Student4("이지미", false, 1, 2, 150),
                new Student4("남자바", true,  1, 2, 100),
                new Student4("안지미", false, 1, 2,  50),
                new Student4("황지미", false, 1, 3, 100),
                new Student4("강지미", false, 1, 3, 150),
                new Student4("이자바", true,  1, 3, 200),

                new Student4("나자바", true,  2, 1, 300),
                new Student4("김지미", false, 2, 1, 250),
                new Student4("김자바", true,  2, 1, 200),
                new Student4("이지미", false, 2, 2, 150),
                new Student4("남자바", true,  2, 2, 100),
                new Student4("안지미", false, 2, 2,  50),
                new Student4("황지미", false, 2, 3, 100),
                new Student4("강지미", false, 2, 3, 150),
                new Student4("이자바", true,  2, 3, 200)
        };

        Map<Boolean, Map<Boolean, Long>> failedStuBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student4::isMale,
                        partitioningBy(s -> s.getScore() < 150, counting())));
        long failedMaleStuNum = failedStuBySex.get(true).get(true);
        long failedFemaleStuNum = failedStuBySex.get(false).get(true);

        System.out.println("불합격[남자]: " + failedMaleStuNum + " 명");
        System.out.println("불합격[여자]: " + failedFemaleStuNum + " 명");
    }
}
