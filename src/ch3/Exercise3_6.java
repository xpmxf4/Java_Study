package ch3;

// [3-6] 아래는 변수 num 의 값보다 크면서도 가장 가까운 10의 배수에서 변수 num 의 값을
// 뺀 나머지를 구하는 코드이다 예를 들어 24의 크면서도 가장 가까운 10의 배수는 30이다
// 19 의 경우 20 이고 81 의 경우 90 이 된다
// 30 에서 24를 뺀 나머지는 6 이기 때문에 변수 num
// 값이 24라면 6을 결과로 얻어야 한다 에 알맞은 코드를 넣으시오 num 24 6 . (1) .
// [Hint] 나머지 연산자를 사용하라.

class Exercise3_6 {
    public static void main(String[] args) {
        int num = 24;
        int closeDec = ((num / 10) + 1) * 10;
        int result = closeDec - num;

        System.out.println(result);
    }
}