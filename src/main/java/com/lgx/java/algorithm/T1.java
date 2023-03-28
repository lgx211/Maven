package com.lgx.java.algorithm;

import com.alibaba.fastjson.JSONObject;

public class T1 {

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(s.substring(0, 0));
        System.out.println(s.substring(0, 1));
        System.out.println(s.substring(1, 3));

        System.out.println(1 / 2);
        System.out.println(2 / 2);
        System.out.println(3 / 2);

        int arr[][] = {{1, 2}, {3, 4, 5}, {6, 7}};
        System.out.println(JSONObject.toJSONString(arr));

        System.out.println("取商" + 123 / 10);
        System.out.println("取余" + 123 % 10);

//        System.out.println(Integer.parseInt("-8463847412"));

        long a = 922337203685477580L * 10 + Long.valueOf("8");
        long b = 922337203685477580L * 10 + 8;
        System.out.println("a:" + a);
        System.out.println("b:" + b);

        long c = 0;
        Character character = 4;
        c = c * 10 + character;
        System.out.println("c:" + c);
    }
}
