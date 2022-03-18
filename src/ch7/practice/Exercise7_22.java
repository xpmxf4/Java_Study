package ch7.practice;

abstract class Shape {
    Point p;

    Shape() {
        this(new Point(0, 0));
    }

    Shape(Point p) {
        this.p = p;
    }

    abstract double caclArea();

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

    Circle(Point p, double r){
        super(p);
        this.r = r;
    }

    @Override
    double caclArea() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Shape{
    double width;
    double height;

    boolean isSquare(){
        return width==height;
    }

    @Override
    double caclArea(){
        return width * height;
    }
}

public class Exercise7_22 {
    public static void main(String[] args) {
        Shape[] arr = {new Circle(5.0), }
    }
}
