package com.lgx.test;

import java.util.*;

public class JsonSortExample {

    public static void main(String[] args) {
        List<Map<String, Object>> headList = new ArrayList<>();

        headList.add(createMap("origin_TABLE_NAME", "源:TABLE_NAME", false));
        headList.add(createMap("target_CD_VAL", "目标:CD_VAL", false));
        headList.add(createMap("origin_TABLE_CHINESE_NAME", "源:TABLE_CHINESE_NAME", false));
        headList.add(createMap("target_CD_DESC", "目标:CD_DESC", false));
        headList.add(createMap("origin_CD_VAL", "源:CD_VAL", false));
        headList.add(createMap("target_REM", "目标:REM", false));
        headList.add(createMap("origin_CD_DESC", "源:CD_DESC", false));
        headList.add(createMap("target_TABLE_NAME", "目标:TABLE_NAME", false));
        headList.add(createMap("origin_REM", "源:REM", false));
        headList.add(createMap("target_TABLE_CHINESE_NAME", "目标:TABLE_CHINESE_NAME", false));

        headList.sort(Comparator.comparing(m -> new StringBuilder(m.get("fieldRealName").toString()).reverse().toString()));

        headList.forEach(System.out::println);
    }

    private static Map<String, Object> createMap(String fieldRealName, String fieldShowName, boolean primaryKey) {
        Map<String, Object> map = new HashMap<>();
        map.put("fieldRealName", fieldRealName);
        map.put("fieldShowName", fieldShowName);
        map.put("primaryKey", primaryKey);
        return map;
    }
}
