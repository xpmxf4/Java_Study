package ch7;

class A {
    public void method(I b) {   // 인터페이스 I 를 구현한 놈들만 들어올 수 있음.
        b.method();
    }
}

//B 클래스의 선언과 구현을 분리함.
interface I {
    void method();
}
class B implements I{
    public void method(){
        System.out.println("B class's method");
    }
}

class C implements I{
    public void method(){
        System.out.println("C class's method");
    }
}

public class InterfaceTest {  // 목표는 변화가 있더라도 A 를 건드리지 않아도 되도록 하는 것!
    public static void main(String[] args) {
        A a = new A();
        a.method(new C());
        a.method(new B());

    }
}
