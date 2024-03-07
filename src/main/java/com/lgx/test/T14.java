package com.lgx.test;

public class T14 {

    public static void main(String[] args) {

        try {
            System.out.println("111");
            return;
        } catch (Exception e) {
            System.out.println("222");
        } finally {
            System.out.println("333");
        }

    }
}
