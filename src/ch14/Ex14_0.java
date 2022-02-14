package ch14;

public class Ex14_0 {
    public static void main(String[] args) {
//        Object obj = (a, b) -> a > b ? a : b;
        Object obj = new Object() {
            int max(int a, int b){
                return a > b ? a : b;
            }
        };

//        int value = obj.max(3, 5);  // obj 로는 max() 를 사용불가
//        그래서 함수형 인터페이스를 사용해야 한다!

//        MyFunction2 obj2 = new MyFunction2(){
//            public int max(int a, int b){
//                return a > b ? a : b;
//            }
//        };

        MyFunction2 obj2 = (a, b) -> a > b ? a : b;
        int value = obj2.max(3, 5);
        System.out.println("value = " + value);
    }
}

@FunctionalInterface
interface MyFunction2{
    public abstract int max(int a, int b);
//    public abstract int min(int a, int b);
}