package com.lgx.java.algorithm;

import com.alibaba.fastjson.JSONObject;

public class ZigZagConversion {
    /*
       题目5
       给定：一个按N字形的字符串（从上到下，从左到右读取），N的高度
       要求：得到从左到右，从上到下读取的字符串。
   */
    public static void main(String[] args) {
        String string = "0123456789";
//        int height = 1;
        int height = 2;
//        int height = 3;
//        int height = 4;

//        method1(string, height);
        method2(string, height);
    }

    //暴力法，先按照规律，填充进二维数组里，然后再正常读取非空字符。
    //填充数组的循环：if 里手动操作
    // n + n * n 次循环
    public static void method1(String string, int height) {
        if (height == 1) {
            System.out.println(string);
        }

        Character[][] characters = new Character[height][string.length()];

        boolean flag = true;
        int x = 0;
        int y = 0;
        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);

            if (flag) {
                System.out.println("x1:" + x);
                System.out.println("y1:" + y);
                System.out.println("character1:" + character);

                characters[x][y] = character;
                if (x == height - 1) {
                    flag = false;
                    y = y + 1;
                } else {
                    x = x + 1;
                }
            } else {
                x = x - 1;
                System.out.println("x2:" + x);
                System.out.println("y2:" + y);
                System.out.println("character2:" + character);

                characters[x][y] = character;
                if (x == 0) {
                    x = x + 1;
                    flag = true;
                } else {
                    y = y + 1;
                }
            }
        }

        System.out.println(JSONObject.toJSONString(characters));

        StringBuilder stringBuilder = new StringBuilder();
        for (Character[] characterArray : characters) {
            for (Character character : characterArray) {
                if (character != null) {
                    stringBuilder.append(character);
                }
            }
        }
        System.out.println(stringBuilder);

    }

    //下标规律法，在填充进二维数组时，存好。
    //按照行数循环，根据规律找到该行下一个符合条件的直接拼接上
    // n * n 次循环
    public static void method2(String string, int height) {
        if (height == 1) {
            System.out.println(string);
        }

        StringBuilder stringBuilder = new StringBuilder();
        //一个竖和斜为一个周期。n + n - 2
        int cycle = 2 * height - 2;
        int length = string.length();

        //循环行数
        for (int i = 0; i < height; i++) {
            int j = 0;
            int m = i;
            //循环改行的列数，如果字符串可以被截取到
            while (m < length) {
                stringBuilder.append(string.charAt(m));
                j++;
                //下一个符合竖线上的，对应上字符串中的位置
                m = j * cycle + i;

                //下一个符合斜线上的，对应上字符串中的位置
                int n = m - 2 * i;
                if (i > 0 && i < height - 1 && n < length) {
                    stringBuilder.append(string.charAt(n));
                }
            }
        }
        System.out.println(stringBuilder);
    }


    //其它，找规律，打印N字形填充的数组。
    // 以二维数组来循环，导致取下标可能超过长度
    public static void method9(String string, int height) {

        Character[][] characters = new Character[height][string.length()];

        int a = 0;
        int[][] bbb = new int[height][5];
        boolean flag = true;
        for (int j = 0; j < 5; j++) {
            if (flag) {
                //规律1，行标随行数循环+1，列标不变
                for (int i = 0; i < height; i++) {
                    bbb[i][j] = 1;
                    a = i;
                }
                //循环换规律
                flag = false;
                continue;
            }

            //规律2，行数-1，列标随列数循环+1
            bbb[a - 1][j] = 1;

            //循环换规律
            a = a - 1;
            if (a - 1 == 0) {
                flag = true;
            }
        }

        System.out.println(JSONObject.toJSONString(bbb));

    }

}
