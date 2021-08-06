package ch3;

//[3-3] 아래는 변수 의 num 값에 따라  ‘양수’, ‘음수’, ‘0’ 양수 음수 을 출력하는 코드이다 삼항 연산 .
//자를 이용해서 (1) 에 알맞은 코드를 넣으시오

class Exercise3_3 {
    public static void main(String[] args) {
        int num = -9;
        System.out.println( num > 0 ? "양수" : num == 0 ? 0 : "음수");
    }
}