package ch4;

// 1 + (-2) + 3 + (-4) + ... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이
// 100 이상이 되는 지 구하시오

public class Exercise4_4$$ {
    public static void main(String[] args) {
        int sum = 0, s = 1, num = 0;

//        while (true) {
//            sum += i ;
//
//            if( i > 0 ){
//                i++;
//            }else{
//                i --;
//            }
//            i = -i;
//
//            if(sum >= 100) break;
//        }

//        for(int i=1; sum < 100; i++, s=-s) {
//            num = i * s;
//            sum += num;
//        }

        for (int i = 1; true; i++, s = -s) {
            num = s * i;
            sum += num;

            if(sum >= 100) break;
        }

        System.out.printf(" %d 까지 더할 때 sum 이 100 이상이 된다", num);
    }
}
