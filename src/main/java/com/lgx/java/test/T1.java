package com.lgx.java.test;

import java.util.Arrays;
import java.util.List;

public class T1 {
    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(3, 6, -10, 6, 19, -10, 15);

        Integer sum = 0;
        Integer max = a.get(0);
        for (Integer integer : a) {
            sum += integer;
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(max);

    }
}
