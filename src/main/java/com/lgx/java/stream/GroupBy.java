package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world!", "stream");

        //按照字符长度分组
        Map<Integer, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(map);
    }
}
