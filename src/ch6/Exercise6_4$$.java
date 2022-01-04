package ch6;

public class Exercise6_4$$ {
    public static void main(String[] args) {
        Student s = new Student("홍길동", 1, 1, 100, 60, 76);

        System.out.println("총점:" + s.getTotal());
        System.out.println("평균:" + s.getAverage());
        System.out.println(s.info());
    }
}

class Student {
    private String name;
    private int ban;
    private int no;
    private int kor;
    private int eng;
    private int math;

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal() {
//        return this.math + this.eng + this.kor;
        return math + eng + kor;
    }

    float getAverage() {
        int total = getTotal();

//        return ((int) ((float) total / 3 * 10 + 0.5F)) / 10f;
        return (int) (total / 3f * 10 + 0.5) / 10f;
    }

    String info() {
//        return this.name +','+ this.ban+','+this.no+','+this.kor+','+this.eng+','+this.math;
        return name + ',' + ban + ',' + no + ',' + kor + ',' + eng + ',' + math + getTotal() + getAverage();
    }

}

