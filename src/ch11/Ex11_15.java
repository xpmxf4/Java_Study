package ch11;

import java.util.*;

public class Ex11_15 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

        for (int i : score) set.add(i);

        System.out.println(set);
        System.out.println("set.first() = " + set.first());
        System.out.println("set.last() = " + set.last());
        System.out.println("50보다 작은 값 : " + set.headSet(50));
        System.out.println("50보다 큰 값 : " + set.tailSet(50));
        System.out.println("40 부터 80 사이의 값 : " + set.subSet(40, 80));
    }
}