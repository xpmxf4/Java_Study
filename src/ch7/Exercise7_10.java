package ch7;
import java.lang.Math;

class MyTv2 {
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;
    boolean isPowerOn;
    int channel;
    int volume;
    int prevChannel;

    int getChannel(){
        return channel;
    }
    void setChannel(int channel) {
        prevChannel = this.channel;
        this.channel = channel;
    }

    int getVolume(){
        return volume;
    }
    void setVolume(int volume){
        this.volume = volume;
    }

    void gotoPrevChannel(){
        int tmp = channel;
        channel = prevChannel;
        prevChannel = tmp;
    }
}

class Exercise7_10 {
    public static void main(String args[]) {
        MyTv2 t = new MyTv2();
        t.setChannel(10);
        System.out.println("CH:"+t.getChannel());
        t.setChannel(20);
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
    }
}
