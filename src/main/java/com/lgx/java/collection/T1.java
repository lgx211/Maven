package com.lgx.java.collection;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T1 {
    public static void main(String[] args) {
        List<String> aaa = new ArrayList<>();
        aaa.add("111");
        aaa.add("333");
        aaa.add("222");
        Collections.sort(aaa);
        System.out.println(JSONObject.toJSONString(aaa));
    }
}
