package com.lgx.java.test;

import org.springframework.stereotype.Service;

@Service
public class Test2 {

    private static String aaa;

    public Test2() {
        Test2.aaa = "111";
    }

    public static String read(){
        System.out.println(aaa);
        return "OK";
    }
}
