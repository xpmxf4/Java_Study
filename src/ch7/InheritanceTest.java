package ch7;

class Point {
    int x;
    int y;
}

// class Circle extends Point{ // 상속
//    int r;
//}

class Circle {
//    Point p = new Point();
    int r;
    Point p;
    Circle(){
        p = new Point();
    }
}

public class InheritanceTest {
    public static void main(String[] args) {
        Circle c = new Circle();
        Circle c2 = new Circle();
        System.out.println(c.toString());
        System.out.println(c2);
    }
}
