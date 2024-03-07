package com.lgx.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Iterator;
import java.util.List;

public class T1 {

    public static void main(String[] args) {
        String jsonData = "[\n" +
                "    {\n" +
                "      \"treeId\": \"1\",\n" +
                "      \"systemName\": \"1\",\n" +
                "      \"parentId\": \"1111\",\n" +
                "      \"childSystems\": [\n" +
                "        {\n" +
                "          \"treeId\": \"2\",\n" +
                "          \"systemName\": \"11\",\n" +
                "          \"parentId\": \"1\",\n" +
                "          \"childSystems\": [\n" +
                "            {\n" +
                "              \"treeId\": \"3\",\n" +
                "              \"systemName\": \"111\",\n" +
                "              \"parentId\": \"2\"\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"treeId\": \"4\",\n" +
                "          \"systemName\": \"12\",\n" +
                "          \"parentId\": \"1\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"treeId\": \"5\",\n" +
                "      \"systemName\": \"2\",\n" +
                "      \"parentId\": \"1111\"\n" +
                "    }\n" +
                "  ]";

        List<SystemEntity> systemEntities = JSON.parseObject(jsonData, new TypeReference<List<SystemEntity>>() {
        });
        String systemNameToFilter = "11";
        recursion(systemEntities, systemNameToFilter);
        System.out.println(JSONObject.toJSONString(systemEntities));
    }

    public static void recursion(List<SystemEntity> dictDataTreeVos, String keyword) {
        Iterator<SystemEntity> iterator = dictDataTreeVos.iterator();
        while (iterator.hasNext()) {
            SystemEntity category = iterator.next();
            if (!category.getSystemName().contains(keyword)) {
                List<SystemEntity> categoryList = category.getChildSystems();
                if (CollectionUtils.isNotEmpty(categoryList)) {
                    recursion(categoryList, keyword);
                }
                // 子级目录为null或空，则移除上一级目录
                if (CollectionUtils.isEmpty(category.getChildSystems())) {
                    iterator.remove();
                }
            }
        }
    }
}

