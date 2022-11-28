package com.lgx.utils.excel.easy;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.BooleanUtils;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;

public class MyCellFormatStrategy implements CellWriteHandler {

    private Workbook workbook;

    private CellStyle cellStyle;

    private CellStyle cellStyle2;

    /**
     * 在创建单元格之前调用
     */
    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {

    }

    /**
     * 在单元格创建后调用
     */
    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

    }

    public void afterCellDispose(CellWriteHandlerContext context) {
        if (BooleanUtils.isNotTrue(context.getHead())) {
            Cell cell = context.getCell();

            //Cell Styles 64000 个限制，避免重复创建对象
            if (workbook == null) {
                workbook = context.getWriteWorkbookHolder().getWorkbook();
            }
            if (cellStyle == null) {
                cellStyle = workbook.createCellStyle();
            }

            if (cellStyle2 == null) {
                cellStyle2 = workbook.createCellStyle();
            }

            String stringCellValue = cell.getStringCellValue();
            //如果内容是，就标红
            if (stringCellValue.equals("B333")) {
                Font writeFont = workbook.createFont();
                writeFont.setColor(IndexedColors.RED.getIndex());
                cellStyle.setFont(writeFont);
                cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                cellStyle.setAlignment(HorizontalAlignment.CENTER);
                cell.setCellStyle(cellStyle);
                context.getFirstCellData().setWriteCellStyle(null);
            }

            //如果是数字，则用excel的数字格式
            if (stringCellValue.matches("^[0.0-9.0]+$")){
                cell.setCellType(CellType.NUMERIC);
                cell.setCellValue(Double.parseDouble(stringCellValue));

                cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
                cellStyle2.setAlignment(HorizontalAlignment.CENTER);
                cell.setCellStyle(cellStyle2);
                context.getFirstCellData().setWriteCellStyle(null);
            }

        }
    }
}
