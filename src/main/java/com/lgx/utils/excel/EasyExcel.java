package com.lgx.utils.excel;

import java.util.List;

public class EasyExcel {

    public static void writeExcel(List<UserPojo> userPojos, String fileName) {
        com.alibaba.excel.EasyExcel.write(fileName, UserPojo.class).sheet("当前sheet页的名称").automaticMergeHead(true).doWrite(userPojos);
    }

}
