package ch7;

class AAA {
    int i = 100;
    BBB b = new BBB();

    class BBB { // BBB는 AAA의 내부클래스
        void method(){
            System.out.println(i);  // 객체 생성없이 외부 클래스의 멤버 접근 가능!
        }
    }
}


//class CCC{
//    BBB b = new BBB();
//}

public class InnerTest {
    public static void main(String[] args) {
        AAA a = new AAA();

    }
}
