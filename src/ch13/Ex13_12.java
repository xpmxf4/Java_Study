package ch13;

public class Ex13_12 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx12();
        new Thread(r, "t1").start();
        new Thread(r, "t2").start();

    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            balance -= money;
        }
    } // withdraw
}

class RunnableEx12 implements Runnable {
    Account acc = new Account();

    @Override
    public void run() {
        while (acc.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);

            System.out.println("current Thread : " + Thread.currentThread().getName() + " / used : " + money + " leftover : " + acc.getBalance());
            System.out.println("======================================");
        }
    }
}