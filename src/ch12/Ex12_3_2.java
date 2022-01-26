package ch12;

import java.util.*;

interface Eatable3 { }
class Fruit3 implements Eatable3 { }
class Apple3 extends Fruit3{
    public String toString (){
        return "Apple";
    }
}
class Grape3 extends Fruit3{
    public String toString (){
        return "Grape";
    }
}
class Toy3 {
    public String toString(){
        return "Toy";
    }
}
class Ramen3 implements Eatable3{
    public String toString() {
        return "Ramen";
    }
}
class FruitBox3<T extends Fruit3 & Eatable3> extends Box3<T> {
    // 여기서 Fruit 를 상속 && Eatable 를 구현한 클래스만 T 에 대입할 수 있다.
    // 하지만 Fruit 가 Eatable 를 구현했으므로, 사실 '& Eatable' 은 없어도 된다.
}
class Box3<T> {
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

public class Ex12_3_2 {
    public static void main(String[] args) {
        Box3 b = null;
        Box3<String> bStr = null;
        Box3 test = new Box3<String>();
        test.add(100);

        b = (Box3) bStr;            // Box3<String> -> Box
        bStr = (Box3<String>) b;    // Box -> Box3<String>
        System.out.println("test = " + test);   // ? 되네 ㅋㅋㅋㅋㅋㅋㅋ
//      이 위로는 지네릭 클래스 <-> 원시타입 클래스 간에 형변환이 안된다는 예제

//      여기서부터는 와일드 카드를 사용한 지네릭 클래스 <-> 일반 지네릭 간에 형변환

        FruitBox3<? extends Fruit3> fBox =(FruitBox3<? extends Fruit3>) new FruitBox3<>();  // FruitBox<Apple> -> FruitBox<? extends Fruit>
        FruitBox3<? extends Fruit3> aBox = new FruitBox3<>();

        FruitBox3<Apple3> appleBox =(FruitBox3<Apple3>) aBox;   // 되는 데, 경고뜸
        // FruitBox3<? extends Fruit> -> FruitBox3<Apple3>
    }
}




