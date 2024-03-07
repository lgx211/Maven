package com.lgx.test;

import java.util.ArrayList;
import java.util.List;

public class T10 {

    public static void main(String[] args) {

        try {
            System.out.println("try");

            List list = new ArrayList();
            list.get(0);

            return;

        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            System.out.println("finally");
        }

    }
}
