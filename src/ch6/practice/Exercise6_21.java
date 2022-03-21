package ch6.practice;

public class Exercise6_21 {
    public static void main(String[] args) {
        MyTv tv = new MyTv();

        tv.channel = 100;
        tv.volume = 0;
        System.out.println("CH : " + tv.channel + ", VOL : " + tv.volume);

        tv.channelDown();
        tv.volumeDown();
        System.out.println("CH : " + tv.channel + ", VOL : " + tv.volume);

        tv.volume = 100;
        tv.channelUp();
        tv.volumeUp();
        System.out.println("CH : " + tv.channel + ", VOL : " + tv.volume);
    }
}

class MyTv {
    boolean isPowerOn;
    int     channel;
    int     volume;

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    void turnOnOff(){
        isPowerOn = !isPowerOn;
    }

    void volumeUp(){
        if(volume < MAX_VOLUME) volume++;
    }

    void volumeDown(){
        if(volume > MIN_VOLUME) volume--;
    }

    void channelUp(){
        if(channel==MAX_CHANNEL)channel=MIN_CHANNEL;
        else channel++;
    }

    void channelDown(){
        if(channel==MIN_CHANNEL) channel=MAX_CHANNEL;
        else channel--;
    }

}