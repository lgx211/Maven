package com.lgx.utils.excel;

import cn.hutool.poi.excel.ExcelWriter;

import java.util.List;

public class HuTool {

    public static void writeExcel(List<UserPojo> userPojos, String fileName) {
        ExcelWriter writer = new ExcelWriter(fileName);
        //自定义标题别名
        writer.addHeaderAlias("userName", "用户账号");
        writer.addHeaderAlias("phone", "手机号码");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(userPojos, true);
        // 关闭writer，释放内存
        writer.close();

    }
}
