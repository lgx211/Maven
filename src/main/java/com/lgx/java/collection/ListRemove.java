package com.lgx.java.collection;

import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRemove {

    public static void main(String[] args) {
        List<String> strList2 = new ArrayList<>();

        strList2.add("a");
        strList2.add("ab");
        strList2.add("ac");
        strList2.add("ad");

        //jdk8
        strList2.removeIf(s -> (s.equals("a")));
        System.out.println("结果" + strList2);

        strList2.removeIf(s -> (s.contains("a")));
        System.out.println("结果2" + strList2);


        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        //iterator
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                iterator.remove();
            }
        }
        System.out.println("结果3" + list);

    }
}
