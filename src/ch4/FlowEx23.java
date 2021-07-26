package ch4;

public class FlowEx23 {
    public static void main(String[] args){
        int i = 5;

        while (--i != 0) {  // i-- => 조건식안에서는 생각대로 처음에 i = 5 인 상태로 계산된다. 하지만 while 문 안으로 들어가면 바로 i 가 1감소하고,
                            // 그다음에 print 가 찍힌다.
            System.out.printf("%d - I can do it%n", i);
        }
    }
}
