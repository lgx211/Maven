package com.lgx.recursion;

public class Queen2 {

    //列标
    static int[] q = new int[20];
    static int count = 0;

    public static void main(String[] args) {
        n_queens(1, 4);
        System.out.println("共有 " + count + " 种摆放方式");
    }

    public static void n_queens(int k, int n) {
        if (k > n) {
            count++;
        } else {
            for (int j = 1; j <= n; j++) {
                // 试探第k行的每一列，找到符合要求的列
                if (isSafe(k, j)) {
                    q[k] = j;
                    // 在确认第 k 行皇后位置的前提下，继续测试下一行皇后的位置
                    n_queens(k + 1, n);
                }
            }
        }
    }

    public static boolean isSafe(int k, int j) {
        for (int i = 1; i < k; i++) {
            // 如果有其它皇后位置同一列上，或者位于该位置的斜线位置上，则该位置无法使用
            if (q[i] == j || Math.abs(i - k) == Math.abs(q[i] - j))
                return false;
        }
        return true;
    }
}
