package ch3;

// [3-9] 다음은 문자형 변수 ch가 영문자( 대문자 또는 소문자 )이거나 숫자일 때만 변수 b
// 의 값이 true 가 되도록 하는 코드이다 (1)에 알맞은 코드를 넣으시오
// 연습문제 /ch3/Exercise3_9.java

// 아얘 모르겠다...


class Exercise3_9$$ {
    public static void main(String[] args) {
        char ch = 'z';
        boolean b = ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || ('0' <= ch && ch<= '9');

        System.out.println("boolean b is "+ b);
    }
}

