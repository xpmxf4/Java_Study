package ch3;

//[3-8] 아래 코드의 문제점을 수정해서 실행결과와 같은 결과를 얻도록 하시오.
//실행결과
//        c=30
//        ch=C
//        f=1.5
//        l=27000000000
//        result=true

class Exercise3_8$$ {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        byte c = (byte)(a + b);                         // *********** 이항 연산은 두 피 연산자의 타입을 일치시킨 후 연산을 수행한다.
                                                        // 그리고 int 보다 ㅈ작은 타입은 int 로 자동변환한다.
                                                        // a 하고 b는 모두 byte 타입이므로, 이항연산인 덧셈연산을 하기 전에 int 타입으로 자동변환 됨.

        char ch = 'A';
        ch = (char) (ch + 2);                   // ch + 2 는 int 값 -> ch에 할당 못함

        float f = 3 / 2f;                        // f 붙여야 됨1
        long l = 3000 * 3000 * 3000L;           // L 붙여야 됨

        float f2 = 0.1f;
        double d = 0.1;

        boolean result = d == f2;               // 타입 불일치

        System.out.println("c=" + c);
        System.out.println("ch=" + ch);
        System.out.println("f=" + f);
        System.out.println("l=" + l);
        System.out.println("result=" + result);
    }
}

