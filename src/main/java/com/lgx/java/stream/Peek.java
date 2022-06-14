package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Peek {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world!", "stream");

        //老集合中元素加上AAA重新组成新集合
        List<String> list2 = list.stream()
                .map(x -> x+"AAA")
                .collect(Collectors.toList());
        System.out.println(list2);
    }

}
