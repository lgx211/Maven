package com.lgx.java.executor;

import java.util.concurrent.*;

public class T1 {

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();//单个线程数量
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);//指定线程数量
        ExecutorService executorService3 = Executors.newCachedThreadPool();//伸缩线程数量

        ExecutorService executorService4 = new ThreadPoolExecutor(2 , 3 ,
                3 , TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

    }

}
