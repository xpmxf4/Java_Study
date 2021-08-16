package ch4;

// 다음 for 문을 while 문으로 변경하십시오.
// while 문 어떻게 썼더라? ㅋㅋ

public class Exercise4_5$$ {
    public static void main(String[] args) {
//        for(int i=0; i<=10; i++) {
//            for(int j=0; j<=i; j++)
//                System.out.print("*");
//            System.out.println();
//        }

        int i = 0 ;
        while (i <= 10) {
            int j = 0;
            while (j <= i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }

    } // end of main
} // end of class

