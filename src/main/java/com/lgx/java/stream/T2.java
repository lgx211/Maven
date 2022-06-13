package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class T2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "stream");
        //创建顺序流
        Stream<String> stream = list.stream();
        System.out.println(stream);

        //创建并行流
        Stream<String> parallelStream = list.parallelStream();
        System.out.println(parallelStream);

        String[] array = {"h", "e", "l", "l", "o"};
        Stream<String> arrayStream = Arrays.stream(array);
        System.out.println(arrayStream);

    }
}
