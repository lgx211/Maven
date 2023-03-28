package com.lgx.java.algorithm;

public class StringToInteger {

    /*
       题目6
       给定：一个字符
       要求：从左往右，遇到数字，或者遇到正/负号后立马遇到数字，截取他们。
   */

    public static String regex = "\\d";

    public static void main(String[] args) {

        String s = " qwe +123";
//        String s = " 123 ert 234";
//        String s = " -123 ert 234";
//        String s = " +123 ert 234";
//        String s = "   - 42";
//        String s = "+-42";
//        String s = " + qw42";
//        String s = "9223372036854775808";
//        String s = "-91283472332";

//        System.out.println(method1(s));
        System.out.println(method2(s));
    }

    //1,暴力法，逐个读取字符串，根据规则限制来加条件
    //int,long超过限制，计算都会出问题
    //n 层循环
    public static int method1(String s) {

        long a = 0;
        long b = 1;
        boolean numFlag = false;
        for (int i = 0; i < s.length(); i++) {

            Character character = s.charAt(i);
            String string = character.toString();

            if (string.matches(" ") && !numFlag) {
                //如果匹配空格
                continue;
            }
            if (string.matches("-") && !numFlag) {
                //如果匹配负号
                b = -1;
                numFlag = true;
                continue;
            }
            if (string.matches("\\+") && !numFlag) {
                //如果匹配正号
                b = 1;
                numFlag = true;
                continue;
            }
            if (string.matches(regex)) {
                //如果遇到数字，就组合拼接起来
                a = a * 10 + Integer.valueOf(string);

                System.out.println("a:" + a);

                long tmp = a * b;
                if (tmp > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (tmp < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

                numFlag = true;
                continue;
            } else if (numFlag) {
                //数字后面不是数字。不处理了
                break;
            }
            //如果数字之前不是空格，正负号，数字。不处理了。
            if (!numFlag) {
                break;
            }
        }

        a = a * b;
        return (int) a;
    }

    //2,暴力法，逐个读取字符，根据规则限制来加条件
    //操作字符
    //n 层循环
    public static int method2(String s) {

        long a = 0;
        long b = 1;
        boolean numFlag = false;
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);

            if (character == ' ' && !numFlag) {
                //如果匹配空格
                continue;
            }
            if (character == '-' && !numFlag) {
                //如果匹配负号
                b = -1;
                numFlag = true;
                continue;
            }
            if (character == '+' && !numFlag) {
                //如果匹配正号
                b = 1;
                numFlag = true;
                continue;
            }
            if (Character.isDigit(character)) {
                //如果遇到数字，就组合拼接起来

                a = a * 10 + Character.getNumericValue(character);

                long tmp = a * b;
                if (tmp > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (tmp < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

                numFlag = true;
                continue;
            } else if (numFlag) {
                //数字后面不是数字。不处理了
                break;
            }
            //如果数字之前不是空格，正负号，数字。不处理了。
            if (!numFlag) {
                break;
            }
        }

        a = a * b;
        return (int) a;
    }

}
