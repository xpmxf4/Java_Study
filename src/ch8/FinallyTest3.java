package ch8;

public class FinallyTest3 {
    public static void main(String[] args) {
        method1();
        System.out.println("method1()의 수행을 마치고 main메서드로 돌아옴");
    }

    static void method1() {
        try {
            System.out.println("method1()이 호출 되었습니다");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("finally 블록이 실행되었습니다.");
        }
    }
}
