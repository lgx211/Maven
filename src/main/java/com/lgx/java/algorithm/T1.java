package com.lgx.java.algorithm;

public class T1 {

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(s.substring(0, 0));
        System.out.println(s.substring(0, 1));
        System.out.println(s.substring(1, 3));

        System.out.println(1 / 2);
        System.out.println(2 / 2);
        System.out.println(3 / 2);

        int arr[][] = {{1, 2}, {3, 4, 5}, {6, 7}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
