package ch12;

import java.util.ArrayList;

class Tv1 {
}

class Audio1 {

}

public class GenericTest2 {
    public static void main(String[] args) {
        ArrayList<Tv1> list = new ArrayList<Tv1>();
        ArrayList list2 = new ArrayList();
        list.add(new Tv1());
        list2.add(new Tv1());

//        list.add(new Audio1()); 에러


        Tv1 t = list.get(0);
        Tv1 t2 = (Tv1) list2.get(0);

        System.out.println("t = " + t);
        System.out.println("t2 = " + t2);
    }
}
