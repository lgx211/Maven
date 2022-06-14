package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Distinct {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world!", "hello", "stream");

        //集合中元素去重
        List<String> list2 = list.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list2);
    }

}
