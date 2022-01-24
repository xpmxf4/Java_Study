package ch11;

import java.util.*;
import static java.util.Collections.*;

public class Ex11_19 {
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(list);

        addAll(list, 1, 2, 3, 4, 5);
        System.out.println("addAll() : " + list);

        rotate(list, 3);
        System.out.println("rotate() : " + list);

        swap(list, 1, 2);
        System.out.println("swap() : " + list);
        
        shuffle(list);
        System.out.println("shuffle() : " + list);

        sort(list, reverseOrder());
        System.out.println("sort( , reverseOrder()) : " + list);

        sort(list);
        System.out.println("sort() : " + list);

        int idx = binarySearch(list, 3);    // binarySearch 는 항상 sort() 하고 나서!
        System.out.println("idx of 3 : " + idx);

        System.out.println("max = " + max(list));
        System.out.println("min = " + min(list));
        System.out.println("min = " + max(list, reverseOrder()));

        List newList = nCopies(list.size(), 3);
        System.out.println("newList = " + newList);
        System.out.println("disjoint(list,newList) = " + disjoint(list, newList));

        copy(list, newList);
        System.out.println("list = " + list);
        System.out.println("newList = " + newList);

        replaceAll(list, 3, 4);
        System.out.println("list = " + list);

        Enumeration e = enumeration(list);
        ArrayList list2 = list(e);

        System.out.println("list2 = " + list2);
    }
}
