package ch3;

public class OperatorEx2 {
    public static void main(String[] args){
        int i = 5, j = 0;

        j = i++;
        System.out.println(i);  //6

        i = 5;
        j = 0;

        j = ++i;
        System.out.println("j=++i; 실행 후 , i = " + i + ", j= " + j); //6 6
    }
}
