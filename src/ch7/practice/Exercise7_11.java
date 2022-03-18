package ch7.practice;

class MyTv2{
    public boolean isPowerOn() {
        return isPowerOn;
    }

    public void setPowerOn(boolean powerOn) {
        isPowerOn = powerOn;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        prevChannel = this.channel;
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    boolean isPowerOn;
    int     channel;
    int     volume;
    int prevChannel;

    final int MAX_VOLUME    = 100;
    final int MIN_VOLUME    = 0;
    final int MAX_CHANNEL   = 100;
    final int MIN_CHANNEL   = 1;

    void goToPrevChannel(){
        int tmp = channel;
        channel = prevChannel;
        prevChannel = tmp;
    }
}
public class Exercise7_11 {
    public static void main(String[] args) {
        MyTv2 t = new MyTv2();

        t.setChannel(10);
        System.out.println("CH : " + t.getChannel());
        t.setChannel(20);
        System.out.println("CH : " + t.getChannel());
        t.goToPrevChannel();
        System.out.println("CH : " + t.getChannel());
        t.goToPrevChannel();
        System.out.println("CH : " + t.getChannel());
    }
}
