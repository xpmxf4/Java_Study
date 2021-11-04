package ch7;

class Product{
    int price;
    int bonusPoint;

    Product(int price) {
        this.price = price;
        this.bonusPoint = price / 10;
    }
}

class Nintendo extends Product{
    Nintendo(){
        super(100);
    }

    public String toString() {
        return "Nintendo";
    }
}

class Computer extends Product{
    Computer(){
        super(200);
    }
    public String toString(){
        return "Computer";
    }
}

class Audio extends Product{
    Audio(){
        super(300);
    }
    public String toString(){
        return "Audio";
    }
}

class Buyer{
    private int money = 1000;
    private int bonusPoint = 0;
    private Product[] cart = new Product[10];
    int j = 0 ;

    void buy(Product p) {
        if (p.price > money) {
            System.out.println("돈이 부족합니다");
            return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        cart[j++] = p;
        System.out.println(p + "를 구입하셨습니다!");
    }

    void getMoney(){
        System.out.println(money);
    }

    void getBonusPoint(){
        System.out.println(bonusPoint);
    }

    void getCart(){
        for (int i = 0; i < cart.length; i++) {
            if(cart[i] == null) return;
            System.out.println(cart[i]);
        }
    }
}

public class Ex7_8 {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Nintendo());
        b.buy(new Computer());
        b.buy(new Audio());

        b.getBonusPoint();
        b.getMoney();
        b.getCart();

    }
}