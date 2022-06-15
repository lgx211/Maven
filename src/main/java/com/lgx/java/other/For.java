package com.lgx.java.other;

import java.util.Arrays;
import java.util.List;

public class For {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world!", "hello", "stream");
        //遍历方式一。for循环
        for (String x : list) {
            System.out.println(x);
        }

        //遍历方式二。lambda表达式
        list.forEach(x -> {
            System.out.println(x);
        });

        //遍历方式三。lambda表达式
        list.forEach(x -> System.out.println(x));

        //遍历方式四。::双冒号
        list.forEach(System.out::println);
    }
}
