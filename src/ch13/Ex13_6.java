package ch13;

public class Ex13_6 {
    public static void main(String[] args) {
        ThreadEx6_1 th1 = new ThreadEx6_1();
        ThreadEx6_2 th2 = new ThreadEx6_2();

        th1.setPriority(7);
        th2.setPriority(2);

        System.out.println("th1.getPriority() = " + th1.getPriority());
        System.out.println("th2.getPriority() = " + th2.getPriority());

        th1.start();
        th2.start();
    }
}

class ThreadEx6_1 extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
    }
}

class ThreadEx6_2 extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
    }
}