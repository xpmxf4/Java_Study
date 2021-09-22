package ch7;

class Point3 extends Object{
    int x;
    int y;

    Point3(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Object 클래스의 toString() 을 오버라이딩. public 을 안 붙이고 하니까 다음과 같은 에러가 뜬다.
    //'toString()' in 'ch7.Point3' clashes with 'toString()' in 'java.lang.Object';
    // attempting to assign weaker access privileges ('package-private'); was 'public'
    // 남궁성님의 설명에서 말했듯이 선언부는 동일하고, 구현부가 바뀌어야 한다고 해서 앞에 public 을 붙여야 함.
    // Object 클래스는 public 이 붙여져 있는 듯?
    // (복습 시점) 이게 맞음. 야무지네 이 당시의 나
     public String toString(){
        return "x: " + x + ", y: " + y;
    }
}

class MyPoint3 extends Point3{    // 왜 안되지

    MyPoint3(){
        super(1, 2);
    }
}

public class OverrideTest {
    public static void main(String[] args) {
        Point3 p = new Point3(3,5);
        MyPoint3 mp = new MyPoint3();

        System.out.println(p.toString());   // 오버라이딩 된 toString() 메서드가 호출됨.
        System.out.println(p);              // 와 개소름... println() 메서드가 객체를 받으면 받은 객체의 toString() 메서드를 호출하게 되어 있음.
                                            // 그래서 여기서 p 만해도 x: 3, y: 5 가 출력이 됨
    }
}
