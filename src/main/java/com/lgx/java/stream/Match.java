package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;

public class Match {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world!", "stream");

        //集合中元素是否都包含"o"
        boolean flag = list.stream()
                .allMatch(x -> x.contains("o"));
        System.out.println(flag);

        //集合中元素是否有任一包含"o"
        boolean flag2 = list.stream()
                .anyMatch(x -> x.contains("o"));
        System.out.println(flag2);

        //集合中元素是否都不包含"o"
        boolean flag3 = list.stream()
                .noneMatch(x -> x.contains("o"));
        System.out.println(flag3);
    }
}
