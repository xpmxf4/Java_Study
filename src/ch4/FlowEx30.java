package ch4;

public class FlowEx30 {
    public static void main(String[] args){
        int sum = 0;
        int i = 0;

        while (true) {
            if (sum > 100) {
                break;
            }
            ++i;
            sum += i;
        }

        System.out.printf("i = %d%n", i);
        System.out.printf("sum = %d", sum);
    }
}
