package com.lgx.java.collection;

import java.util.ArrayList;
import java.util.List;

//找出a集合中b集合没有的
public class ListContainList {

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);
        b.add(4);

        List<Integer> c = new ArrayList<>();
        for (Integer integer : a) {
            if (!b.contains(integer)) {
                c.add(integer);
            }
        }

        System.out.println(c);

    }
}
