package ch4;

public class FlowEx19 {
    public static void main(String[] args){
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 3; j++)
                for (int k = 1; k <= 3; k++)
                    System.out.println(""+ i+j+k);  //  먼저 "" 와 i 가 먼저 결합해서 "1"이 된다.

    }
}
