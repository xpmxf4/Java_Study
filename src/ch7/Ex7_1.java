package ch7;

class Tv{   // 멤버 5개
    boolean power;
    int channel;

    void power(){ power = !power;}
    void channelUp() {++channel;}
    void channelDown() {--channel;}
}

class SmartTv extends Tv{   // 상속받은 멤버 5개 + SmartTv  가 가지고 있는 멤버 2개 = 7개
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
        stv.channel = 10;
        stv.channelUp();
        System.out.println(stv.channel);
        stv.displayCaption("Hello, World!");
        stv.caption = true;
        stv.displayCaption("Hello, World!");
    }
}
