package ch4;

public class FlowEx33 {
    public static void main(String[] args) {
        Loop1 : for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == 5)
//                  break Loop1;    // Loop1 을 벗어나기에 2단에서 2*4 까지만
//                  break;          // 각 단의 *4 까지 제외하고 출력 *****************
//                  continue Loop1; // 위랑 동일, 단 println() 도 실행이 안됨
//                  continue;       // 위에서 println() 이 포함됨 ****************** 5를 제외한 나머지 다 출력되고, println() 도 실행됨
                System.out.println(i + "*" + j + "=" + i * j);
            }   //end of i loop
            System.out.println();
        }   // end of Loop1

    }
}
