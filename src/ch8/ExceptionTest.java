package ch8;

public class ExceptionTest {
    public static void main(String[] args) {
//        system.out.println(args[0]);    // 컴파일러 에러. 이클립스가 알아서 컴파일을 해줌.
        System.out.println(args[0]);      // 런타임 에러. 인자가 안 들어왔는데 에러 나서
    }
}
