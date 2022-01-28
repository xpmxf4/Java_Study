package ch12;

import java.util.*;

class Fruit444 {
    String name;
    int weight;

    Fruit444(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

class Apple444 extends Fruit444 {
    Apple444(String name, int weight) {
        super(name, weight);
    }
}

class Grape444 extends Fruit444 {
    Grape444(String name, int weight) {
        super(name, weight);
    }
}

class Apple444Comp implements Comparator<Apple444> {
    @Override
    public int compare(Apple444 o1, Apple444 o2) {
        return o2.weight - o1.weight;
    }
}

class Grape444Comp implements Comparator<Grape444> {
    @Override
    public int compare(Grape444 o1, Grape444 o2) {
        return o2.weight - o1.weight;
    }
}

class Fruit444Comp implements Comparator<Fruit444> {
    @Override
    public int compare(Fruit444 o1, Fruit444 o2) {
        return o2.weight - o1.weight;
    }
}

public class FruitBoxEx4 {
    public static void main(String[] args) {
        Fruit444Box<Apple444> appleBox = new Fruit444Box<>();
        Fruit444Box<Grape444> grapeBox = new Fruit444Box<>();

        appleBox.add(new Apple444("GreenApple", 300));
        appleBox.add(new Apple444("GreenApple", 100));
        appleBox.add(new Apple444("GreenApple", 200));

        grapeBox.add(new Grape444("GreenGrape", 400));
        grapeBox.add(new Grape444("GreenGrape", 300));
        grapeBox.add(new Grape444("GreenGrape", 200));

        Collections.sort(appleBox.getList(), new Apple444Comp());
        Collections.sort(grapeBox.getList(), new Grape444Comp());
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);

        System.out.println();
        System.out.println();

        Collections.sort(appleBox.getList(), new Fruit444Comp());
        Collections.sort(grapeBox.getList(), new Fruit444Comp());
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);
    }
}

class Fruit444Box<T extends Fruit444> extends Box444<T> {

}

class Box444<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    ArrayList<T> getList(){
        return list;
    }

    int size(){
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
