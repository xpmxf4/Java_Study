package ch3;

public class OperatorEx9 {
    public static void main(String[] args){
        long a = 1_000_000 * 1_000_000;
        long b = 1_000_000 * 1_000_000L;

        System.out.println("a= " + a);  //  버그
        System.out.println("b= " + b);  //  의도한대로

    }
}
