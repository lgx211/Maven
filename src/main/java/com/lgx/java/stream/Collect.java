package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Collect {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world!","hello", "stream");

        //返回新的list集合
        List<String> list2 = list.stream()
                .collect(Collectors.toList());
        System.out.println(list2);

        //返回新的set集合
        Set<String> set = list.stream()
                .collect(Collectors.toSet());
        System.out.println(set);
    }
}
