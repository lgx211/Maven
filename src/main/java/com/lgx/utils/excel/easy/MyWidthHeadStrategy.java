package com.lgx.utils.excel.easy;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.style.column.AbstractHeadColumnWidthStyleStrategy;
import com.alibaba.fastjson.JSONObject;

public class MyWidthHeadStrategy extends AbstractHeadColumnWidthStyleStrategy {

    @Override
    protected Integer columnWidth(Head head, Integer integer) {
        System.out.println(JSONObject.toJSONString(head));
        if (head.getHeadNameList().get(0).equals("国家")) {
            return 20;
        }
        return 10;
    }

}
