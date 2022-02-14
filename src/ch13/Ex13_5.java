package ch13;

import javax.swing.*;

public class Ex13_5 {
    public static void main(String[] args) {
        ThreadEx5_1 th1 = new ThreadEx5_1();
        th1.start();

        String input = JOptionPane.showInputDialog("값을 입력해주세요");
        System.out.println("입력하신 값은 " + input + " 입니다");
    }
}

class ThreadEx5_1 extends Thread {
    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}