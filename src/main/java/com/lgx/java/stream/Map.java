package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world!", "stream");

        //老集合中元素加上AAA后，重新组成新集合
        List<String> list2 = list.stream()
                .map(x -> x+"AAA")
                .collect(Collectors.toList());
        System.out.println(list2);

        //老集合中元素大写后，重新组成新集合
        List<String> list3 = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(list3);
    }

}
