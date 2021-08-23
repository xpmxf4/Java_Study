package ch6;

class Ex6_1 {
    public static void main(String[] args) {
        //객체생성
        Tv t;               // Tv 인스턴스를 참조하기 위한 변수 t 선언
        t = new Tv();       // Tv 인스턴스 생성하고, t에 인스턴스의 주소 할당

        //객체사용
        t.channel = 7;      // Tv 인스턴스의 멤버변수 channel 의 값을 7로 바꿈
        t.channelDown();    // Tv 인스턴스의 메서드 channelDown 을 호출 -> channel 1 감소
        System.out.println("현재 채널은 " + t.channel + " 입니다. ");   // 현재 채널은 6 입니다.
    }
}

class Tv{
    // Tv 의 속성 (멤버변수)
    String color;
    boolean power;
    int channel;

    // Tv 의 기능 (메서드)
    void power() {power = !power;}
    void channelUp() {channel++;}
    void channelDown() {channel--;}
}