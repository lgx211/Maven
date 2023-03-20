package com.lgx.java.algorithm;

import java.util.Objects;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String string = "abcb";
//        method1(string);
        method2(string);
    }

    //1，暴力法，三层循环，前两层循环得到各子串组合，第三层循环判断该子串是否是回文
    //比较是否回文：循环首尾是否一致
    // n * n * n 次循环
    public static void method1(String string) {
        int max = 0;
        String maxString = "";
        int length = string.length();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                System.out.println("位置：i-" + i + "_j-" + j);
                String substring = string.substring(i, j);
                System.out.println(substring);
                int subLength = substring.length();
                boolean flag = true;
                for (int k = 0; k < subLength; k++) {
                    Character character = substring.charAt(k);
                    Character character2 = substring.charAt(subLength - k - 1);
                    if (!character.equals(character2)) {
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

    //1，暴力法，三层循环，前两层循环得到各子串组合，第三层循环判断该子串是否是回文
    //比较是否回文：循环首尾是否一致
    // n * n * n 次循环
    public static void method2(String string) {
        int max = 0;
        String maxString = "";
        int length = string.length();

        for (int left = 0; left < length; left++) {
            for (int right = left + 1; right < length; right++) {
                boolean flag = true;
                while (left < right) {
                    if (!Objects.equals(string.charAt(left), string.charAt(right))) {
                        flag = false;
                        break;
                    }
                    left ++;
                    right --;
                }
                System.out.println(flag);
                if (flag && (right - left > max)) {
                    max = right - left;
                    maxString = string.substring(left, right);
                }
            }
        }
        System.out.println(max);
        System.out.println(maxString);
    }


}
