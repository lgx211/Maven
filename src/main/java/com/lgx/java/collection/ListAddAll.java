package com.lgx.java.collection;

import java.util.ArrayList;
import java.util.List;

//addAll前后都不能为null，实例化后不会空指针异常
public class ListAddAll {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        List<String> list2 = new ArrayList<>();
        list2.add("111");
        list2.add("222");

        list.addAll(list2);
        System.out.println("222");
        System.out.println(list);

        List<String> list3 = null;
        list.addAll(list3);
        System.out.println("333");
        System.out.println(list);

        List<String> list4 = null;
        System.out.println("444");
        list4.addAll(list2);
    }
}
