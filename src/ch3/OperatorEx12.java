package ch3;

public class OperatorEx12 {
    public static void main(String[] args){
        char c1 = 'a';  //  a 에 해당하는 유니코드가 들어감
        char c2 = c1;   //  c1 에 들어간 유니코드가 c2 에도 들어감
        char c3 = ' ';  //  **c3를 공백으로 초기화한다, 공백에 해당하는

        int i = c1 + 1; //  a의 유니코드에 1을 더함 -> b 겠지만 int 라서 printf 찍으면 그냥 숫자가 나올꺼임
        c3 = (char) (c1 + 1);
        c2++;
        c2++;

        System.out.println("i=" + i);   //  96
        System.out.println("c2=" + c2); //  97 ************ i 는 int 지만, c2 는 char 이기 때문에 출력될 때는 c 로 나와야 한다!!!!!
        System.out.println("c3=" + c3); //  b


    }
}
