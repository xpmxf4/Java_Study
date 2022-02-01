package ch13;

public class ThreadEx5 {
    static long startTime = 0;

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();
        Thread5_1 t1 = new Thread5_1();
        t1.start();

        for(int i = 0 ; i < 300 ; i++)
            System.out.printf("%s", new String("-"));

        System.out.print("소요 시간 1 : " + (System.currentTimeMillis() - ThreadEx5.startTime));
    }
}

class Thread5_1 extends Thread{
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }

        System.out.print("소요 시간 2 : " + (System.currentTimeMillis() - ThreadEx5.startTime));
    }
}
