package com.lgx.java.algorithm;

public class MedianTwoSortedArrays {

    /*
        题目3
        给定：两个有序数组
        要求：合并后找到中位数。
    */
    public static void main(String[] args) {
        int[] num = {1, 3};
        int[] num2 = {2, 4};
//        int[] num2 = {2};
        method1(num, num2);
    }

    public static void method1(int[] num, int[] num2) {
        int length = num.length + num2.length;
        int[] all = new int[length];

        for (int i = 0; i < length; i++) {
            if (num[i] < num2[i]) {

            }
        }


    }


}
