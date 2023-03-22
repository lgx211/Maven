package com.lgx.java.algorithm;

import com.alibaba.fastjson.JSONObject;

public class ZigZagConversion {
    /*
       题目5
       给定：一个按N字形的字符串（从上到下，从左到右读取），N的高度
       要求：得到从左到右，从上到下读取的字符串。
   */
    public static void main(String[] args) {
        String string = "abcdefg";
//        int height = 3;
//        int height = 1;
        int height = 2;

        method1(string, height);
    }

    //暴力法，先按照规律，填充进二维数组里，然后再正常读取非空字符。
    //填充循环：if 里手动操作
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
                    x = x - 1;
                    y = y + 1;
                } else {
                    x = x + 1;
                }
            } else {
                System.out.println("x2:" + x);
                System.out.println("y2:" + y);
                System.out.println("character2:" + character);

                characters[x][y] = character;
                if (x == 1) {
                    flag = true;
                }
                x = x - 1;
                y = y + 1;
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
