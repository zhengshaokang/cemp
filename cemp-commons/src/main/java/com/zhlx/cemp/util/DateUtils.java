package com.zhlx.cemp.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

/**
 * 作用：日期/时间工具
 */
public class DateUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 作用：格式化
     * 
     * @param date
     * @param format
     * @return
     * @return String
     * @author winter
     * @date 2016年10月28日
     *
     */
    public static String format(Date date, String format) {
        if (date == null || format == null) {
            return null;
        }
        return FastDateFormat.getInstance(format).format(date);
    }

    /**
     * 作用：解析
     * 
     * @param date
     * @param format
     * @return
     * @return Date
     * @author winter
     * @date 2016年10月28日
     *
     */
    public static Date parse(String date, String format) {
        if (date == null || format == null) {
            return null;
        }
        try {
            return FastDateFormat.getInstance(format).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(new StringBuilder().append("用格式[").append(format).append("]解析日期/时间[")
                    .append(date).append("失败").toString(), e);
        }
    }

    /**
     * 作用：获取开始时间，0时0分0秒
     * 
     * @param date
     * @return
     * @return Date
     * @author winter
     * @date 2016年10月28日
     *
     */
    public static Date getDatetimeStart(Date date) {
        return setTime(date, 0, 0, 0, 0);
    }

    /**
     * 作用：获取结束时间，23时59分59秒
     * 
     * @param date
     * @return
     * @return Date
     * @author winter
     * @date 2016年10月28日
     *
     */
    public static Date getDatetimeEnd(Date date) {
        return setTime(date, 23, 59, 59, 999);
    }

    /**
     * 作用：设置时分秒毫秒
     * 
     * @param date
     * @param hour
     * @param minute
     * @param second
     * @param milliSecond
     * @return
     * @return Date
     * @author winter
     * @date 2016年10月28日
     *
     */
    public static Date setTime(Date date, Integer hour, Integer minute, Integer second, Integer milliSecond) {
        if (date == null || hour == null || minute == null || second == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, milliSecond);
        return calendar.getTime();
    }
    
}
