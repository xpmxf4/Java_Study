package ch4;

public class Exercise4_11 {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 1;
        int num3 = 0;   //세번 째 값


        for (int i = 0; i < 8; i++) {
            System.out.println(num1 + "," + num2);
            num3 = num1 + num2;
            System.out.println(num3);
            System.out.println();
            num1 = num2;
            num2 = num3;
        }
    }
}
