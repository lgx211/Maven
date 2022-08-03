package com.lgx.recursion;

//斐波那契数列
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(bbb(5));
    }

    // 数学公示：F(n) = F(n - 1) + F(n - 2)
    //样例：1，1，2，3，5，8，13，21……
    public static int bbb(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int m = bbb(n - 1) + bbb(n - 2);
        return m;
    }

}
