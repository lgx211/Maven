package com.lgx.java.thread;

public class Println extends Thread {
    private int i = 5;
    @Override
    public void run() {
        System.out.println("i="+ (i--) + " threadName=" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Println xk = new Println();
        Thread t1 = new Thread(xk);
        Thread t2 = new Thread(xk);
        Thread t3 = new Thread(xk);
        Thread t4 = new Thread(xk);
        Thread t5 = new Thread(xk);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

}

