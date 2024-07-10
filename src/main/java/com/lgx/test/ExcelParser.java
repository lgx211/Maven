package com.lgx.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelParser {
    private static final String STANDARD_CHINESE_NAME = "标准中文名称";
    private static final String DATA_TYPE = "数据类型";
    private static final String DATA_LENGTH = "数据长度";

    public static void main(String[] args) {
        String filePath = "/Users/richard/Documents/tmp/111.xlsx";
        ExcelParser parser = new ExcelParser();
        parser.parseExcel(filePath);
    }

    public void parseExcel(String filePath) {
        EasyExcel.read(filePath, new AnalysisEventListener<Map<Integer, String>>() {
            private boolean headerFound = false;
            private List<String> requiredColumns = new ArrayList<>();
            private int standardChineseNameIndex = -1;
            private int dataTypeIndex = -1;
            private int dataLengthIndex = -1;

            @Override
            public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
                if (!headerFound) {
                    for (Map.Entry<Integer, String> entry : rowData.entrySet()) {
                        if (STANDARD_CHINESE_NAME.equals(entry.getValue())) {
                            standardChineseNameIndex = entry.getKey();
                        } else if (DATA_TYPE.equals(entry.getValue())) {
                            dataTypeIndex = entry.getKey();
                        } else if (DATA_LENGTH.equals(entry.getValue())) {
                            dataLengthIndex = entry.getKey();
                        }
                    }
                    if (standardChineseNameIndex != -1 && dataTypeIndex != -1 && dataLengthIndex != -1) {
                        headerFound = true;
                        requiredColumns.add(STANDARD_CHINESE_NAME);
                        requiredColumns.add(DATA_TYPE);
                        requiredColumns.add(DATA_LENGTH);
                    }
                } else {
                    String standardChineseNameValue = rowData.get(standardChineseNameIndex);
                    String dataTypeValue = rowData.get(dataTypeIndex);
                    String dataLengthValue = rowData.get(dataLengthIndex);

                    System.out.println(STANDARD_CHINESE_NAME + ": " + standardChineseNameValue);
                    System.out.println(DATA_TYPE + ": " + dataTypeValue);
                    System.out.println(DATA_LENGTH + ": " + dataLengthValue);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                if (!headerFound) {
                    System.out.println("No header row found with the required columns");
                }
            }
        }).sheet().doRead();
    }
}

