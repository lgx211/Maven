package com.lgx.java.thread;

public class Alive extends Thread {

    @Override
    public void run() {
        System.out.println("run run run is " + this.isAlive());
    }

    public static void main(String[] args) {

        Alive xk = new Alive();
        System.out.println("begin ——— " + xk.isAlive());
        xk.start();
        System.out.println("end ————— " + xk.isAlive());
    }

}
