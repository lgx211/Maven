package com.lgx.java.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public class StringToMapList {
    public static void main(String[] args) {

        String compareField = "{\"photo\":[null,\"[\\\"https://static-litedev.oss-cn-shanghai.aliyuncs.com/leave/attachments/733328597443411968/1663579866953/iShot_2022-09-19_16.08.52.png\\\",\\\"https://static-litedev.oss-cn-shanghai.aliyuncs.com/leave/attachments/733328597443411968/1663579870482/iShot_2022-09-19_13.44.27.png\\\"]\"]}";

        //json字符串转Map<List>
        Map<String, List<Object>> compareFields = (Map<String, List<Object>>) JSON.parse(compareField);
        System.out.println("第一次：" + JSONObject.toJSONString(compareFields));

        Object object = compareFields.get("photo").get(1);
        //object转字符串，转list
        List<String> list = (List<String>) JSON.parse(object.toString());
        System.out.println("第二次：" + JSONObject.toJSONString(list));


    }
}
