package com.lgx.java.algorithm;

public class StringToInteger {

    /*
       题目6
       给定：一个字符
       要求：从左往右，直到遇到+或-，开始截取字符转数字
   */

    public static String regex = "\\d";

    public static void main(String[] args) {

//        String s = " qwe  + 123 ert 234";
//        String s = " 123 ert 234";
//        String s = " - 123 ert 234";
//        String s = " + 123 ert 234";
        String s = "   -42";

        method1(s);
    }

    public static void method1(String string) {

        long a = 0;
        long b = 1;
        boolean numFlag = false;
        for (int i = 0; i < string.length(); i++) {

            // 涉及数字，正负号，空格，其它
            Character character = string.charAt(i);
            String s = character.toString();

            //空格不用管
            if (s.equals(" ")) {
                continue;
            }

            //是数字就组合拼接起来
            if (s.matches(regex)) {
                a = a * 10 + Long.valueOf(s);
                numFlag = true;
            } else if (numFlag) {
                //数字后有非数字的，不用管了
                break;
            }else if (!numFlag){
                //在没有出现数字之前
                if (s.matches("-")) {
                    //如果匹配负号
                    b = -1;
                }else if (s.matches("\\+")) {
                    //如果匹配正号，或者没有号，按照默认的走就行
                    b = 1;
                }else{
                    //不是空格，不是数字，不是正负号
                    break;
                }
            }
        }

        a = a * b;
        a = a > Integer.MAX_VALUE ? Integer.MAX_VALUE : a;
        a = a < Integer.MIN_VALUE ? Integer.MIN_VALUE : a;

        System.out.println(a);
    }

}
