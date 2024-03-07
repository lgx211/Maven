package com.lgx.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class T12 {
    public static void main(String[] args) {
        List aaa = new ArrayList();
        aaa.add("id");
        aaa.add("'_'");
        aaa.add("db_name");

        System.out.println("AAA===" + JSONObject.toJSONString(aaa));
    }
}
