package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Find {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world!", "stream");

        //找符合结果的第一个
        Optional<String> list2 = list.stream()
                .filter(x -> x.contains("o"))
                .findFirst();
        System.out.println(list2);

        //找符合结果的任意一个
        Optional<String> list3 = list.stream()
                .filter(x -> x.contains("o"))
                .findAny();
        System.out.println(list3);


    }

}
