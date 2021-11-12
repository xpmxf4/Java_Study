package ch7;

public class Outer {
    private int outerIv = 0;
    private static int outerCv = 0;

    class InstanceInner{
        int iiv = outerIv;
        int iiv2 = outerCv;
    }

    static class StaticInner{
//        int siv = outerIv;    안됨
        int scv = outerCv;
    }

    void myMethod(){
        int lv = 0;         // 값이 바뀌지 않는 변수는 상수로 간주. 그냥 이거 final 붙여서 쓰자!
        final int LV = 0;

//        lv = 3;           이거 있으면 밑에 int liv3 = lv 에 에러가 뜸!
        class LocalInner{   //지역 내부 클래스에서는 외부 메서드의 지역변수는 상수만 사용 가능하다.
                            //그리고 왼만하면 걍 외부 메서드의 지역변수는 상수 붙이자.
                            //왜 상수 붙이는 가만 알고 있자.
            int liv = outerIv;
            int liv2 = outerCv;
            int liv3 = lv;
            int liv4 = LV;
        }
    }
}
