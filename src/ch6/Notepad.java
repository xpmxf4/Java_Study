package ch6;


// 10
public class Notepad {
    public static void main(String[] args) {

    }
}

class Machine{
    String color;
    String geartype;
    int door;

    Machine(){
        this("blue", "gear", 3);
    }

    Machine(String c, String g, int d){
        color = c;
        geartype = g;
        door = d;
    }

    Machine(String c, int d){
        this(c, "gear", d);
    }

    void run(){
        System.out.println(this.color+ this.geartype+ "run");
    }
}