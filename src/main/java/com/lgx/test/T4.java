package com.lgx.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class T4 {
    public static void main(String[] args) {
        String originalString1 = "abc";
        String originalString2 = "abc-123";
        String originalString3 = "a-b_c";
        String originalString4 = "3_b_c";

        List<String> originFieldNameList = new ArrayList<>();
        originFieldNameList.add(originalString1);
        originFieldNameList.add(originalString2);
        originFieldNameList.add(originalString3);
        originFieldNameList.add(originalString4);

        List<String> strings = new ArrayList<>();
        for (String s : originFieldNameList) {
            s = addQuotesIfNeeded(s);
            strings.add(s);
        }
        System.out.println(JSONObject.toJSONString(originFieldNameList));

        String fieldNameStrOrigin = String.join(",", strings);
        System.out.println(fieldNameStrOrigin);

    }

    public static String addQuotesIfNeeded(String input) {
        if (input.matches(".*-.*|^\\d.*")) {
            return "\"" + input + "\"";
        } else {
            return input;
        }
    }
}
