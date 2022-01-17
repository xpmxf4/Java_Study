package ch11;

import java.util.*;

public class Ex11_1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(10);
//        list1.add(new Integer(5));  // 여기에 기본형 써도 된다. 매개변수는 참조형만 가능하지만 오토박싱 때문에 list1.add(5) 도 가능하다.
        list1.add(5);
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));
        // list1 = [5 (에 해당하는 주소 값),4,2,0,1,3]

        //ArrayList(Collection c);
        ArrayList list2 = new ArrayList(list1.subList(1, 4));
        print(list1, list2);

        //Collection 은 인터페이스, Collections 는 Collection 을 다루는 데 필요한 메서드를 모아둔 util Class 이다.
        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        System.out.println("list1.containsAll(list2) = " + list1.containsAll(list2));   // list1 이 list2 의 모든 요소를 포함하고 있냐? 라는 containsAll()

        list2.add("B");
        list2.add("C");
        list2.add(3, "A");  // 원래 추가하면 맨 뒤 이지만, 특정 인덱스에 추가해버림.기존의 것들은 오른쪽으로 한 칸 이동함.
        // 기존의 것들의 위치가 이동하다 보니, 부담이 가는 작업니다!
        print(list1, list2);

        list2.set(3, "AA");
        print(list1, list2);

        list1.add(0, "1");
        System.out.println("list1.indexOf(\"1\") = " + list1.indexOf("1"));
        System.out.println("list1.indexOf(1) = " + list1.indexOf(1));
        // 현재 ["1", 0, 1, 2, 3, 4, 5] 이다
        print(list1, list2);

//        list1 에서 숫자 1 을 지우는 방법
//        list1.remove(list1.indexOf(1));
//        list1.remove(1);   이렇게 하면 index=1 인 것을 지우게 된다
//        그래서 이때는 list1.remove(new Integer(1)) 라고 해야한다.
        list1.remove(new Integer(1));
        print(list1, list2);

        //retainAll() 은 겹치는 부분을 제외하고 다 지운다.7` 666666
        System.out.println("list1.retainAll(list2) = " + list1.retainAll(list2));
        print(list1, list2);



        System.out.println("=========================");
        // list2 에서 list1 에 포함된 객체들을 삭제한다.
        for (int i = list2.size() - 1; i >= 0; i--) {
            if (list1.contains(list2.get(i))) {
                System.out.println("list2.get(i) = " + list2.get(i));
                list2.remove(i);
                print(list1, list2);
            }
        }

//        for(int i = 0 ; i < list2.size() ; i++){
//            if (list1.contains(list2.get(i))) {
//                System.out.println("list2.get(i) = " + list2.get(i));
//                list2.remove(i);
//                print(list1, list2);
//            }
//
//        }
        print(list1, list2);
    }

    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println();
    }
}
