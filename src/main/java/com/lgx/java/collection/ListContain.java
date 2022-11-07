package com.lgx.java.collection;

import java.util.ArrayList;
import java.util.List;

public class ListContain {

    public static void main(String[] args) {

        List<String> s = new ArrayList<>();
        s.add("123");
        s.add("234");
        s.add("345");

        System.out.println(s.contains("12"));
        System.out.println(s.contains("123"));

        List<String> a = new ArrayList<>();
        System.out.println(a.contains("12"));

        List<String> b = null;
        System.out.println(b.contains("12"));

    }
}
