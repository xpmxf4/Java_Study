package ch6;

public class Exercise6_2$$ {
    public static void main(String[] args) {
        StudaCard card1 = new StudaCard(3, false);
        StudaCard card2 = new StudaCard();

        System.out.println(card1.info());
        System.out.println(card2.info());
    }
}

class StudaCard {
    private int num;
    private boolean isKwang;

    StudaCard() {
//        this.num = 1000; 이렇게 되도 밑에 생성자를 this()로 호출할 수 있음.
//        그리고 해설에 이게 더 좋은 코드라고 나와 있음
        this(1, true);
    }

    StudaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    String info() {
//       여기서 this.num 을 사용하려 했다. 하지만 여기서 num 만 써도 읽을 수 있음
//       생각해보면 this 는 인스턴스 자신을 가르키는 객체임. 그리고 용도는
//       매개변수와 구분하려고 했던 거지, 멤버 변수를 지정할 수 없어서가 아니다!
        return num + (isKwang ? "K" : "");
    }
}
