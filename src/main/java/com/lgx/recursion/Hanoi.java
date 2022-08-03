package com.lgx.recursion;

//汉诺塔
public class Hanoi {

    //移动次数
    public static int i = 1;

    public static void main(String[] args) {
        ccc(3, "起始柱", "终点柱", "辅助柱");
    }

    public static void ccc(int n, String start, String end, String center) {
        if (n == 1) {
            System.out.println("第" + i + "次:从" + start + "移动到" + end);
            i++;
            return;
        }
        ccc(n - 1, start, center, end);        // 将起始柱上的 n-1 个圆盘移动到辅助柱上
        System.out.println("第" + i + "次:从" + start + "移动到" + end);
        i++;
        ccc(n - 1, center, end, start);        // 将辅助柱上的 n-1 个圆盘移动到目标柱上
    }
}
