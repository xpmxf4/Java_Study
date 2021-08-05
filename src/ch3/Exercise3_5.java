package ch3;

//아래는 변수 num 의 값 중에서 일의 자리를 1로 바꾸는 코드이다 만일 변수 num 의
//값이 333 이라면 331이 되고 777 이라면 771 이 된다 (1) 에 알맞은 코드를 넣으시오

class Exercise3_5 {
    public static void main(String[] args) {
        int num = 777;
        System.out.println(num - num % 10 + 1);
    }
}
