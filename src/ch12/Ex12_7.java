package ch12;

import java.util.ArrayList;

public class Ex12_7 {
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static void main(String[] args) {
        Child c = new Child();
        c.parentMethod();

        ArrayList list = new ArrayList();
        list.add(new Object());
    }
}

class Parent{
    void parentMethod(){

    };
}

class Child extends Parent {
    @Override
    @Deprecated
    void parentMethod(){
        System.out.println("Deprecated");
    }
}

@FunctionalInterface        //함수형 인터페이스는 딱 하나의 추상 메서드만 가능함
interface Testable{
    void test();    //추상메서드
//    void check();   //추상메서드
}