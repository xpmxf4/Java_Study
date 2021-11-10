package ch7;

// 인터페이스의 장점(2) 내 손으로 구현해보기
public class NotePad {
    public static void main(String[] args) {
        DropshipN d = new DropshipN();
        d.MAX_HP = 100;
        d.hitPoint = 50;
        d.repairN(d);
    }
}

abstract class UnitN {
    int MAX_HP;
    private int positionX;
    private int getPositionY;
    int hitPoint;

    abstract void move();
    abstract void attack(UnitN u);
}

abstract class GroundUnitN extends UnitN{
    void move(){
        System.out.println("move on the ground");
    }
}

abstract class AirUnitN extends UnitN{
    void move(){
        System.out.println("move on the air");
    }
}

class MarineN extends GroundUnitN{
    void attack(UnitN u) {

    }
}

class SCVN extends GroundUnitN{
    void attack(UnitN u) {

    }
}

class TankN extends GroundUnitN{
    void attack(UnitN u){

    }
}

class DropshipN extends AirUnitN implements Repairable{
    void attack(UnitN u){

    }

    public void repairN(Repairable r ){
        if(r instanceof UnitN){
            UnitN u = (UnitN) r;
            while (u.hitPoint != u.MAX_HP) {
                u.hitPoint+=2;
                System.out.println("2 만큼 회복됨!");
            }
            System.out.println(((UnitN) r).hitPoint + "가 현재 hp");
        }
    }
}

interface Repairable {
    void repairN(Repairable r);
}

