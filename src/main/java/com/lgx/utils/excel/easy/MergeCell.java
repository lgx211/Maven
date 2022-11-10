package com.lgx.utils.excel.easy;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeCell {

    public static void main(String[] args) {
        testExport();
    }

    public static void testExport() {
        String fileName = "/Users/bipo/Downloads/111.xlsx";

        EasyExcel.write(fileName)
                .registerWriteHandler(new SimpleColumnWidthStyleStrategy(20))
                .registerWriteHandler(new MyCellMergeStrategy(getCellAddress()))
                .head(getHead()).sheet("模板")
                .doWrite(getData());
    }

    public static List<List<String>> getData() {
        List<List<String>> total = new ArrayList<>();
        total.add(Arrays.asList("A111","A222","A333"));
        total.add(Arrays.asList("B111","B222","B333"));
        total.add(Arrays.asList("C111","C222","C333"));
        return total;
    }

    private static List<List<String>> getHead() {
        List<List<String>> list = new ArrayList<List<String>>();
        list.add(Arrays.asList("姓名"));
        list.add(Arrays.asList("部门"));
        list.add(Arrays.asList("国家"));

        System.out.println("表头:" + list);
        return list;
    }

    private static List<CellRangeAddress> getCellAddress(){
        List<CellRangeAddress> list = new ArrayList<>();
        //合并第2行第3行的的第3列
        CellRangeAddress item1 = new CellRangeAddress(1, 2, 2, 2);
        //合并第3行的的第2列和第3列
        CellRangeAddress item2 = new CellRangeAddress(2, 2, 1, 2);
        list.add(item1);
        list.add(item2);

        return list;
    }
}
