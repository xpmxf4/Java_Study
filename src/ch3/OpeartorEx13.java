package ch3;

public class OpeartorEx13 {
    public static void main(String[] args){
        char c1 = 'a';

//        char c2 = c1 + 1;   //  c1 은 char, 1은 int 기 때문에 c1 + 1 은 int 가 됨 -> c2 는 이 값을 못 담음
        char c2 = (char) (c1 + 1);

        System.out.println(c2); //  b
    }
}
