package ch7;

public class Ex7_12 {
    class InstanceInner {
        int iv = 100;
        final static int CONST = 100;
    }

    static class StaticInner{
        int iv = 200;
        static int cv = 200;
        final static int CONST = 200;
    }

    void method(){
        class LocalInner{
            int iv = 300;
            final static int CONST = 300;
        }

        int i = LocalInner.CONST;               // 지역 클래스는 그 지역에서만!
    }

    public static void main(String[] args) {
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);
        System.out.println(StaticInner.CONST);

    }
}
