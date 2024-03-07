package com.lgx.test;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public void prioritizeKey(List<String> list, String key) {
        list.sort((s1, s2) -> s1.equals(key) ? -1 : s2.equals(key) ? 1 : 0);
    }

    public static void main(String[] args) {
        List<String> distinctSortedKeys = new ArrayList<>();
        distinctSortedKeys.add("ccc");
        distinctSortedKeys.add("aaa");
        distinctSortedKeys.add("bbb");
        distinctSortedKeys.add("eee");
        distinctSortedKeys.add("fff");
        ListUtils listUtils = new ListUtils();
        listUtils.prioritizeKey(distinctSortedKeys, "aaa");

        System.out.println("List with prioritized key: " + distinctSortedKeys);
    }
}

