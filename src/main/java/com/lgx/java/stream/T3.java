package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;

public class T3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world!", "hello", "stream");

        //一，静态方法调用方式1
        for(String x : list){
            T3.aaa(x);
        }
        //一，静态方法调用方式2
        list.forEach(T3::aaa);

        //二，实例方法调用方式1
        for(String x : list){
            T3 t3 = new T3();
            t3.bbb(x);
        }
        //二，实例方法调用方式2
        list.forEach(new T3()::bbb);

        //三，数组

    }


    public static void aaa(String x){
        System.out.println(x);
    }

    public void bbb(String x){
        System.out.println(x);
    }
}
