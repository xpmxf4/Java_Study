package ch7;

class Point4{
    int x;
    int y;

    Point4(int x, int y){
        this.x = x;
        this.y = y;
    }

    String getLocation(){
        return "x: " + x + ", y: " + y;
    }
}

class Point3D4 extends Point4{
    int z;

    Point3D4(int x, int y, int z){
        super(1,2);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    String getLocation(){
        return "x: " + x + ", y: " + y + ", z: " + z;
    }
}

public class PointTest {
    public static void main(String[] args) {
        Point3D4 p3 = new Point3D4(1, 2, 3);
        System.out.println(p3.getLocation());
    }
}
