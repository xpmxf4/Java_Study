package ch9;

public class Exercise9_11 {
    public static void main(String[] args) {
        for (int i = Integer.valueOf(args[0]); i < Integer.valueOf(args[1]) + 1; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%d*%d=%d\n", i, j, i * j);
            }
            System.out.println();
        }
    }
}
