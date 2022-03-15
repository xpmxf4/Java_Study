package ch14;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student2 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    Student2(String name, boolean isMale, int hak, int ban, int score){
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

public class Ex14_10 {
    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("나자바", true,  1, 1, 300),
                new Student2("김지미", false, 1, 1, 250),
                new Student2("김자바", true,  1, 1, 200),
                new Student2("이지미", false, 1, 2, 150),
                new Student2("남자바", true,  1, 2, 100),
                new Student2("안지미", false, 1, 2,  50),
                new Student2("황지미", false, 1, 3, 100),
                new Student2("강지미", false, 1, 3, 150),
                new Student2("이자바", true,  1, 3, 200),

                new Student2("나자바", true,  2, 1, 300),
                new Student2("김지미", false, 2, 1, 250),
                new Student2("김자바", true,  2, 1, 200),
                new Student2("이지미", false, 2, 2, 150),
                new Student2("남자바", true,  2, 2, 100),
                new Student2("안지미", false, 2, 2,  50),
                new Student2("황지미", false, 2, 3, 100),
                new Student2("강지미", false, 2, 3, 150),
                new Student2("이자바", true,  2, 3, 200)
        };

        System.out.printf("1. 단순분할(성별로 분할)\n");
        Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale));

        List<Student2> maleStu = stuBySex.get(true);
        List<Student2> femaleStu = stuBySex.get(false);

        for(Student2 s : maleStu) System.out.println(s);
        for(Student2 s : femaleStu) System.out.println(s);
        System.out.println();

        System.out.printf("\n2. 단순분할 + 통계(성별학생수)\n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale, Collectors.counting()));
        System.out.println("male num : " + stuNumBySex.get(true));
        System.out.println("female num : " + stuNumBySex.get(false));

        System.out.printf("\n3. 단순분할 + 통계(성별당 1등)");
        Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale, Collectors.maxBy(
                        Comparator.comparingInt(Student2::getScore)))); // 토 나와서 static import 해야 할듯
        System.out.println("1st male Student: " + topScoreBySex.get(true));
        System.out.println("1st female Student : " + topScoreBySex.get(false));

        Map<Boolean, Student2> topScoreBySex2 = Stream.of(stuArr)
                        .collect(Collectors.partitioningBy(Student2::isMale,
                                Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Student2::getScore)), Optional::get
                        )
                        ));
        System.out.println("1st male Student: " + topScoreBySex2.get(true));
        System.out.println("1st female Student : " + topScoreBySex2.get(false));
        System.out.println();

        System.out.print("\n4. 다중 분할(성별+불합격자=100점 이하)");
        Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale,
                        Collectors.partitioningBy(s -> s.getScore() <= 100)
                ));
        List<Student2> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Student2> failedFemaleStu = failedStuBySex.get(false).get(true);
        for(Student2 s: failedMaleStu) System.out.println(s);
        for(Student2 s: failedFemaleStu) System.out.println(s);
    }
}
