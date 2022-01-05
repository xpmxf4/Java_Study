package ch8;

import jdk.jshell.spi.ExecutionControl;

public class NotePad {
    public static void main(String[] args) {
        int n = method1();
        System.out.println(n);
    }

    static int method1() {
        try {
            System.out.println("method1() 이 호출 되었습니다.");
            throw new Exception("의도된 에러");
        } catch (Exception e) {
            System.out.println("method1() 의 catch 블럭이 호출 되었습니다.");
            return 1;
        } finally {
            return 3;
        }
    }
}
