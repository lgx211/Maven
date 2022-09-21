package com.lgx.java.collection;

import com.alibaba.fastjson2.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MapNull {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put(null, "111");
        map.put(null, "222");
        map.put("", "333");
        map.put("1", null);
        // 输出  {"null":"222","":"333"}
        System.out.println(JSONObject.toJSONString(map));



        /*
         * 结论：
         * hashMap、linkedHashMap 可以存储一个 key 为 null ，treeMap 不能存储 key 为 null
         * hashMap，linkedHashMap，treeMap 的 value 可存储多个 null
         * hashTable、concurrentHashMap key与value均不能为null.
         */

    }
}
