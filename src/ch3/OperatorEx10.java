package ch3;

public class OperatorEx10 {
    public static void main(String[] args){
        int a = 100000;

        int result1 = a * a / a;    //  버그
        int result2 = a / a * a;    //  1000000

        System.out.println(result1);
        System.out.println(result2);

    }
}
