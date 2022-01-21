package ch11;

import java.util.*;

public class Ex11_10 {
    public static void main(String[] args) {
        Set set = new HashSet();

        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num);
        }

        LinkedList li = new LinkedList(set);
        Collections.sort(li);   // li.sort() 는 안됨.
        System.out.println("li = " + li);
    }
}
