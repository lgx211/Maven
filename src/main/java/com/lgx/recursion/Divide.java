package com.lgx.recursion;

public class Divide {
    public static void main(String[] args) {
//        int[] arr = new int[]{3, 7, 2, 1};
        int[] arr = new int[]{3 , 4 , 5};

        int max = get_max(arr, 0, 2);
        System.out.println("最大值：" + max);
    }

    public static int get_max(int[] arr, int left, int right) {
        //结束条件：小于2个，直接比较
        if (right - left <= 1) {
            if (arr[left] >= arr[right]) {
                return arr[left];
            }
            return arr[right];
        }

        //等量划分成 2 个区域
        int middle = (right - left) / 2 + left;
        int max_left = get_max(arr, left, middle);
        int max_right = get_max(arr, middle + 1, right);

        if (max_left >= max_right) {
            return max_left;
        } else {
            return max_right;
        }

    }
}
