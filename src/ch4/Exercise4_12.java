package ch4;

public class Exercise4_12 {
    public static void main(String[] args) {
        for (int i = 2; i < 8; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.printf("%d * %d = %d%n", i, j, i * j);
            }
            System.out.println();
        }
    }
}
