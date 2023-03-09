package com.lgx.java.algorithm;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
        题目1
        给定：一个数组和一个目标和
        要求：从数组中找两个数字相加等于目标和，输出这两个数字的下标。
    */

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6};
        int total = 6;

//        method1(array, total);
//        method2(array, total);
//        method3(array, total);
        method4(array, total);
    }

    //1，暴力法，两层循环，逐个尝试比较。
    //结果(1,5),(2,4),(3,3),(4,2),(5,1)，有重复且第三个不正确
    // n * n 次循环
    public static void method1(int[] array, int total) {
        for (int i : array) {
            for (int j : array) {
                if (i + j == total) {
                    System.out.println(i);
                    System.out.println(j);
                }
            }
        }
    }

    //2，暴力法，两层循环，逐个尝试比较，跳过自己与自己比较。
    //结果(1,5),(2,4)，正确
    //
    public static void method2(int[] array, int total) {
        for (int i = 0; i < array.length; i++) {
            for (int j = (i + 1); j < array.length; j++) {
                if (array[i] + array[j] == total) {
                    System.out.println(array[i]);
                    System.out.println(array[j]);
                }
            }
        }
    }

    //3,拆除一层循环。借助map的数据格式
    //结果(1,5),(2,4),(3,3),(4,2),(5,1)，有重复且第三个不正确
    //n + n 次循环
    public static void method3(int[] array, int total) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        for (int i : array) {
            int j = total - i;
            if (map.containsKey(j)) {
                System.out.println(i);
                System.out.println(j);
            }
        }
    }

    //4,拆除一层循环。借助map的数据格式
    //结果(1,5),(2,4),(4,2),(5,1)，有重复
    //n + n 次循环
    public static void method4(int[] array, int total) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        for (int i = 0; i < array.length; i++) {
            int sub = total - array[i];
            if (map.containsKey(sub) && map.get(sub) != i) {
                System.out.println(array[i]);
                System.out.println(sub);
            }
        }
    }
}
