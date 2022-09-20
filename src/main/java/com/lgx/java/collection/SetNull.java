package com.lgx.java.collection;

import com.alibaba.fastjson2.JSONObject;

import java.util.*;

public class SetNull {
    public static void main(String[] args) {
        /*
        HashSet 的 add 方法调用的是 HashMap 的 put 方法
        其 key 值 为添加的值，其 value 值为 new Object()
        */
        Set<String> stringSet = new HashSet<>();
        stringSet.add("");
        stringSet.add("1");
        stringSet.add("1");
        stringSet.add(null);
        stringSet.add(null);
        // 输出  ["",null,"1"]
        System.out.println(JSONObject.toJSONString(stringSet));

        /*
        LinkedHashSet 的 add 方法调用的是 HashSet 的 add 方法
        同上
        */
        Set linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(null);
        linkedHashSet.add(null);
        linkedHashSet.add("");
        // 输出  [null""]
        System.out.println(JSONObject.toJSONString(linkedHashSet));

        /*
        TreeSet 的 add 方法调用的是 TreeMap 的 put 方法
        添加 null 会导致其中的 compare 方法出空指针异常
        */
        Set<String> treeSet = new TreeSet<>();
        treeSet.add(null);
        System.out.println(JSONObject.toJSONString(treeSet));

        /*
         * 结论：
         * hashSet、linkedSet可以存储一个null. treeSet不能存储null.
         */

    }
}
