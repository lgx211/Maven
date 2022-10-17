package com.lgx.java.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timestamp {
    public static void main(String[] args) {
        Long timeStamp = 1664553600000L;  //获取当前时间戳

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));      // 时间戳转换成时间
        System.out.println("格式化结果：" + sd);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
        String sd2 = sdf2.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        System.out.println("格式化结果：" + sd2);

        SimpleDateFormat sdf3 = new SimpleDateFormat("MM月dd日");
        String sd3 = sdf3.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        System.out.println("格式化结果：" + sd3);

        SimpleDateFormat sdf4= new SimpleDateFormat("YYYY-MM-dd EE HH:mm:ss");
        String sd4 = sdf4.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        System.out.println("格式化结果：" + sd4);

    }
}
