package ch12;

import java.util.ArrayList;




public class Ex12_4 {
    public static void main(String[] args) {
        FruitBox2<Fruit2> fruitBox2 = new FruitBox2<>();
        FruitBox2<Grape2> grapeBox = new FruitBox2<>();
        grapeBox.add(new Grape2());
        grapeBox.add(new Grape2());
        grapeBox.add(new Grape2());
        // Fruit2 와 그 자손들(Apple, Grape)
        FruitBox2<? super Fruit2> testBox = new FruitBox2<>();

        FruitBox2<? extends Fruit2> appleBox = grapeBox;

        testBox.add(new Fruit2());
        testBox.add(new Grape2());



        System.out.println("grapeBox = " + grapeBox);
        System.out.println("appleBox = " + appleBox);
        System.out.println("Juicer.makeJuice(grapeBox) = " + Juicer.makeJuice(grapeBox));
    }
}


class Fruit2 {
    public String toString() {
        return "Fruit";
    }
}

class Apple2 extends Fruit2 {
    public String toString() {
        return "Apple";
    }
}

class Grape2 extends Fruit2 {
    public String toString() {
        return "Grape";
    }
}

class Juice {
    String name;

    Juice(String name) {
        this.name = name + "Juice";
    }

    public String toString() {
        return name;
    }
}

class FruitBox2<T extends Fruit2> extends Box2<T>{

}

class Box2<T>{
    ArrayList<T> list = new ArrayList<>();
    void add(T item){
        list.add(item);
    }
    T get(int i) {
        return list.get(i);
    }

    ArrayList<T> getList() {
        return list;
    }
    int size(){
        return list.size();
    }
    public String toString() {
        return list.toString();
    }
}

class Juicer {
    static Juice makeJuice(FruitBox2<? extends Fruit2> fruitBox){
        String tmp = "";

        for(Fruit2 f : fruitBox.getList()){
            tmp += f + "";
        }

        return new Juice(tmp);
    }




}