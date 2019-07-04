package com.qwer.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    public static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SimpleDateFormat fmt1 = new SimpleDateFormat("yyyyMMddHHmmss");

    // 加减秒
    public static Date setSecond(Date date, int i) throws Exception {
        return addOrMinus(date,Calendar.SECOND,i);
    }


    public static Date addOrMinus(Date date,int filed, int i) throws  Exception{
        Date rtn = null;
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(filed,i);
        rtn = cal.getTime();
        return rtn;
    }
}
