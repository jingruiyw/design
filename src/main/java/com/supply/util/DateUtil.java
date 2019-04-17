package com.supply.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static int getCurrentTime() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static String formatDate(Long time) {

        Date date = new Date(time);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
