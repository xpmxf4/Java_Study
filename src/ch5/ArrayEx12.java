package ch5;

public class ArrayEx12 {
    public static void main(String[] args) {
        String[] names = {"Kim", "Park", "Yi"};

        for (String k : names) {
            System.out.print(k);
        }

        String tmp = names[2];
        System.out.println();
        System.out.println("tmp: " + tmp);

        names[0] = "Yu";

        for (String str : names) {
            System.out.print(str);
        }
    }
}
