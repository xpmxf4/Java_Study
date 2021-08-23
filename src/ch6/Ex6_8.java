package ch6;

class Data3{
    int x;
}

public class Ex6_8 {
    public static void main(String[] args) {
         Data3 d = new Data3();
         d.x = 10;

        Data3 d2 = copy(d); // 호출할 때 보면 참조변수가 없다!. 1. copy 가 static 메서드라 2. copy 가 main 과 같은 클래스안에 있어서이다.

    }

    static Data3 copy(Data3 d) {
        Data3 tmp = new Data3();

        tmp.x = d.x;

        return tmp;
    }
}
