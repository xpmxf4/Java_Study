package ch4;

public class Exercise4_3$$ {
    public static void main(String[] args) {
        int sum = 0;
        int totalSum = 0;

//        for (int i = 1; i < 11; i++) {
//            sum += i * (10 - i + 1);
//        }

        for (int i = 1; i < 11; i++) {
            sum += i;
            totalSum += sum;
        }

        System.out.printf("sum 의 값은 %d 입니다", totalSum);
    }
}
