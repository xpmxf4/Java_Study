package ch3;

// [3-7] 아래는 화씨 를 섭씨 로 변환하는 코드이다 변환공식이 
// 'C = 5/9 ×(F - 32)' 라고 할 때 (1) 에 알맞은 코드를 넣으시오 단 변환 결과값은 소수점
// 셋째자리에서 반올림해야한다 (Math.round() 를 사용하지 않고 처리할 것)
       
class Exercise3_7$$ {
    public static void main(String[] args) {
        int fahrenheit = 100;
        float celcius = 5 /(float) 9 * (fahrenheit - 32);
//        float celcius = (int) (5 / 9f * (fahrenheit - 32) * 100 + 0.5) / 100f;


        System.out.println("Fahrenheit:"+fahrenheit);
        System.out.println("Celcius:"+celcius);
        System.out.printf("Celcius : %2.2f", celcius); // 이렇게 하면 소수 3 번째 자리에서 반올림 일어나서
                                                       // 원하는 결과가 나오게 된다.

    }
}
