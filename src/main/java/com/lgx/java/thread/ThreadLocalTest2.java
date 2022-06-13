package com.lgx.java.thread;

public class ThreadLocalTest2 extends ThreadLocal {
    static ThreadLocalTest2 threadLocalExt = new ThreadLocalTest2();

    @Override
    protected Object initialValue() {
        return "bbb";
    }

    public static void main(String[] args) {
        System.out.println(threadLocalExt.get());
    }
}
