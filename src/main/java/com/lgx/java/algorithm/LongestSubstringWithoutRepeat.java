package com.lgx.java.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class LongestSubstringWithoutRepeat {

    /*
        题目2
        给定：一个字符串
        要求：找到没有重复字符的最长子串，返回它的长度。
    */
    public static void main(String[] args) {
//        String string = "abca";
//        String string = "abba";
        String string = "abac";

//        method1(string);
//        method2(string);
//        method3(string);
        method4(string);
//        method5(string);
//        method6(string);
    }

    //1，暴力法，三层循环，前两层循环得到各子串组合，第三层循环判断该子串是否有重复
    //比较是否重复：看字符出现的位置
    // n * n * n 次循环
    public static void method1(String string) {
        int max = 0;
        String maxString = "";

        int length = string.length();
        for (int i = 0; i <= length; i++) {
            //截取字符串，j必须大于i
            for (int j = i + 1; j <= length; j++) {
                System.out.println("i:" + i + "——j:" + j);
                String substring = string.substring(i, j);
                System.out.println("substring:" + substring);

                boolean flag = true;
                String[] split = substring.split("");
                for (String s : split) {
                    //第一个字符的位置和最后一个字符的位置不同，肯定是重复了
                    if (substring.indexOf(s) != substring.lastIndexOf(s)) {
                        System.out.println("重复");
                        flag = false;
                        break;
                    }
                }
                if (flag && substring.length() > max) {
                    max = substring.length();
                    maxString = substring;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxString);
    }

    //2，暴力法，三层循环，前两层循环得到各子串组合，第三层循环判断该子串是否有重复
    //比较是否重复：set判断
    // n * n * n 次循环
    public static void method2(String string) {
        int n = string.length();
        int max = 0;
        String maxString = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.println("i:" + i + "——j:" + j);
                Set<Character> set = new HashSet<>();
                boolean flag = true;
                //各个组合的字符子串，判断是否有重复的字符
                for (int k = i; k < j; k++) {
                    Character character = string.charAt(k);
                    if (set.contains(character)) {
                        flag = false;
                    }
                    //不在的话将该字符添加到 set 里边
                    set.add(character);
                }
                if (flag) {
                    max = Math.max(max, j - i);
                }
            }
        }

        System.out.println(max);
        System.out.println(maxString);
    }

    //3，滑动窗口法，一层循环，有重复字符就直接从下个滑动，过程中记录对比最大
    //比较是否重复：indexOf 判断，底层是一个循环
    // n 次循环
    public static void method3(String string) {

        List<Character> characters = new ArrayList<>();
        int max = 0;
        String maxString = "";

        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            int j = characters.indexOf(character);
            if (j >= 0) {
                characters = characters.subList(j + 1, characters.size());
                System.out.println("删除：" + JSONObject.toJSONString(characters));
            }
            characters.add(character);
            System.out.println("添加：" + JSONObject.toJSONString(characters));

            if (max <= characters.size()) {
                max = characters.size();
                maxString = characters.toString();
            }

        }
        System.out.println(max);
        System.out.println(maxString);
    }

    //4，滑动窗口法，一层循环，有重复字符就直接从下个滑动，过程中记录对比最大
    //比较是否重复：map 判断
    // n 次循环
    public static void method4(String string) {

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        String maxString = "";

        for (int right = 0; right < string.length(); right++) {
            Character character = string.charAt(right);
            if (map.containsKey(character)) {
                left = Math.max((map.get(character) + 1), right);
            }
            map.put(character, right);

            int x = right - left + 1;
            if (max < x) {
                max = x;
                maxString = string.substring(left, right + 1);
            }
            System.out.println("map:" + JSONObject.toJSONString(map));
        }
        System.out.println(max);
        System.out.println(maxString);
    }

    public static void method5(String string) {

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        String maxString = "";

        for (int right = 0; right < string.length(); right++) {
            Character character = string.charAt(right);
            if (map.containsKey(character)) {
                left = Math.max(map.get(character), left);
            }

            map.put(character, right + 1);

            int tmp = right - left + 1;
            if (max < tmp) {
                max = tmp;
                maxString = string.substring(left, right + 1);
            }
        }
        System.out.println(max);
        System.out.println(maxString);
    }

    //其它，拆除一层循环。借助map的数据格式，第一层得到各个字符重复的位置，第二层看各个字符位置之间的最大间隔。
    // 失败，最大间隔可能有其它重复的字符
    //比较是否重复：set判断
    // n + n * n 次循环
    public static void method9A(String string) {
        int length = string.length();

        //记录字符的位置信息
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Character character = string.charAt(i);
            List<Integer> integers = new ArrayList<>();
            integers.add(i);
            if (map.containsKey(character)) {
                integers = map.get(character);
                integers.add(i);
                map.put(character, integers);
            } else {
                map.put(character, integers);
            }
        }

        System.out.println(JSONObject.toJSONString(map));

        int max = 0;
        String maxString = "";
        for (Character character : map.keySet()) {
            List<Integer> list = map.get(character);
            for (int i = list.size() - 1; i > 0; i--) {
                Integer temp = list.get(i) - list.get(i - 1);
//            max = Math.max(max, temp);
                if (max < temp) {
                    max = temp;
                    maxString = string.substring(list.get(i - 1), list.get(i));
                }
            }
        }
        System.out.println(max);
        System.out.println(maxString);
    }

    //其它，拆除两层循环。借助 while 循环形式。
    //失败，最大间隔可能有其它重复的字符
    //比较是否重复：set判断
    // n 次循环
    public static void method9B(String string) {
        int length = string.length();
        Set<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        String maxString = "";

        while (j < length) {
            Character character = string.charAt(j++);
            if (!set.contains(character)) {
                set.add(character);
                if (max < j - i) {
                    max = j - i;
                    maxString = string.substring(i, j);
                }
                System.out.println("set1:" + JSONObject.toJSONString(set));
            } else {
                Character characterI = string.charAt(i++);
                set.remove(characterI);
                System.out.println("set2:" + JSONObject.toJSONString(set));
            }
        }

        System.out.println(max);
        System.out.println(maxString);
    }


}
