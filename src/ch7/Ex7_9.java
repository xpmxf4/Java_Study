package ch7;

class Buyer9 {
    int money = 10000;
    Product9[] list = new Product9[10];

    int index = 0;
    void buy(Product9 p) {
        if (money < p.price) {
            System.out.println("돈이 부족해" + p + "를 구입할 수 없습니다.");
            return;
        }

        money -= p.price;
        list[index++] = p;
    }

    void summary(){
        System.out.println("현재 남은 돈은 " + this.money + "입니다!");
        System.out.println("지금까지 구매한 목록입니다!");
        for (int i = 0; i < list.length; i++) {
            if(list[i] == null) break;
            System.out.println(list[i]);
        }
    }
}

class Product9 {
    String name;
    int price;

    Product9(){}

    Product9(int price, String name){
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return this.name;
    }
}

class Tv9 extends Product9{
    Tv9(){
        super(100, "TV");
    }
}

class Computer9 extends Product9{
    Computer9(){
        super(200, "Computer");
    }
}

public class Ex7_9 {
    public static void main(String[] args) {
        Buyer9 b = new Buyer9();
        b.buy(new Tv9());
        b.buy(new Tv9());
        b.buy(new Tv9());
        b.buy(new Computer9());
        b.buy(new Computer9());

        b.summary();
    }
}
