package com.lgx.java.stream;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class T1 {

    public static void main(String[] args) {

        UserPojo u1 = new UserPojo();
        u1.setId(1);
        u1.setName("lgx");
        u1.setAge("18");
        UserPojo u2 = new UserPojo();
        u2.setId(2);
        u2.setName("qwe");
        u2.setAge("20");
        UserPojo u3 = new UserPojo();
        u3.setId(3);
        u3.setName("lgx");
        u3.setAge("28");
        UserPojo u4 = new UserPojo();
        u4.setId(4);
        u4.setName("ert");
        u4.setAge("20");

        List<UserPojo> userPojoList = new ArrayList<>();
        userPojoList.add(u1);
        userPojoList.add(u2);
        userPojoList.add(u3);
        userPojoList.add(u4);

        System.out.println(userPojoList);

        t1(userPojoList);
        t2(userPojoList);
        t3(userPojoList);



    }

    public static void t1(List<UserPojo> userPojoList){

        List<UserEntity> userEntityList = userPojoList.stream()
                .filter(v -> v.getName().equals("lgx"))
                .map(UserPojo::convertTo)
                .collect(Collectors.toList());

        System.out.println(111);
        System.out.println(userEntityList);

    }

    public static void t2(List<UserPojo> userPojoList){

        List<UserPojo> userPojoList1 = userPojoList.stream()
                .filter(v -> v.getName().equals("ert"))
                .collect(Collectors.toList());

        System.out.println(222);
        System.out.println(userPojoList1);

    }

    public static void t3(List<UserPojo> userPojoList){

        List<UserEntity> userEntityList = userPojoList.stream()
                .filter(v -> StringUtils.isEmpty(v.getAge()) || v.getAge().equals("20"))
                .map(UserPojo::convertTo)
                .collect(Collectors.toList());

        System.out.println(333);
        System.out.println(userEntityList);

    }

    public static void t4(List<UserPojo> userPojoList){

        List<Long> ids = new ArrayList<>();

        List<UserEntity> userEntityList = userPojoList.stream()
                .filter(v -> v.getName().equals("lgx"))
                .map(UserPojo::convertTo)
                .peek(v -> {
                    List<Long> longs = new ArrayList<>();
                    longs.addAll(ids);
                })
                .collect(Collectors.toList());

        System.out.println(444);
        System.out.println(userEntityList);

    }




}
