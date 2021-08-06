package ch5;

public class ArrayEx7 {
    public static void main(String[] args) {
        int[] numArr = new int[10];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = i;
            System.out.print(numArr[i]);
        }
        System.out.println();

        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random() * 10);     //0 에서 9 사이
            int tmp = numArr[0];                    //int tmp = 0
            numArr[0] = numArr[n];                  //numArr[0] 하고 numArr[n] 하고 교체
            numArr[n] = tmp;
        }
        for (int i =0 ; i < numArr.length; i++){
            System.out.print(numArr[i]);
        }

    }
}
