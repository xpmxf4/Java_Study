package playground;

public class LackMoney {
    public static void main(String[] args) {
        System.out.println("solution(3, 20, 4); = " + solution(3, 20, 4));
    }

    public static long solution(int price, int money, int count) {
        int paySum = 0;

        for (int i = 1; i <= count; i++) {
            paySum += price * i;
        }

        if(paySum > money) return paySum-money;
        else return 0;
    }

}
