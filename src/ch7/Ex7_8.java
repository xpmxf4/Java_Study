package ch7;

class Product{
    int price;
    int bonusPoint;

    Product(int price){
        this.price = price;
        this.bonusPoint = (int) (price / 10.0);
    }
}
class Nintendo extends Product{
    Nintendo(){
        super(100);
    }
}
class PS5 extends Product{
    PS5(){
        super(60);
    }
}

class Buyer{
    int money = 1000;
    int bonusPoint = 0;

    void buy(Product p){
        if(money < p.price){
            System.out.println("소유하고 있는 돈보다 사려는 제품의 가격이 더 높습니다!");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
    }
}

public class Ex7_8 {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Nintendo());
        b.buy(new PS5());

        System.out.println(b.money + "만큼 돈이 남았습니다");
        System.out.println(b.bonusPoint + "의 마일리지가 있습니다!");
    }
}