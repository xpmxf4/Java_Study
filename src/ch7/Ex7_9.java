package ch7;

class Product2{
    int price;
    int bonusPoint;
    Product2(){}
    Product2(int price){
        this.price = price;
        this.bonusPoint = (int) (price / 10.0);
    }
}
class Tv2 extends Product2{
    Tv2(){
        super(100);
    }

    public String toString(){
        return "Tv2";
    }
}
class Computer2 extends Product2{
    Computer2(){
        super(200);
    }

    public String toString(){
        return "Computer";
    }
}
class Buyer2{
    int money = 1000;
    int bonusPoint = 0;

    Product2[] cart = new Product2[10];
    int i = 0;  // 이게 void 안에 있어도 상관없나?

    void buy(Product2 p) {
        if (money < p.price) {
            System.out.println("잔액부족입니다");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        cart[i++] = p;
    }

    void summary(){
        int sum = 0;
        String receipt = "";
        for (int i = 0; i < cart.length; i++) {
            if(cart[i] == null) break;  // 이걸 return 으로 써서 summary() 가 끝나버림 ㄸ
            receipt += cart[i] + ", ";
            sum += cart[i].price;
        }
        System.out.println(receipt + "가 지금까지 산 상품 목록입니다!");
        System.out.println("그리고 지금까지 카트에 담은 상품들이 합은 " + sum + " 입니다!");
    }
}

public class Ex7_9 {
    public static void main(String[] args) {
        Buyer2 b = new Buyer2();
        Tv2 t = new Tv2();
        Computer2 c = new Computer2();

        b.buy(t);
        b.buy(c);
        b.summary();
    }
}
