package ch6.practice;

public class Exercise6_23 {
    static int max(int[] arr){
        if(arr==null || arr.length==0) return -999999;
        int result=0;
        for(int n : arr){
            Math.max(result,n);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] data = {3, 2, 9, 4, 7};
        System.out.println(java.util.Arrays.toString(data));
        System.out.println("최대값 : " + max(data));
        System.out.println("최대값 : " + max(null));
        System.out.println("최대값 : " + max(new int[0]));
    }
}
