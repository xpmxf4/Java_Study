package ch4;

// 1 부터 20 까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오

public class Exercise4_2 {
    public static void main(String[] args) {
        int total = 0;

        for (int i = 0; i <= 20; i++) {
            if (i % 2 != 0 || i % 3 != 0)
                total += i;
        }

        System.out.printf("total 값은 %d", total);
    }
}
