package com.lgx.java.algorithm;

public class ReverseInteger {
    /*
       题目6
       给定：一个数字
       要求：从右往左读的数字。
   */

    public static void main(String[] args) {
//        int a = 1234567;
//        int a = -1234567;
        int a = -2147483648;

        method1(a);
    }

    public static void method1(int a) {

        System.out.println(Math.pow(-2, 31));
        System.out.println(Math.pow(2, 31)-1);
        if (a < Math.pow(-2, 31) || a > Math.pow(2, 31) - 1) {
            System.out.println(0);
            return;
        }

        String b = String.valueOf(a);
        String[] split = b.split("");

        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int i = split.length - 1; i >= 0; i--) {
            String string = split[i];
            if (!string.equals("-")) {
                flag = true;
                stringBuilder.append(split[i]);
            }
        }


        int s = 0;
        if (flag) {
            s = Integer.parseInt(new StringBuilder().append("-").append(stringBuilder).toString());
        } else {
            s = Integer.parseInt(stringBuilder.toString());
        }

        System.out.println(s);

    }

}
