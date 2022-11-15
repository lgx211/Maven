package com.lgx.utils.excel.easy;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;

import static com.lgx.utils.excel.easy.ExcelDate.*;

public class BatchWrite {

    public static void main(String[] args) {

        String fileName = "/Users/bipo/Downloads/111.xlsx";

        ExcelWriter excelWriter = EasyExcel.write(fileName).build();
//        WriteSheet writeSheet = EasyExcel.writerSheet("111").build();

        //写入同一个sheet页
        for (int i = 0; i < 5; i++) {
            WriteSheet writeSheet = EasyExcel.writerSheet("111").registerWriteHandler(new MyCellColorStrategy()).build();
            //表头数据
            WriteTable writeTable = new WriteTable();
            writeTable.setHead(getHead());
            excelWriter.write(getData(), writeSheet, writeTable);
        }

        excelWriter.finish();
    }
}
