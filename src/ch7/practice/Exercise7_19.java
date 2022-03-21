package ch7.practice;

import java.util.Arrays;

public class Exercise7_19 {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Tv());
        b.buy(new Audio());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());

        b.summary();
    }
}

class Buyer {
    int money = 1000;
    Product[] cart = new Product[3];
    int i = 0;

    void buy(Product p) {
        if (p.price > money){
            System.out.println("잔액이 부족하여 " + p.toString() + "을/를 살 수 없습니다");
            return;
        }
        money -= p.price;
        add(p);
    }

    void add(Product p) {
        if (i >= cart.length) {
            Product[] newCart = new Product[2 * cart.length];
            for (int i = 0; i < cart.length; i++) {
                newCart[i] = cart[i];
            }
            cart = newCart;
        }
        cart[i++] = p;
    }

    void summary() {
        int sum = 0;

        System.out.print("구입한 물건 : ");
        for (Product p : cart) {
            if (p == null) break;
            System.out.print(p.toString()+ ", ");
            sum += p.price;
        }
        System.out.println();
        System.out.println("사용한 금액 : " + sum);
        System.out.println("남은 금액 : " + (1000-sum));
        System.out.println();
    }
}

class Product {
    int price;

    Product(int price) {
        this.price = price;
    }
}

class Tv extends Product {
    Tv() {
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Audio extends Product {
    Audio() {
        super(50);
    }

    @Override
    public String toString() {
        return "Audio";
    }
}