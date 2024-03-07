package com.lgx.test;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class T2 {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put(111L, "111");
        map.put(111L, "2222");
        System.out.println(JSONObject.toJSONString(map));
    }
}
