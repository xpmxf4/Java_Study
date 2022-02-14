package ch14;

import java.util.*;

public class Ex14_4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(i);

        // list 의 모든 요소 출력
        list.forEach(i -> System.out.print(i+ ","));
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // list 에서 2 또는 3의 배수를 제거한다.
        list.removeIf(i -> i % 2 == 0 || i % 3 == 0);
        System.out.println(list);

        // list 의 각 요소에 10 을 곱한다.
        list.replaceAll(i -> i * 10);
        System.out.println(list);

        System.out.println();
        System.out.println();

        // map 의 모든 요소를 {k,v} 의 형태로 출력한다.
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        map.forEach((k, v) -> System.out.println("{" + k + "," + v + "}"));
        System.out.println();
        System.out.println();

        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> it2 = set.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
    }
}
