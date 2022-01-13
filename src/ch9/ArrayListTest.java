package ch9;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(100)); // 원래는 객체만 집어넣을수 있다.
        list.add(100);                   // JDK 1.5 이전에는 에러. 기본형을 저장, 오토박싱

//        Integer i = list.get(0);
        int i = list.get(0);             // 언박싱
        System.out.println("i = " + i);
    }
}
