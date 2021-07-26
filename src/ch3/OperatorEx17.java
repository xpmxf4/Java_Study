package ch3;

//  int -> float 시에 반올림하는 법

public class OperatorEx17 {
    public static void main(String[] args){
        double pi = 3.141592;
        double shortPi = (int) (pi * 1000 + 0.5) / 1000.0;  //  3.142

        System.out.println(shortPi);    //  3.142
    }
}
