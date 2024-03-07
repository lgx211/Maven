package com.lgx.test;

import java.util.Arrays;
import java.util.List;

public class T11 {

    public static void main(String[] args) {
        String[] tableNames = "pkEntity,1,2".split(",");
        List<String> tableList = Arrays.asList(tableNames);
        System.out.println(tableList);
    }
}
