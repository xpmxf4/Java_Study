package ch7;

class A {
    public void method(I i){
        i.method();
    }
}

interface I {
    public void method();
}

class B implements I{
    public void method(){
        System.out.println("method B");
    }
}

class C implements I{
    public void method(){
        System.out.println("method C");
    }
}

public class InterfaceTest {  // 목표는 변화가 있더라도 A 를 건드리지 않아도 되도록 하는 것!
    public static void main(String[] args) {
        A a = new A();
        a.method(new B());  // 여기서 A 에는 변경점이 안 생긴다라는 포인트가 생김!
        a.method(new C());
    }
}
