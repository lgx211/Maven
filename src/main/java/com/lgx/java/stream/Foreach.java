package com.lgx.java.stream;

import java.util.Arrays;
import java.util.List;

public class Foreach {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world!", "stream");

        //遍历
        list.stream().forEach(System.out :: println);

    }
}
