package ch8;

public class ExceptionEx12 {
    public static void main(String[] args) {
            method1();
    }

    static void method1(){
        try {
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void method2() throws Exception{
        throw new Exception();
    }
}
