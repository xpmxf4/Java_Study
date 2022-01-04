package ch7;

public class DefaultMethodTest {
    public static void main(String[] args) {

    }
}

interface I1 {
    default void newMethod(){
        System.out.println("I'm I1");
    }
}

interface I2{
    default void newMethod(){
        System.out.println("I'm I2");
    }
}

class SonOfI1I2 implements I1, I2{
    public void newMethod(){
        System.out.println("I'm A");
    }
}