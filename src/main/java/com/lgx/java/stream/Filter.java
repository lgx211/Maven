package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world!", "stream");

        //过滤集合中元素长度大于5的
        List<String> list2 = list.stream()
                .filter(x -> x.length() > 5)
                .collect(Collectors.toList());
        System.out.println(list2);

        //过滤集合中元素包含"o"的
        List<String> list3 = list.stream()
                .filter(x -> x.contains("o"))
                .collect(Collectors.toList());
        System.out.println(list3);

    }
}
