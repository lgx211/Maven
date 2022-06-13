package com.lgx.java.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 业务——有m个作业，每个作业含有若干个子任务，后续作业需要上个作业所有子任务执行结束才能开始
 * 原理——主线程等待子线程执行完成再执行
 */
public class CountdownLatchTest1 {

    public static void main(String[] args) {

        //Java的线程池
        ExecutorService service = Executors.newFixedThreadPool(2);
        //计数器定为3
        final CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    System.out.println("子线程"+ Thread.currentThread().getName()+"执行");
                    //计数减一，如果计数到达零，则释放所有等待的线程。
                    latch.countDown();
                }
            };
            service.execute(runnable);
        }

        try {
            //使当前线程在计数至零之前一直等待，除非线程被中断或超出了指定的等待时间。
            //如果当前计数为零，则此方法立刻返回true值。
            latch.await();//阻塞当前线程，直到计数器的值为0

            System.out.println("主线程"+ Thread.currentThread().getName()+"执行");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
