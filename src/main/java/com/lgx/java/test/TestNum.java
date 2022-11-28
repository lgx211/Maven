package com.lgx.java.test;

public class TestNum {

    public static void main(String[] args) {
        String a = "09:78";
        String b = "09.78";
        String c = "9";
        System.out.println(a.matches("^[0.0-9.0]+$"));
        System.out.println(b.matches("^[0.0-9.0]+$"));
        System.out.println(c.matches("^[0.0-9.0]+$"));
    }
}
