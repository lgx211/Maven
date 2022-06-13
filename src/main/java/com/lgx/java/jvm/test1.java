package com.lgx.java.jvm;

public class test1 {

    public static void main(String[] args) {
        int a = 10;
        new test1().aaa (a);
    }

    public void aaa(int a){
        int b = 10;
        Person p = new Person();
        p.id = 1;
        p.name = "lgx";
        System.out.println(a + b );
    }
}

class Person{
    int id;
    String name;
}
