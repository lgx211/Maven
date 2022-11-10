package com.lgx.utils.excel.easy;

import com.alibaba.excel.write.handler.AbstractSheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

public class MyCellMergeStrategy extends AbstractSheetWriteHandler {

    //合并坐标集合
    private List<CellRangeAddress> cellRangeAddressList;

    public MyCellMergeStrategy(List<CellRangeAddress> cellRangeAddressList) {
        this.cellRangeAddressList = cellRangeAddressList;
    }

    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        cellRangeAddressList.forEach(cellRangeAddress -> writeSheetHolder.getSheet().addMergedRegionUnsafe(cellRangeAddress));
    }

}
