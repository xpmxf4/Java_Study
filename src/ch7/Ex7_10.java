package ch7;

// 목적. 추상 클래스로 유닛 3개를 만들어보는 것.

abstract class Unit10 {
    int x, y;

    abstract void move(int x, int y);

    void stop(){
        System.out.println("멈춰");
    }
}

class Marine extends Unit10{
    void move(int x, int y ) {
        System.out.printf("(%d, %d) 만큼 지상에서 움직임\n", x, y);
    }

    void stimpack(){
        System.out.println("스팀팩 쿠워");
    }
}

class Dropship extends Unit10 {
    void move(int x, int y) {
        System.out.printf("(%d,%d) 만큼 공중에서 움직임\n", x, y);
    }

    void siegeMode() {
        System.out.println("시즈탱크 모드");
    }
}

public class Ex7_10 {
    public static void main(String[] args) {
        Unit10[] units = new Unit10[2];
        units[0] = new Marine();
        units[1] = new Dropship();


    }
}

