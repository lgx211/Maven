package com.lgx.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFilter {
    public static List<String> filterMaps(List<Map<String, Object>> dataList) {
        List<String> keyList = new ArrayList<>();
        if (dataList.isEmpty()) {
            return keyList;
        }

        // 使用第一个 Map 的键集合作为基准
        Map<String, Object> firstMap = dataList.get(0);
        for (String key : firstMap.keySet()) {
            boolean allZero = dataList.stream().allMatch(map -> "0".equals(map.get(key)));
            if (!allZero) {
                keyList.add(key);
            }
        }

        return keyList;
    }

    public static void main(String[] args) {
        List<Map<String, Object>> originalList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id_check", "0");
        map.put("db_id_check", "0");
        map.put("db_name_check", "0");
        map.put("schema_name_check", "1");
        map.put("table_name_check", "1");
        map.put("symbol_check", "0");
        originalList.add(map);

        List<String> filteredList = filterMaps(originalList);
        System.out.println(filteredList);
    }
}

