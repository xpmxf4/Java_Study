package ch11;

import java.util.*;

public class Ex11_13 {
    public static void main(String[] args) {
        Set set = new TreeSet(new TestComp());    // 범위 검색, 정렬. 정렬 필요없음
        Set set2 = new HashSet();   //

        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(new Test());
        }

        for (int i = 0; set2.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set2.add(new Test());
        }

        System.out.println("set = " + set);
        System.out.println("set2 = " + set2);
    }
}

class Test {

}

class TestComp implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        return 1;
    }
}