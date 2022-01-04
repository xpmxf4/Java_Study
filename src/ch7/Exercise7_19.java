package ch7;

public class Exercise7_19 {
    public static void main(String[] args) {
        Buyer22 b = new Buyer22();
        b.buy(new Tv22());
        b.buy(new Computer22());
        b.buy(new Tv22());
        b.buy(new Audio22());
        b.buy(new Computer22());
        b.buy(new Computer22());
        b.buy(new Computer22());
        b.summary();
    }
}

class Buyer22 {
    int money = 1000;
    Product22[] cart = new Product22[3]; // 구입한 제품을 저장하기 위한 배열
    int i = 0; // Product cart index 배열 에 사용될

    void buy(Product22 p) {
        if (money < p.price) return;
        money -= p.price;
        add(p);
    }

    void add(Product22 p) {
        if (i >= cart.length) {
            Product22[] newCart = new Product22[cart.length * 2];
            for (int j = 0; j < i; j++) newCart[j] = cart[j];
            cart = newCart;
        }
//        cart[i] = p;
//        i++;
        cart[i++] = p;  // 위처럼 썼었는 데, 이렇게 쓰는 게 더 깔끔하다 못해 맞는 소리임.
    } // add(Product p)

    void summary() {
        String itemList = "";
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += cart[j].price;
            itemList += cart[j] + ",";
        } ;

//        System.out.println("물품 목록 : " + java.util.Arrays.toString(cart));
        System.out.println("물품 목록 : " + itemList);
        System.out.println("지출 합계 : " + sum);
        System.out.println("사고 남은 금액 : " + money);
    } // summary()
}

class Product22 {
    int price; // 제품의 가격

    Product22(int price) {
        this.price = price;
    }
}

class Tv22 extends Product22 {
    Tv22() {
        super(100);
    }

    public String toString() {
        return "Tv";
    }
}

class Computer22 extends Product22 {
    Computer22() {
        super(200);
    }

    public String toString() {
        return "Computer";
    }
}

class Audio22 extends Product22 {
    Audio22() {
        super(50);
    }

    public String toString() {
        return "Audio";
    }
}
