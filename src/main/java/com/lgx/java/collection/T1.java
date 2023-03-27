package com.lgx.java.collection;

import java.util.ArrayList;
import java.util.List;

public class T1 {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        User user = new User();
        People people = new People();
        people.setCcc("ccc");
        user.setAaa("aaa");
        user.setBbb("bbb");
        user.setPeople(people);
        users.add(user);

        User user2 = new User();
        People people2 = new People();
        people2.setCcc("ccc2");
        user2.setAaa("aaa2");
        user2.setBbb("bbb2");
        user2.setPeople(people2);
        users.add(user2);

        System.out.println(users);
        for (User user1 : users) {
            if (user1.getPeople().getCcc().equals("ccc")) {
                user1.setAaa("111");
            }
        }
        System.out.println(users);

        System.out.println("========");
        System.out.println("SPECIAL".contains("SPECIAL"));
        System.out.println("SPECIAL2".contains("SPECIAL"));
        System.out.println("SPECIAL".contains("SPECIAL2"));
        System.out.println("".contains("SPECIAL2"));

    }
}
