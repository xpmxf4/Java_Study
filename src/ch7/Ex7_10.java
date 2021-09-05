package ch7;

public class Ex7_10 {
    public static void main(String[] args) {
        Unit2[] units = {new Marine(), new Dropship()};
        for (int i = 0; i < units.length; i++) {
            units[i].move(100, 200);
        }
    }
}

abstract class Unit2 {
    int x, y;
    abstract void move(int x, int y);
    void stop(){
        System.out.println("멈춰!!");
    }
}

class Marine extends Unit2{
    void move(int x, int y){
        System.out.printf("마린 (%d,%d) 무빙중%n", x,y);
    }
}

class Dropship extends Unit2{
    void move(int x, int y) {
        System.out.printf("드랍쉽 (%d,%d) 무빙중%n", x,y);
    }
}