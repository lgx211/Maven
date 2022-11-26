package com.lgx.utils.excel.easy;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.BooleanUtils;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class MyCellFormatStrategy implements CellWriteHandler {

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
            //如果是数字，则用excel的数字格式
            String stringCellValue = cell.getStringCellValue();
            if (stringCellValue.matches("-?[0-9]+.?[0-9]*")){
                cell.setCellType(CellType.NUMERIC);
                cell.setCellValue(Integer.parseInt(stringCellValue));
            }

        }
    }
}
