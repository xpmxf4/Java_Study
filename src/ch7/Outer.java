package ch7;

public class Outer {
    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner{
        int iiv = outerIv;
        int icv = outerCv;
    }

    static class StaticInner{
        //        int siv = outerIv;
        int scv = outerCv;
    }

    void myMethod(){
        int lv = 0;         // 값이 바뀌지 않는 변수는 상수로 간주
        final int LV = 0;   //


        class LocalInner{
            int liv = outerIv;
            int liv2 = outerCv;
            int liv3 = lv;  // 원래 외부 클래스의 지역변수(lv)는 final 이 붙은 상수만 가능하다. 왜냐하면 지역변수는 스택에서 함수가 지워지면 같이 없어지지만, 내부 클래스는 이보다 더 오래 살아남는 경우가 있기 때문이다!
                            // 하지만 JDK 1.8 부터, final 로 선언이 되지 않아도 값이 한번도 바뀌지 않았다면 상수로 취급이 되어 이러한 코드가 에러가 안나는 것이다.
                            // 만약 class LocalInner{~} 윗 줄에 lv=3 이라는 코드가 있었다면, int liv3 = lv 는 에러가 난다.
            int liv4 = LV;
        }
    }
}
