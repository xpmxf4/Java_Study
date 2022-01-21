package ch11;

import java.util.*;

public class Ex11_7 {
    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr);
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분 ㄴㄴ
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

    }
}

class Descending implements Comparator {
    public int compare(Object o1, Object o2){
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            // Comparable 를 구현한 자손 클래스들의 객체들만 올 수 있다고 한 거.
            // Comparable 를 구현한 클래스의 객체가 아니면, 비교를 할 수가 없다.
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1;
//            return c2.compareTo(c1);
        }

        return -1;  //
    }
}