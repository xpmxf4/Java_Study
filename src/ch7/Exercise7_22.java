package ch7;

public class Exercise7_22 {
    static double sumArea(Shape[] arr){
        double sum = 0;
        for(int i =0 ; i< arr.length; i++){
            System.out.println(arr[i].calcArea());
            sum += arr[i].calcArea();
        }
        return sum;
    }

    public static void main(String[] args) {
        Shape[] arr = {new Circle(5.0), new Rectangle(3, 4), new Circle(1)};
        System.out.println("면적의 합 : " + sumArea(arr));

    }
}

abstract class Shape {
    Point p;

    Shape() {
        this(new Point(0, 0));
    }

    Shape(Point p) {
        this.p = p;
    }

    abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드

    Point getPosition() {
        return p;
    }

    void setPosition(Point p) {
        this.p = p;
    }
}

class Point {
    int x;
    int y;

    Point() {
        this(0, 0);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "[" + x + "," + y + "]";
    }
}

class Circle extends Shape {
    double r;

    Circle(double r){
        this(new Point(0, 0), r);
    }

    Circle(Point p, double r){
        super(p);
        this.r = r;
    }

    double calcArea() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(int x, int y){
        this(new Point(0,0),x, y);
    }

    Rectangle(Point p,int width, int height){
        super(p);
        this.width = width;
        this.height = height;
    }

    double calcArea(){
        return width * height;
    }

    boolean isSquare(){
        return width * height != 0 && width == height;
    }
}