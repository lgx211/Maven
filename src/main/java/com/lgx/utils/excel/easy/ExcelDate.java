package com.lgx.utils.excel.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelDate {

    public static List<List<String>> getHead() {
        List<List<String>> list = new ArrayList<List<String>>();
        list.add(Arrays.asList("姓名"));
        list.add(Arrays.asList("部门"));
        list.add(Arrays.asList("国家"));

        return list;
    }

    public static List<List<String>> getData() {
        List<List<String>> total = new ArrayList<>();
        total.add(Arrays.asList("A111", "A222", "333"));
        total.add(Arrays.asList("B111", "B222", "B333"));
        total.add(Arrays.asList("C111", "C222", "333"));
        return total;
    }
}
