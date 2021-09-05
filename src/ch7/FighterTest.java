package ch7;

abstract class Unit{
    int x,y;
    abstract void move(int x, int y);
    void stop() {
        System.out.println("멈춥니다");
    }
}

interface Fightable{
    void move(int x, int y);    //public abstract 생략
    void attack(Fightable f);   //public abstract 생략
}

class Fighter extends Unit implements Fightable{
    public void move(int x, int y){ // 오버라이딩 할때 조상보다 접근 제어자가 좁으면 안됨. Fightable 에서 move, attack 은 public이였음!
        System.out.println("[" + x + "," + y + "]로 이동");
    }
    public void attack(Fightable f){
        System.out.println(f+"를 공격");
    }
    //싸울 수 있는 상대 불러오기
    Fightable getFightable(){
        return new Fighter();   // Fighter 를 생성해서 반환
    }
}

public class FighterTest {
    public static void main(String[] args) {
        Fighter f = new Fighter();
        Fightable f2 = f.getFightable();


    }
}
