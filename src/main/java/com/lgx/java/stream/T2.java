package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class T2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "stream");
        //创建顺序流
        Stream<String> stream = list.stream();

        //创建并行流
        Stream<String> parallelStream = list.parallelStream();

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
        System.out.println(111);
        System.out.println(stream1);

        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(3);
        System.out.println(222);
        stream2.forEach(System.out::println);

        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        System.out.println(333);
        stream3.forEach(System.out::println);

    }
}
