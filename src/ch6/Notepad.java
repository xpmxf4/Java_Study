package ch6;


// 10
public class Notepad {
    public static void main(String[] args) {

    }
}

class Point{
    int x,y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Point3D extends Point{
    int z;

    Point3D(int x, int y, int z){
//        System.out.println("asdf");
        super(x, y);
        this.z = z;
    }
}