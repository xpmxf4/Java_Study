package ch7;

class StaticTest{
    static int add(int a, int b){
        return a + b;
    }
}


public class superTest {
    public static void main(String[] args) {
        System.out.println(StaticTest.add(1, 2));

    }
}
