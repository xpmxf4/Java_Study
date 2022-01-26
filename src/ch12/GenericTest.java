package ch12;

import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
//        ArrayList<Object> list = new ArrayList<Obejct>(); 다양하게 들어올 수 있게 하는 코드는 이거이다.
//        사실 ArrayList list = new ArrayList() 이렇게 해도 되는 데, 좋은 코드가 아니라서, 꼭 지네릭스를 붙여주도록 하자!
// 		  클래스 안에 Object 타입이 있은 것들은 일반 클래스에서, 지네릭 클래스로 바뀜
        list.add(10);
        list.add(20);
//        list.add("30");

//        Integer i = list.get(0); get() 은 Object 를 반환함. 그리고 설명 보면
//        get() 의 반환타입은 ArrayList 의 지네릭스 타입을 반환한다고 되어 있음


        System.out.println("list = " + list);
    }
}
