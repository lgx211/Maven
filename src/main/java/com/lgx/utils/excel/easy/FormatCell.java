package com.lgx.utils.excel.easy;

import com.alibaba.excel.EasyExcel;

import static com.lgx.utils.excel.easy.ExcelDate.getData;
import static com.lgx.utils.excel.easy.ExcelDate.getHead;

//根据列来设置文本格式
public class FormatCell {

    public static void main(String[] args) {
        testExport();
    }

    public static void testExport() {
        String fileName = "/Users/bipo/Downloads/111.xlsx";

        EasyExcel.write(fileName)
                .registerWriteHandler(new MyCellFormatStrategy())
                .head(getHead()).sheet("模板")
                .doWrite(getData());
    }
}
