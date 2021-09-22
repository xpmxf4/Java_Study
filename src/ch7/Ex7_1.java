package ch7;

class Tv{
    boolean power;
    int channel;

    void power() {power = !power;}
    void channeUp() { ++channel; }
    void channelDown() {--channel; }
}

class SmartTv extends Tv{   // 멤버 변수 5 + 2 개
    boolean caption;
    void displayCaption(String text){
        if(caption){
            System.out.println(text);
        }
    }
}

public class Ex7_1 {
    public static void main(String[] args) {
        SmartTv stv = new SmartTv();
        System.out.println(stv.power);
        System.out.println(stv.channel);
        System.out.println(stv.caption);
        stv.power();
    }
}
