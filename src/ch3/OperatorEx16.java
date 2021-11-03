package ch3;

public class OperatorEx16 {
    public static void main(String[] args){
        float pi = 3.141592f;   // 자바의 실수 타입의 기본 처리는 double 타입이므로 f 를 붙여줘야 한다!
        float shortPi = (int)(pi * 1000) / 1000f;

        System.out.println(shortPi);    //  3141 ************3141 은 택도 없는 값

    }
}
