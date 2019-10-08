package com.jc.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Today {
    public static Integer getMonthInfo() {
        Calendar calendar = Calendar.getInstance();
        int workDays = 0;
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        try {
            calendar.set(Calendar.DATE, 1);//从每月1号开始
            for (int i = 0; i < days; i++) {
                int day = calendar.get(Calendar.DAY_OF_WEEK);
                if (!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)) {
                    workDays++;
                }
                calendar.add(Calendar.DATE, 1);
            }
            return workDays;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workDays;
    }
    public static Integer getHour(String start,String end){
        long hour = 0;
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date s1 = dfs.parse(start);
            Date s2 = dfs.parse(end);
            long between = s2.getTime() - s1.getTime();
            hour = between/1000/3600;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Math.toIntExact(hour);
    }
    public static int getWorkDays(String strStartDate, String strEndDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cl1 = Calendar.getInstance();
        Calendar cl2 = Calendar.getInstance();

        try {
            cl1.setTime(df.parse(strStartDate));
            cl2.setTime(df.parse(strEndDate));

        } catch (ParseException e) {
            System.out.println("日期格式非法");
            e.printStackTrace();
        }

        int count = 0;
        while (cl1.compareTo(cl2) <= 0) {
            if (cl1.get(Calendar.DAY_OF_WEEK) != 7 && cl1.get(Calendar.DAY_OF_WEEK) != 1)
                count++;
            cl1.add(Calendar.DAY_OF_MONTH, 1);
        }
        return count;

    }
    public static String getFirstDay() {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return myFormatter.format(cal.getTime());
    }
    public static String getLastDay() {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        //主要就是这个roll方法
        cal.roll(Calendar.DATE, -1);
        return myFormatter.format(cal.getTime());
    }
    public static String times(Integer hour,Integer minute){
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.add(Calendar.DAY_OF_YEAR, 0);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return df.format(calendar.getTime());
    }
    public static String getDay(){
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        calendar.add(Calendar.DAY_OF_YEAR, 0);
        return df.format(calendar.getTime());
    }
}
