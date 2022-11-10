package com.lgx.utils.excel.easy;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ColorCell {

    public static void main(String[] args) {
        testExport();
    }

    public static void testExport() {
        String fileName = "/Users/bipo/Downloads/111.xlsx";

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(1));
        map.put(2, Arrays.asList(1, 2));

        EasyExcel.write(fileName)
                .registerWriteHandler(new MyCellColorStrategy())
                .head(getHead()).sheet("模板")
                .doWrite(getData());
    }

    public static List<List<String>> getData() {
        List<List<String>> total = new ArrayList<>();
        total.add(Arrays.asList("A111", "A222", "A333"));
        total.add(Arrays.asList("B111", "B222", "B333"));
        total.add(Arrays.asList("C111", "C222", "C333"));
        return total;
    }

    private static List<List<String>> getHead() {
        List<List<String>> list = new ArrayList<List<String>>();
        list.add(Arrays.asList("姓名"));
        list.add(Arrays.asList("部门"));
        list.add(Arrays.asList("国家"));

        return list;
    }

}
