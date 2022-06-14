package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sorted {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world!", "hello", "stream");

        //集合中元素按照自然顺序排序
        List<String> list2 = list.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}
