package ch6.practice;

public class Exercise6_9 {
    public static void main(String[] args) {

    }
}

class Marine {
    int x=0, y=0;
    int hp = 60;            // static
    int weapon = 6;         // static
    int armor = 0;          // static

    void weaponUp(){
        weapon++;
    }

    void armorUp(){
        armor++;
    }

    void move(int x, int y){
        this.x = x;
        this.y = y;
    }
}