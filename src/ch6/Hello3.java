package ch6;


// 하나의 소스파일에는 하나의 클래스만 작성하는 것이 바람직
class Hello2 {   // 소스파일의 이름은 public class 이름과 일치 해야 한다.
}
class hello3{
    public static void main(String[] args) {
        System.out.println("this is hello3");   // 파일명과 클래스명이 다르더라도, public class 가 없다면 오류는 안 난다.
                                                // 강의에서는 이런 경우에 실행시키면 hello 가 출력되지 않고 엉뚱한게 실행된다.
                                                // 이유는 소스 파일의 이름은 Hello3 인데 코드중에는 Hello3 라는 클래스가 없기 때문이다.
                                                // 하지만 지금은 hello 가 정상 출력이 된다.... why? intellij 라서 되는 건가?
    }
}
class Hello4{}
