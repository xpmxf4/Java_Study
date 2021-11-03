package ch7;

class Buyer {
    int money = 1000;
    int bonusPoint = 0;

    void buy(Product p){
        if(money < p.price){
            System.out.println("잔액이 부족하여 " + p.name + "를 구입할 수 없음");
            return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println(p + "를 구입해버림");
    }
}

class Product{
    String name;
    int price;
    int bonusPoint;

    Product(int price, String name){
        this.name = name;
        this.price = price;
        this.bonusPoint = price / 10;
    }

    public String toString(){
        return name;
    }

}

class Tv1 extends Product{
    Tv1(){
        super(100, "Tv");
    }
}

class Computer extends Product{
    Computer(){
        super(200, "Computer");
    }
}

public class Ex7_8 {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        b.buy(new Tv1());
        b.buy(new Computer());

        System.out.println(b.money + "만큼 돈이 남음");
        System.out.println(b.bonusPoint + "만큼 보너스 포인트 있음");
    }
}