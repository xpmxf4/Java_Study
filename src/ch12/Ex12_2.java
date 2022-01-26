package ch12;

import java.util.*;

public class Ex12_2 {
    public static void main(String[] args) {
        ArrayList<Student2> list = new ArrayList<Student2>();
        list.add(new Student2("자바왕", 1, 1 ));
        list.add(new Student2("자바짱", 2, 2 ));
        list.add(new Student2("남궁성", 3, 3));

//        Iterator it = list.iterator();
        Iterator<Student2> it = list.iterator();

        while (it.hasNext()) {
//            Student22 s = (Student2) it.next();
//            System.out.println(s.name);
            System.out.println(it.next().name);
        }
    }
}

class Student2{
    String name = "";
    int ban;
    int no;

    Student2(String name, int ban, int no){
        this.name = name;
        this.ban = ban;
        this.no = no;
    }
}