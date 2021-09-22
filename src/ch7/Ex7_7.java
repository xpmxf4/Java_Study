package ch7;

class Car{
    String color;
    int door;

    void drive(){
        System.out.println("drive,Brrrr~");
    }

    void stop(){
        System.out.println("stop!");
    }
}

class FireEngine extends Car{
    void water() {
        System.out.println("water!!!");
    }
}

public class Ex7_7 {
    public static void main(String[] args) {
         Car car = null;
//         FireEngine fe = null;  //실제 인스턴스가 무엇인지가 중요함!
         FireEngine fe = new FireEngine();

         FireEngine fe2 = (FireEngine) car;
         fe2.water();
         Car car2 = (Car) fe2;
         car2.drive();  // 이렇게 하면 코드상에선 모르는데, 실행하면 nullPointException 이라는 오류가 뜨게 된다.
                        // 지금 다 null 이고 실객체를 만든적이 없음!!
                        //
//         FireEngine fe = new FireEngine();
//         FireEngine fe2 = null;

//        fe.water();
//        car = fe;  // car = (Car) fe; 에서 형변환 생략
//        car.water()   // 에러. Car 타입의 참조변수로는 water() 사용불가능임!!!
//        fe2 = (FireEngine) car;
//        fe2.water();
    }
}
