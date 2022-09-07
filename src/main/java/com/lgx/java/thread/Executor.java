package com.lgx.java.thread;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {
    /** 固定的线程池（当前线程池大小为5） */
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {
        /**
         *  两个要点：
         *  1.用Executors实现固定大小的线程池，从而达到控制硬件资源消耗的目的。
         *  2.用CountDownLatch（闭锁），来确保循环内的多线程都执行完成后，再执行后续代码
         */

        // 初始化数据
        List<Map<String,Object>> list = new ArrayList<>();
        for(int i=0;i<1;i++){
            Map<String,Object> object = new HashMap<>();
            object.put("index",i);
            list.add(object);
        }

        // 初始化计时器
        CountDownLatch cdl = new CountDownLatch(list.size());
        System.out.println("====== 线程开始 =====");

        // 遍历
        for(Map<String,Object> object:list){
            // 开启线程
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 模拟运行耗时
                        Thread.sleep(500);
                        System.out.println("执行到"+object.get("index"));
                        object.put("status","已经执行过");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 闭锁-1
                    cdl.countDown();
                }
            });
        }

        // 调用闭锁的await()方法，该线程会被挂起，它会等待直到count值为0才继续执行
        // 这样我们就能确保上面多线程都执行完了才走后续代码
        cdl.await();

        //关闭线程池
        executor.shutdown();
        System.out.println("====== 线程结束 =====");

        // 校验多线程正确性
        for(Map<String,Object> object:list){
            System.out.println(object.get("index") + ":" + object.get("status"));
        }

    }
}
