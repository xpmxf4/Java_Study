package ch7;

abstract class Player{
    abstract void play(int pos);
    abstract void stop();


}

// 추상클래스는 상속을 통해 완성함
class AudioPlayer extends Player {
    void play(int pos) {
        System.out.println("playing at " + pos);
    }

    void stop(){
        System.out.println("stopped!");
    }
}


public class PlayerTest {
    public static void main(String[] args) {
        Player ap = new AudioPlayer();
        ap.play(2);
        ap.stop();
    }
}
