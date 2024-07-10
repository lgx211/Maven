package com.lgx.test;

import java.util.HashMap;
import java.util.Map;

public class T16 {
    public static Map<String, String> mergeMaps(Map<String, String> excelTableMap, Map<String, String> trueTableMap) {
        Map<String, String> resultMap = new HashMap<>();

        for (Map.Entry<String, String> entry : trueTableMap.entrySet()) {
            String trueChineseName = entry.getKey();
            String trueEnglishName = entry.getValue();

            if (excelTableMap.containsKey(trueChineseName)) {
                String excelEnglishName = excelTableMap.get(trueChineseName);
                resultMap.put(trueEnglishName, excelEnglishName);
            }
        }

        return resultMap;
    }

    public static void main(String[] args) {
        // 示例数据
        Map<String, String> excelTableMap = new HashMap<>();
        excelTableMap.put("表中文名1", "表英文名1");
        excelTableMap.put("表中文名2", "表英文名2");

        Map<String, String> trueTableMap = new HashMap<>();
        trueTableMap.put("表中文名1", "表英文名2");
        trueTableMap.put("表中文名3", "表英文名3");

        // 合并两个Map
        Map<String, String> resultMap = mergeMaps(excelTableMap, trueTableMap);

        // 打印合并后的结果
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
