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
        total.add(Arrays.asList("A111", "A222", "A333"));
        total.add(Arrays.asList("B111", "B222", "B333"));
        total.add(Arrays.asList("C111", "C222", "C333"));
        return total;
    }

    public static List<List<String>> getData2() {
        List<List<String>> total = new ArrayList<>();
        total.add(Arrays.asList("D111", "D222", "D333"));
        total.add(Arrays.asList("E111", "E222", "E333"));
        total.add(Arrays.asList("F111", "F222", "F333"));
        return total;
    }
}
