package com.lgx.recursion;

//阶乘
public class Factorial {

    public static void main(String[] args) {
        System.out.println(aaa(5));
    }

    // 数学公示：F(n) = n * F(n - 1)
    //样例：f(5) = 5 * 4 * 3 * 2 * 1
    public static int aaa(int n) {
        if (n == 1) {
            return 1;
        }
        int m = n * aaa(n - 1);
        return m;
    }
}
