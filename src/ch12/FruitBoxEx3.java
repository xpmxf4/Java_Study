package ch12;

import java.util.*;

class Fruit333{
    @Override
    public String toString() {
        return "Fruit333";
    }
}
class Apple333 extends Fruit333{
    @Override
    public String toString() {
        return "Apple333";
    }
}
class Grape333 extends Fruit333{
    @Override
    public String toString() {
        return "Grape333";
    }
}

class Juice333{
    String name;

    Juice333(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Juicer333{
    static <T extends Fruit333> Juice333 makeJuice(FruitBox333<T> box){
        String tmp = "";

        for(T f : box.getList()){
            tmp += f.toString();
        }

        return new Juice333(tmp);
    }
}

public class FruitBoxEx3 {
    public static void main(String[] args) {

    }
}

class FruitBox333<T extends Fruit333> extends Box333<T>{

}

class Box333<T>{
    ArrayList<T> list = new ArrayList<>();
    void add(T item){
        list.add(item);
    };
    T get(int i){
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