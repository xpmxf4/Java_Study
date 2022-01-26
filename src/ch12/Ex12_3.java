package ch12;

import java.util.*;

interface Eatable {

}
class Fruit implements Eatable { }
class Apple extends Fruit{
    public String toString (){
        return "Apple";
    }
}
class Grape extends Fruit{
    public String toString (){
        return "Grape";
    }
}
class Toy {
    public String toString(){
        return "Toy";
    }
}
class Ramen implements Eatable{
    public String toString() {
        return "Ramen";
    }
}

public class Ex12_3 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleFruitBox = new FruitBox<>();
        FruitBox<Grape> grapeFruitBox = new FruitBox<>();
        Box<Toy> toyBox = new Box<>();
//        FruitBox<Ramen> ramenFruitBox = new FruitBox<Ramen>();
//        FruitBox<Toy> toyFruitBox = new FruitBox<Toy>();

        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        fruitBox.add(new Fruit());

        appleFruitBox.add(new Apple());
//        appleFruitBox.add(new Grape());
        grapeFruitBox.add(new Grape());
        toyBox.add(new Toy());

        System.out.println("fruitBox = " + fruitBox);
        System.out.println("appleFruitBox = " + appleFruitBox);
        System.out.println("grapeFruitBox = " + grapeFruitBox);
        System.out.println("toyBox = " + toyBox);
    }
}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item) {
        list.add(item);
    }
    T get(int i){
        return list.get(i);
    }
    int size(){
        return list.size();
    }
    public String toString(){
        return list.toString();
    }
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {
    // 여기서 Fruit 를 상속 && Eatable 를 구현한 클래스만 T 에 대입할 수 있다.
    // 하지만 Fruit 가 Eatable 를 구현했으므로, 사실 '& Eatable' 은 없어도 된다.
}