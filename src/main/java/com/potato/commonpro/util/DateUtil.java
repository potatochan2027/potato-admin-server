package com.potato.commonpro.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 获取当前时间 N个小时后的Date对象
     * @param n
     * @return
     */
    public static Date getDateAfterNHour(int n){
        Date date=new Date(); //获取当前时间Date

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY,n);
        return calendar.getTime();
    }

}
