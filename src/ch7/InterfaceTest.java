package ch7;

class A {
//    void method(B b){
//        b.printSelf();
//    }
//
//    void method(C c){
//        c.printSelf();
//    }
    void method(I i){
        i.printSelf();
    }
}

interface I {
    void printSelf();
}

class B implements I{
    public void printSelf(){
        System.out.println("It's B");
    }
}

class C implements I{
    public void printSelf(){
        System.out.println("It's C");
    }
}

public class InterfaceTest {  // 목표는 변화가 있더라도 A 를 건드리지 않아도 되도록 하는 것!
    public static void main(String[] args) {
        A a = new A();
        a.method(new B());
        a.method(new C());
    }
}
