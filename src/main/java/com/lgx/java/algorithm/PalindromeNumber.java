package com.lgx.java.algorithm;

public class PalindromeNumber {

    /*
        题目8
        给定：一个数字
        要求：判断该数字是否回文。
    */
    public static void main(String[] args) {

//        int x = 121;
//        int x = 1221;
//        int x = -121;
//        int x = 123;
//        int x = 10;
//        int x = 92;
        int x = 90;
//        int x = 9;

//        method1(x);
        method2(x);
    }

    //1,暴力法，数字转字符串，根据前后字符对比
    //数值对比：前后字符截取是否相同
    // n /2 次循环
    public static void method1(int x) {

        boolean flag = true;

        String string = String.valueOf(x);
        int length = string.length();
        for (int i = 0; i < length / 2; i++) {
            if (string.charAt(i) != string.charAt(length - i - 1)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

    //2,数字倒转法，数字倒转
    //数字对比：倒转前后的数字是否相等
    // n 次循环
    public static void method2(int x) {
        boolean flag = true;

        if (x < 0) {
            flag = false;
        } else {
            int a = x;
            int b = 0;
            while (a != 0) {
                int remainder = a % 10;
                b = b * 10 + remainder;
                a = a / 10;
            }
            if (b != x) {
                flag = false;
            }
        }

        System.out.println(flag);
    }

}
