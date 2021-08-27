package ch6;

class Car2{
    String color;
    String gearType;
    int door;

    Car2(){
        this("White", "auto", 4);

    }

    Car2(String color){
        this(color, "auto", 4);
    }



    Car2(String color, String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}

public class Ex6_14 {
}
