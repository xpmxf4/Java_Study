package ch13;

public class Exercise13_7 {
    static boolean stopped = false;

    public static void main(String[] args) {
        Thread5 th1 = new Thread5();
        th1.start();

        try{
            Thread.sleep(6 * 1000);
        }catch (Exception e){}

        stopped = true;
        th1.interrupt();
        System.out.println("stopped");
    }
}

class Thread5 extends Thread{
    @Override
    public void run() {
        // Exercise13_7.stopped 의 값이 false 인 동안 반복한다.
        for (int i = 0; !Exercise13_7.stopped; i++) {
            System.out.println(i);
            try {
                Thread.sleep(3 * 1000);
            } catch (Exception e) {
            }
        }
    }   // run
}