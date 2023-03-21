package com.lgx.java.algorithm;

import java.util.Objects;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
//        String string = "abcb";
//        String string = "a";
//        String string = "ab";
        String string = "aaa";
//        String string = "baabc";
//        String string = "babad";
//        method1(string);
//        method2(string);
//        method3(string);
        method4(string);
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
                System.out.println("字符：" + substring);
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

    //2，暴力法，三层循环，前两层循环得到各子串组合，第三层循环判断该子串是否是回文
    //比较是否回文：循环首尾是否一致
    //优化：1，减少第二层循环，比i+max小的肯定不是最大的回文，就不用检查了。2，减少第三层循环的一半。3，只要下标，不截取。
    // n * n * n/2 次循环
    public static void method2(String string) {
        int max = 0;
        String maxString = "";
        int length = string.length();
        for (int left = 0; left < length; left++) {
            for (int right = left + max; right <= length; right++) {
                boolean flag = true;
                for (int i = 0; i < (right - left) / 2; i++) {
                    Character character = string.charAt(left + i);
                    Character character2 = string.charAt(right - i - 1);
                    if (!character.equals(character2)) {
                        flag = false;
                        break;
                    }
                }
                if (flag && max < right - left) {
                    max = right - left;
                    maxString = string.substring(left, right);
                }
            }
        }
        System.out.println(max);
        System.out.println(maxString);
    }

    //中心拓展法
    //3，中心拓展法，二层循环，第一层循环各个字符串，第二场以该字符串为中心往外拓展是否有符合条件的
    //比较是否回文：该字符串左右是否一致
    // n * 2n 次循环
    public static void method3(String string) {
        int max = 0;
        String maxString = "";
        int length = string.length();

        for (int i = 0; i < length; i++) {
            //一个中心
            int left = i;
            int right = i;
            while (left >= 0 && right < length) {
                System.out.println("left字符:" + string.charAt(left));
                System.out.println("right字符:" + string.charAt(right));

                if (!Objects.equals(string.charAt(left), string.charAt(right))) {
                    break;
                }
                left--;
                right++;
            }
            //两个中心
            int left2 = i;
            int right2 = i + 1;
            while (left2 >= 0 && right2 < length) {
                if (!Objects.equals(string.charAt(left2), string.charAt(right2))) {
                    break;
                }
                left2--;
                right2++;
            }

            //下标往中心移一个，因为上次的条件满足已经使其往外扩了一个，这次不满足，下标还是上次已经扩过的。
            if (right2 - left2 > right - left) {
                left = left2 + 1;
                right = right2 - 1;
            } else {
                left = left + 1;
                right = right - 1;
            }

            System.out.println("left下标:" + left);
            System.out.println("right下标:" + right);

            if (max <= right - left) {
                max = right - left + 1;
                maxString = string.substring(left, right + 1);
            }
        }
        System.out.println(max);
        System.out.println(maxString);
    }

    //中心拓展法
    //4，中心拓展法，二层循环，第一层循环各个字符串，第二场以该字符串为中心往外拓展是否有符合条件的
    //比较是否回文：该字符串左右是否一致
    //优化：提取公共方法
    // n * 2n 次循环
    public static void method4(String string) {
        int max = 0;
        String maxString = "";
        int length = string.length();

        for (int i = 0; i < length; i++) {
            //一个中心
            int oneCenterRight = centerExpend(i, i, string);
            int twoCenterRight = centerExpend(i, i + 1, string);
            int left = 0;
            int right = 0;
            //根据右标推出左标
            if (oneCenterRight < twoCenterRight) {
                right = twoCenterRight;
                //left + right = center + center + 1;
                left = 2 * i + 1 - right;
            } else {
                right = oneCenterRight;
                //left + right = 2 * center
                left = 2 * i - right;
            }

            if (max <= right - left) {
                max = right - left + 1;
                maxString = string.substring(left, right + 1);
            }
        }
        System.out.println(max);
        System.out.println(maxString);
    }

    public static int centerExpend(int left, int right, String string) {
        while (left >= 0 && right < string.length()) {
            if (!Objects.equals(string.charAt(left), string.charAt(right))) {
                break;
            }
            left--;
            right++;
        }
        //下标往中心移一个，因为上次的条件满足已经使其往外扩了一个，这次不满足，下标还是上次已经扩过的。
        return right - 1;
    }

}
