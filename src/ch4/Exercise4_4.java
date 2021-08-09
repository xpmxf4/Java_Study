package ch4;

// 1 + (-2) + 3 + (-4) + ... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이
// 100 이상이 되는 지 구하시오

public class Exercise4_4 {
    public static void main(String[] args) {
        int sum = 0 , i = 1;

        while (true) {
            sum += i ;
            if( i > 0 ){
                i++;
            }else{
                i --;
            }
            i = -i;

            if(sum >= 100) break;
        }
        System.out.println(i);
        System.out.println(sum);
        System.out.printf("i 가 %d 일때 sum 이 100 이상이 된다", i);
    }
}
