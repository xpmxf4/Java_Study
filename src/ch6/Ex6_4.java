package ch6;

public class Ex6_4 {
    public static void main(String[] args) {
        MyMath mm = new MyMath();

        long result1 = mm.add(5L, 3L);          // add 메서드 호출 -> add 메서드에 매개 변순 넘겨주고, 작업 끝내면 호출한 곳으로 돌아옴.
        long result2 = mm.subtract(5L, 3L);
        long result3 = mm.multiply(5L, 3L);
        double result4 = mm.divide(5L, 3L);
        long result5 = mm.max(3L, 3L);
        mm.printGugudan(6);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
    }
}

class MyMath{
    void printGugudan(int dan) {
        if (!(2 <= dan && dan <= 9)) {
            return; // 입력받은 단이 2~9가 아니면 메서드 종료하고 호출된 위치로 다시 돌아가기.
        }

        for (int i = 1; i < 10; i++) {
            System.out.printf("%d * %d = %d%n", dan, i, dan * i);
        }

        return; // intellij 는 알아서 이게 필요가 없다고 나오네 ㄷㄷ
    }

    long add (long x, long y) {
        long result = x + y;
        return result;
        // return x + y; 라고 더 간단하게 표현할 수 있다.
    }

    long subtract(long x, long y){
        long result = x - y;
        return result;
    }

    long multiply(long x, long y ) {
        long result = x *y;
        return result;
    }

    long max(long x, long y ) {
        if(x>y) return x ;      // 이거 하나만 두면, x>y 일때만 return 이 존재하는 거라, 꼭 조건식이 거짓일 때도 적어줘야 한다!
        else return y;
    }

    double divide(long x, long y) {
        double result = x/(double)y;
        return result;
    }
}