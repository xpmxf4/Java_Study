package ch7;

public class AbstractTest {
    public static void main(String[] args) {
        character[] group = new character[3];
        group[0] = new Marine2();
        group[1] = new Tank();
        group[2] = new Dropship2();

    }
}

abstract class character{
    int x,y;

    abstract void move(int x, int y);

    void stop(){}
}

class Marine2 extends character {
    void move(int x, int y) {

    }

    void stimpack(){}
}

class Tank extends character {
    void move(int x, int y) {

    }
    void siegeMode(){}
}

class Dropship2 extends character {
    void move(int x, int y) {

    }
    void load(){}
}
