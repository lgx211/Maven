package com.lgx.spring.test;


import org.apache.commons.lang3.time.StopWatch;

public class CalculateTime {

    public static void main(String[] args) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();

        Thread.sleep(1000L);
        watch.stop();

        System.out.println(watch.getTime());

        watch.reset();
        watch.start();
        Thread.sleep(2000L);
        System.out.println(watch.getTime());

    }
}
