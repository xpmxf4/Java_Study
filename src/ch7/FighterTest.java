package ch7;

abstract class Unit {   // 추상 클래스
    int x, y;

    abstract void move(int x, int y);

    void stop(){
        System.out.println("멈춰");
    }
}

interface Fightable{
    void move(int x, int y);

    void attack(Fightable fightable);
}

class Fighter extends Unit implements Fightable {
    public void move(int x, int y) {
        System.out.printf("%d, %d 만큼 이동\n", x, y);
    }

    public void attack(Fightable f) {
        System.out.println(f + "를 공격");
    }

    // 싸울 수 있는 상대를 불러온다.
    Fightable getFightable(){
        Fighter f = new Fighter();
        return (Fightable) f;
   }
}

public class FighterTest {
    public static void main(String[] args) {
//        Fighter f1 = new Fighter();
        Unit u = new Fighter();
        Fightable f1 = new Fighter();
        Fighter f = new Fighter();

        Fightable f2 = f.getFightable();
//        f2.stop();  // 위에서 return 타입이 Fightable 이라, f2.stop() 이 되지 않는다!
                    // 리턴 타입이 인터페이스다? 그 리턴 타입은 인터페이스를 구현한 객체를 리턴한다라는 뜻.
                    // 왜 리턴 타입을 인터페이스로? 추상화를 위해서! ==> 애매하게 해서 유연함 올리려고!
        f2.move(1, 2);
        f2.attack(f1);
    }

}
