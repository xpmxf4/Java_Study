package ch11;

import java.util.*;

public class Ex11_5 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);

        Iterator it = c.iterator();

        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }

        it = c.iterator();
        for (int i = 0; i < c.size(); i++) {
            Object obj = it.next();
            System.out.println(obj);
        }
    }

    static void a(Object... b){

    }
}
