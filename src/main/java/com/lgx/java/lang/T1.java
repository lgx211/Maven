package com.lgx.java.lang;

import org.apache.commons.lang3.time.StopWatch;

public class T1 {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(1000);
        stopWatch.stop();
        System.out.println("111:"+stopWatch.getTime());

        stopWatch.reset();
        stopWatch.start();
        Thread.sleep(1000);
        stopWatch.stop();
        System.out.println("222:"+stopWatch.getTime());

    }
}
