package ch5;

import java.util.*;

// 아니 =- 랑 일일히 - 쓰는 거랑 뭐가 다른거임???

public class Exercise5_7$$ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("지불할 거스름돈을 입력해주세요>");
        int money = scanner.nextInt();

        System.out.println("money = " + money);
        System.out.println();


        int[] coinUnit = {500, 100, 50, 10};
        int[] coin = {5, 5, 5, 5};

        for (int i = 0; i < coinUnit.length; i++) {
            int coinNum = 0;

            coinNum = money / coinUnit[i];

            if(coinNum <= 5){
                coin[i] = coin[i] - coinNum;
                money = money -  coinNum * coinUnit[i];
            } else {
                coin[i] = coin[i] - 5;
                money = money - coinUnit[i] * 5;
            }
            /* (1) 아래의 로직에 맞게 코드를 작성하시오.
            1. 금액(money)을 동전단위로 나눠서 필요한 동전의 개수(coinNum)를 구한다.
            2. 배열 coin 에서 coinNum 만큼의 동전을 뺀다.(만일 충분한 동전이 없다면 배열 coin 에 있는 만큼만 뺀다.)
            3. 금액에서 동전의 개수(coinNum)와 동전단위를 곱한 값을 뺀다.
            */
        }
        System.out.println("money = " + money);

        if (money > 0) {
            System.out.println("거스름돈이 부족합니다.");
        }

        System.out.println("==================남은 동전의 갯수====================");

        for(int i=0;i<coinUnit.length;i++) {
            System.out.println(coinUnit[i]+"원:"+coin[i]);
        }



    }
}
