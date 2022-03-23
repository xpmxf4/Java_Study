package ch7.practice;

abstract class Shape {
    Point p;

    Shape() {
        this(new Point(0, 0));
    }

    Shape(Point p) {
        this.p = p;
    }

    abstract double calcArea();

    Point getPosition() {
        return p;
    }

    void setPosition(Point p) {
        this.p = p;
    }
}

class Point {
    int x, y;

    Point() {
        this(0, 0);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}

class Circle extends Shape {
    double r;

    Circle(double r){
        super();
        this.r = r;
    }
    double calcArea(){
       return Math.PI * r * r;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(double width,double height){
        super();
        this.width = width;
        this.height = height;
    }
    double calcArea(){
        return width * height;
    }

    boolean isSquare(){
        return width==height;
    }
}

public class Exercise7_22 {
    static double sumArea(Shape[] arr){
        double sum = 0;
        for(Shape s: arr){
           sum += s.calcArea();
        }
        return sum;
    }
    public static void main(String[] args) {
        Shape[] arr = {new Circle(5.0), new Rectangle(3, 4), new Circle(1)};
        System.out.println("면적의 합 : " + sumArea(arr));
    }
}
