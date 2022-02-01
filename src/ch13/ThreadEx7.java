package ch13;

import javax.swing.JOptionPane;

public class ThreadEx7 {
    public static void main(String[] args) {
        ThreadEx7_1 t1 = new ThreadEx7_1();
        t1.start();

        String input = JOptionPane.showInputDialog("값을 입력하세요");
        System.out.println("input = " + input);

    }
}


class ThreadEx7_1 extends Thread {
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(500);
            } catch (Exception e) {
            }
        }
    }
}