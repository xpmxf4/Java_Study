package ch13;

import javax.swing.*;

public class Ex13_9 {
    public static void main(String[] args) {
        ThreadEx9_1 th1 = new ThreadEx9_1();
        th1.start();

        String input = JOptionPane.showInputDialog("값을 입력하세요");
        System.out.println("입력하신 값은 " + input + " 입니다");

        th1.interrupt();
//        System.out.println("th1.isInterrupted() = " + th1.isInterrupted());
//        System.out.println("Thread.interrupted() = " + Thread.interrupted());

    }
}

class ThreadEx9_1 extends Thread {
    @Override
    public void run() {
        int i = 10;

        while(i!=0 && !isInterrupted()){
            System.out.println(i--);
            for(long x=0 ; x < 2500000000L ; x++);
        }
        System.out.println("isInterrupted() = " + isInterrupted());
        System.out.println("Thread.interrupted() = " + Thread.interrupted());
        System.out.println("Thread.interrupted() = " + Thread.interrupted());

        System.out.println("카운트가 종료되었습니다.");
    }
}