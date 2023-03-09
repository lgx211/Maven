package com.lgx.java.string;

import java.util.Arrays;

public class Split {

    public static void main(String[] args) {
        String a = "1";
        String b = "1,";
        String c = "1,2";
        String d = "";
        String e = null;

        String[] split1 = a.split(",");
        System.out.println(Arrays.toString(split1));

        String[] split2 = b.split(",");
        System.out.println(Arrays.toString(split2));

        String[] split3 = c.split(",");
        System.out.println(Arrays.toString(split3));

        String[] split4 = d.split(",");
        System.out.println(Arrays.toString(split4));

        String[] split5 = e.split(",");
        System.out.println(Arrays.toString(split5));


    }
}
