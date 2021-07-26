package ch3;

public class OperatorEx14 {
    public static void main(String[] args){
        char c = 'a';
        for(int i=0 ; i< 26; i++){  //  a 부터 쫘라락
            System.out.print(c++);
        }
        System.out.println();

        c = 'A';
        for(int i =0; i<26; i++){   //  A 부터 쫘라락
            System.out.print(c++);
        }
        System.out.println();

        c = '0';
        for(int i =0; i<26; i++){   //  0 부터 쫘라락 ***** 9를 넘어가면 특수문자
            System.out.print(c++);
        }
    }

}
