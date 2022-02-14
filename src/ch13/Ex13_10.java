package ch13;

public class Ex13_10 {
    public static void main(String[] args) {
        MyThread th1 = new MyThread("th1");
        MyThread th2 = new MyThread("th2");
        MyThread th3 = new MyThread("th3");
        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2 * 1000);
            th1.suspend();
            Thread.sleep(2 * 1000);
            th2.suspend();
            Thread.sleep(2 * 1000);
            th1.resume();
            Thread.sleep(3 * 1000);
            th1.stop();
            th2.stop();
            Thread.sleep(2 * 1000);
            th3.stop();
        } catch (InterruptedException e) {

        }

        System.out.println("main 종료");
    }
}

class MyThread implements Runnable {
    volatile boolean suspended = false;     // volatile 은 쉽게 바뀌는 변수라는 의미, CPU 에서 캐싱을 안하게 만들고 RAM 에서 항상 가져다가 써라
    volatile boolean stopped = false;

    Thread th;

    MyThread(String name) {
        th = new Thread(this, name);
    }

    void start() {
        th.start();
    }

    void stop() {
        stopped = true;
    }

    void suspend() {
        suspended = true;
    }

    void resume() {
        suspended = false;
    }

    @Override
    public void run() {
        while (!stopped) {
            if (!suspended) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}