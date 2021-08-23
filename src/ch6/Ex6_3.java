package ch6;

public class Ex6_3 {
    public static void main(String[] args) {
        System.out.println("Card width  = " + Card.width);
        System.out.println("Card height  = " + Card.height);

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.println("c1은 " + c1.kind + c1.number + "이며, 크기는 " + Card.width + "x" + Card.height);
        System.out.println("c2은 " + c2.kind + c2.number + "이며, 크기는 " + Card.width + "x" + Card.height);

//        c1.width = 50;
//        c1.height = 70; // 이 줄과 위에 줄처럼 해도 되긴 한다. 하지만 이렇게 쓰면 cv 가 iv 처럼 보임. 그래서 밑처럼 바꿔야 함
        Card.width = 50;
        Card.height = 80;


        System.out.println("c1은 " + c1.kind + c1.number + "이며, 크기는 " + Card.width + "x" + Card.height);
        System.out.println("c2은 " + c2.kind + c2.number + "이며, 크기는 " + Card.width + "x" + Card.height);
    }
}

class Card {
    String kind;
    int number;

    static int width = 100;
    static int height = 250;
}