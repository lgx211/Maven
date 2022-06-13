package com.lgx.utils.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class Poi {

    public static void writeExcel(List<UserPojo> userPojos, String fileName) throws IOException {
        //1，创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //2，创建工作表
        XSSFSheet sheet = workbook.createSheet("当前sheet页的名称");
        //取第二个sheet页
        //XSSFSheet sheet = workbook.getSheetAt(1);
        // 3，创建行，创建列
        XSSFRow row;
        XSSFCell cell;
        //4，创建第一行，标题行
        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("用户名称");
        cell = row.createCell(1);
        cell.setCellValue("手机号码");
        cell = row.createCell(2);
        //5，填充其余行，表数据
        for (int i = 0; i < userPojos.size(); i++) {
            UserPojo userPojo = userPojos.get(i);
            //第一行是表头  数据要从第二行开始
            row = sheet.createRow(i + 1);
            Cell cell2 = row.createCell(0);
            cell2.setCellValue(userPojo.getUserName());
            Cell cell5 = row.createCell(1);
            cell5.setCellValue(userPojo.getPhone());
        }
        //6，写入文件中
        FileOutputStream out = new FileOutputStream(new File(fileName));
        workbook.write(out);
        //7，关闭流
        out.close();
    }

}


