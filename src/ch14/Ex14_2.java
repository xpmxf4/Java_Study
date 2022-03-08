package ch14;

import java.util.*;
import java.util.function.*;

public class Ex14_2 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> c = i -> System.out.printf(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0;
        Function<Integer, Integer> f = i -> i / 10 * 10;

        List<Integer> list = new ArrayList<>();

        makeRandomList(s, list);
        System.out.println("list = " + list);

        printEvenNumber(p, list, c);
        System.out.println();
        System.out.println("eraseUnits(f,list) = " + eraseUnits(f,list));
    }

    static <T> void makeRandomList(Supplier<T> supplier, List<T> list){
        for (int i = 0; i < 10; i++) {
            list.add(supplier.get());
        }
    }

    static <T> void printEvenNumber(Predicate<T> predicate, List<T> list, Consumer<T> consumer){
        System.out.printf("[");
        for(T num : list){
            if(predicate.test(num)) consumer.accept(num);
        }
        System.out.printf("]");
    }

    static <T> List<T> eraseUnits(Function<T, T> function, List<T> list){
        List<T> newList = new ArrayList<>();

        for(T num : list){
            newList.add(function.apply(num));
        }

        return newList;
    }
//    public static void main(String[] args) {
//        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
//        Consumer<Integer> c = i -> System.out.print(i + ", ");
//        Predicate<Integer> p = i -> i % 2 == 0;
//        Function<Integer, Integer> f = i -> i / 10 * 10; // 1의 자리 없애기
//
//        List<Integer> list = new ArrayList<>();
//
//        makeRandomList(s, list);
//        System.out.println(list);
//
//        printEvenNum(c, p, list);
//        System.out.println();
//
//        List<Integer> newList = doSomething(f, list);
//        System.out.println(newList);
//    }

//    static <T> List<T> doSomething(Function<T,T> f, List<T> list){
//        List<T> newList = new ArrayList<>(list.size());
//
//        for(T i : list){
//            newList.add(f.apply(i));
//        }
//
//        return newList;
//    }
//
//    static <T> void printEvenNum(Consumer<T> c, Predicate<T> p, List<T> list) {
//        System.out.print("[");
//        for (T i : list) {
//            if (p.test(i)) c.accept(i);
//        }
//        System.out.print("]");
//    }
//
//    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
//        for (int i = 0; i < 10; i++) {
//            list.add(s.get());
//        }
//    }
}
