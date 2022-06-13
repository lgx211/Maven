package com.lgx.java.thread;

public class ThreadLocalTest1 {
    public static ThreadLocal threadLocal = new ThreadLocal();

    protected Object initialValue() {
        return "bbb";
    }

    public static void main(String[] args) {
        if (threadLocal.get() == null) {
            System.out.println("");
            //设置值
            threadLocal.set("aaa");
        }
        //获取值
        System.out.println(threadLocal.get());
    }
}
