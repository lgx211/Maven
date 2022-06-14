package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 5, 8, 10);

        //对集合中元素求和
        Integer total = list.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(total);

        //对集合中元素求和
        Integer total2  = list.stream()
                .reduce(0 , Integer::sum);
        System.out.println(total2);

        //对集合中元素求和
        Optional<Integer> total3  = list.stream()
                .reduce(Integer::sum);
        System.out.println(total3);

        //求集合中元素最大值
        Integer max  = list.stream()
                .reduce(0 , Integer::max);
        System.out.println(max);

        //求集合中元素最小值
        Optional<Integer> min  = list.stream()
                .reduce(Integer::min);
        System.out.println(min);
    }
}
