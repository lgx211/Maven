package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningBy {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world!", "stream");

        //按照字符长度是否大于5来分组
        Map<Boolean, List<String>> map = list.stream()
                .collect(Collectors.partitioningBy(x -> x.length() > 5));

        System.out.println(map);
    }
}
