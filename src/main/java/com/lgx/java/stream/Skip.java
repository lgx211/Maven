package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Skip {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world!", "stream");

        //集合中元素按照自然顺序排序
        List<String> list2 = list.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}
