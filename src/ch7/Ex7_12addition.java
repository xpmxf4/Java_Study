package ch7;

public class Ex7_12addition {
    class InstanceInner{
        int iv = 100;
        //        static int cv = 100;
        final static int CONST = 100;
    }

    static class StaticInner{       // **내부 클래스 작성했는 데, 그 안에 static 넣어야 한다?
        int iv = 200;               // **그러면 내부 클래스를 static 내부 클래스로 하면 됨!
        static int cv = 200;            // static 클래스만 static 멤버를 정의할 수 있다.
        final static int CONST = 100;   // 얘는 외부 클래스의 인스턴스 멤버 사용 불가능!
    }                                  // cv 에서 iv 사용 안되는 것처럼!

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
