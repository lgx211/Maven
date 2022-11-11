package com.lgx.utils.excel.easy;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.ArrayList;
import java.util.List;

import static com.lgx.utils.excel.easy.ExcelDate.getData;
import static com.lgx.utils.excel.easy.ExcelDate.getHead;

//合并单元格
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
