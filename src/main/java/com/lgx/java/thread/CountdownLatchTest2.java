package com.lgx.java.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchTest2 {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        final CountDownLatch latch1 = new CountDownLatch(1);
        final CountDownLatch latch2 = new CountDownLatch(4);

        for (int i = 0; i < 4; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("选手" + Thread.currentThread().getName() + "正等待裁判口令");
                        latch1.await();

                        System.out.println("选手" + Thread.currentThread().getName() + "已接受裁判口令");
                        Thread.sleep(1000);

                        System.out.println("选手" + Thread.currentThread().getName() + "到达终点");
                        latch2.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
        try {
            Thread.sleep(1000);

            System.out.println("赛跑比赛开始");
            latch1.countDown();

            //上个主线程计数器变为0，让下个主线程的所有子线程同时触发
            System.out.println("裁判发送口令，正在等待所有选手到达终点");
            latch2.await();

            System.out.println("所有选手都到达终点");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}
