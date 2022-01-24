package ch11;

import java.util.*;

public class Exercise11_2 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add(3);
        list.add(6);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(7);
        // list = [3, 6, 2, 2, 2, 7]

        System.out.println("list = " + list);
        HashSet set = new HashSet(list);
        System.out.println("set = " + set);
        TreeSet tset = new TreeSet(set);
        System.out.println("tset = " + tset);
        Stack stack = new Stack();

        stack.addAll(tset);
        System.out.println("stack = " + stack);
        while(!stack.empty())
            System.out.println(stack.pop());
    }
}
// 7 2 6 3