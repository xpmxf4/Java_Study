package ch7;

public class Ex7_12 {
    class InstanceInner{
        int iv = 100;
        //        static int cv = 100;
        final static int CONST = 100;
    }

    static class StaticInner{
        int iv = 200;
        static int cv = 200;
        final static int CONST = 100;
    }

    void myMethod(){
        class LocalInner{
            int iv = 300;
            //            static int cv = 300;
            final static int CONST = 300;
        }
        int i = LocalInner.CONST;   // 지역 내부 클래스의 static 상수는 메서드 내에서만 사용 가능함!
    }

    public static void main(String[] args) {
//        System.out.println(InstanceInner.iv);
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);
        System.out.println(StaticInner.CONST);
//        System.out.println(LocalInner); // 이건 못씀
    }
}
