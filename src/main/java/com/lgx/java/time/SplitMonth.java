package com.lgx.java.time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SplitMonth {
    public static void main(String[] args) {
        // 1.开始时间 2017-02-03 13:16:04
        Long startTime = 1640966400000L;
        // 2.结束时间 2019-07-03 13:16:05
        Long endTime = 1667232000000L;
        // 3.开始时间段区间集合
        List<Long> beginDateList = new ArrayList<Long>();
        // 4.结束时间段区间集合
        List<Long> endDateList = new ArrayList<Long>();

        getIntervalTimeByMonth(startTime, endTime, beginDateList, endDateList);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(beginDateList);
        System.out.println(endDateList);

        for (int i = 0; i < beginDateList.size(); i++) {
            Long beginStr = beginDateList.get(i);
            Long endStr = endDateList.get(i);
            String begin1 = sdf.format(new Date(beginStr));
            String end1 = sdf.format(new Date(endStr));
            System.out.println("第" + i + "段时间区间:" + begin1 + "-------" + end1);
        }
    }


    /**
     * 按照月份分割一段时间
     *
     * @param startTime     开始时间戳(毫秒)
     * @param endTime       结束时间戳(毫秒)
     * @param beginDateList 开始段时间戳 和 结束段时间戳 一一对应
     * @param endDateList   结束段时间戳 和 开始段时间戳 一一对应
     */
    public static void getIntervalTimeByMonth(Long startTime, Long endTime, List<Long> beginDateList, List<Long> endDateList) {

        /*if (startTime.equals(endTime)) {
            beginDateList.add(startTime);
            endDateList.add(endTime);
            return;
        }*/

        Date startDate = new Date(startTime);
        Date endDate = new Date(endTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        beginDateList.add(calendar.getTimeInMillis());
        while (calendar.getTimeInMillis() <= endDate.getTime()) {
//            calendar.add(Calendar.MONTH, 2);
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.DATE, -1);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            if(calendar.getTimeInMillis() < endDate.getTime()){
                endDateList.add(calendar.getTimeInMillis());
            } else {
                endDateList.add(endDate.getTime());
                break;
            }
            calendar.add(Calendar.DATE, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            beginDateList.add(calendar.getTimeInMillis());
        }
    }
}
