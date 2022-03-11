package ch14;

import java.util.*;

// 기존의 컬렉션 프레임웍을 사용하는 게 훨씬 쉬어진다
public class Ex14_4_practice {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++) list.add(i);

        System.out.println("list = " + list);

        // 1. 모든 요소 출력하기
        list.forEach(i -> System.out.print(i));
        System.out.println();

        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) System.out.print(it.next());
        System.out.println();

        // 2. list 에서 2 또는 3 의 배수 제거하기
        list.removeIf(i -> i % 2 == 0 || i % 3 == 0);
        System.out.println(list);

        // list 의 각 요소에 10 을 곱한 다음 출력하기
        list.replaceAll(i -> i * 10);
        System.out.println(list);

        System.out.println();
        System.out.println();

        // map 의 모든 요소를 {k, v} 의 형태로 출력하기
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        map.forEach((k, v) -> System.out.printf("{%s, %s}\n", k, v));
        System.out.println();
        System.out.println();

        Set<Map.Entry<String, String>> set = map.entrySet();
        set.forEach(i -> System.out.printf("{%s, %s}\n", i.getKey(), i.getValue()));

    }
}
