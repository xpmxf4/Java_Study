package ch13;

public class Ex13_7 implements Runnable {
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new Ex13_7());
        t.setDaemon(true);
        t.start();

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
            }
            if (i >= 5) autoSave = true;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
            }
            ;

            if (autoSave) {
                System.out.println("작업파일이 자동저장 되었습니다.");
            }
        }
    }
}


