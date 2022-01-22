package ch11;

import java.util.*;

public class Ex11_17 {
    public static void main(String[] args) {
        HashMap table = new HashMap();
        table.put("A", 4);
        table.put("B", 3);
        table.put("C", 2);

        HashMap map = new HashMap();
        map.put("컴구조", "A");
        map.put("네트워크", "B");
        map.put("네트워크", "A");
        map.put("디지털영상처리", "A");
        map.put("디지털영상처리", "B");
        map.put("인공지능", "C");

        System.out.println("map = " + map);
        Iterator it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("과목명 : " + e.getKey() + " / 점수 : " + e.getValue());
        }

        Set keySet = map.keySet();
        System.out.println("수강 과목 : " + keySet);

        it = map.values().iterator();
        int total = 0;
        while (it.hasNext()) {
            total += (int) table.get(it.next());
        }
        float avg = (float) (total / map.size());
        System.out.println("총점 : " + total);
        System.out.println("평균 : " + avg);
        System.out.println("최고 성적 : " + Collections.min(map.values()));
    }
}
