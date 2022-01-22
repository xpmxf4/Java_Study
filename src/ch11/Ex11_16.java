package ch11;

import java.util.*;

public class Ex11_16 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("a", "1234");
        map.put("b", "1111");
        System.out.println("map = " + map);
        map.put("b", "1234");
        System.out.println("map = " + map);

        Scanner s = new Scanner(System.in);

        while(true){
            System.out.println("Insert your ID & PASSWORD");
            System.out.print("ID : ");
            String id = s.nextLine().trim();

            if(!(map.containsKey(id))){
                System.out.println("Inserted wrong ID. Please insert your ID again.");
                continue;
            }

            System.out.print("PW : ");
            String pw = s.nextLine().trim();
            if(!(map.get(id).equals(pw))){
                System.out.println("Inserted wrong PW. Please insert your PW again.");
                continue;
            }

            System.out.println("You're logged in. ");
            break;
        }


    }
}
