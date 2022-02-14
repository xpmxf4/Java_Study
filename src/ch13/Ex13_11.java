package ch13;

public class Ex13_11 {
    // 이 실습의 요지는, main 쓰레드가 종료되어도 다른 쓰레드가 실행중이면 프로그램은 계속 돌아간다는 것!
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx11_1 t1 = new ThreadEx11_1();
        ThreadEx11_2 t2 = new ThreadEx11_2();
        t1.start();
        t2.start();
        startTime = System.currentTimeMillis();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }

//        System.out.println("main 쓰레드가 종료되는 데 걸린 시간 : " + (System.currentTimeMillis() - startTime));
        System.out.println("main 종료");
    }
}

class ThreadEx11_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("1");
        }
    }
}

class ThreadEx11_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("2");
        }
    }
}