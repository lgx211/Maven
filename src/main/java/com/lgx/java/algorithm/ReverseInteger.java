package com.lgx.java.algorithm;

public class ReverseInteger {
    /*
       题目6
       给定：一个数字
       要求：从右往左读的数字。
   */

    public static void main(String[] args) {
        int a = 1234567;
//        int a = -1234567;
//        int a = -1234567899;
//        int a = 1534236469;

//        method1(a);
//        method2(a);
        method3(a);
    }

    //1,暴力法，数字换成字符串，字符串反转顺序，再转成数字
    //数字反转：字符串数组 for 倒循环，- 特殊判断下处理
    // n 次循环
    public static void method1(int a) {

        String b = String.valueOf(a);
        String[] split = b.split("");

        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int i = split.length - 1; i >= 0; i--) {
            String string = split[i];
            if (!string.equals("-")) {
                stringBuilder.append(split[i]);
            } else {
                flag = true;
            }
        }

        int s = 0;
        //颠倒过来，可能超长
        try {
            if (flag) {
                s = Integer.parseInt(new StringBuilder().append("-").append(stringBuilder).toString());
            } else {
                s = Integer.parseInt(stringBuilder.toString());
            }

        } catch (NumberFormatException e) {
            s = 0;
        }

        System.out.println(s);
    }

    //2,暴力法，数字换成字符串，字符串反转顺序，再转成数字
    //数字反转：reverse方法，- 特殊判断下处理
    // n 次循环
    public static void method2(int a) {

        String b = String.valueOf(a);
        int f = 1;
        if (b.contains("-")) {
            f = -1;
            b = b.substring(1);
        }
        String s = new StringBuilder(b).reverse().toString();

        int c = 0;
        try {
            c = Integer.parseInt(s) * f;
        } catch (NumberFormatException e) {
            c = 0;
        }

        System.out.println(c);
    }

    //求商求余数法，不断求除以10的余数得到反转
    public static void method3(int x) {
        long a = 0;
        while (x != 0) {
            //余数，相当于不断从后往前读取一个值
            int remainder = x % 10;

            a = a * 10 + remainder;

            //商数，相当于不断从后往前截去一个值
            x = x / 10;
        }

        //超过限制就归0
        a = a < Integer.MIN_VALUE || a > Integer.MAX_VALUE ? 0 : a;
        System.out.println(a);
    }

}
