package com.nyeong.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Title:  DataUtil
 * Description: 日期格式的转换工具
 *
 * @date: 2017/9/9 下午3:01
 * @author: quinn_norris
 * @version: 1.0
 */
public class DateUtil {

    private static final String lineType = "yyyy-MM-dd HH-mm-ss";
    private static final String normalType = "yyyy-MM-dd HH:mm:ss";
    private static final String continueType = "yyyyMMddHHmmss";
    private static final String simpleType = "yyyyMMdd";
    private static final String simpleTimeType = "HHmmss";
    private static final String CalendarDayType = "MM dd yyyy";
    private static final String CalendarTimeType = "HH:mm:ss";
    private static final String proshowType = "yyyy-MM-dd";
    private static final String monthdayType = "MM-dd";

    public static String lineDateFormat(Date date) throws ParseException {
        return new SimpleDateFormat(lineType).format(date);
    }

    public static String normalDateFormat(Date date) throws ParseException {
        return new SimpleDateFormat(normalType).format(date);
    }

    public static String continueDateFormat(Date date) throws ParseException {
        return new SimpleDateFormat(continueType).format(date);
    }

    public static String simpleDateFormat(Date date) throws ParseException {
        return new SimpleDateFormat(simpleType).format(date);
    }

    public static String monthdayDateFormat(Date date) throws ParseException {
        return new SimpleDateFormat(monthdayType).format(date);
    }

    public static String simpleTimeDateFormat(Date date) throws ParseException {
        return new SimpleDateFormat(simpleTimeType).format(date);
    }

    public static String proshowDateFormat(Date date) throws ParseException {
        return new SimpleDateFormat(proshowType).format(date);
    }

    public static Date proshowStringFormat(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(proshowType);
        return sdf.parse(date);
    }

    public static String simpleDateFormat(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(CalendarDayType);
        Date dates = sdf.parse(date);
        return new SimpleDateFormat(simpleType).format(dates);
    }

    public static Date simpleStringFormat(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(simpleType);
        return sdf.parse(date);
    }

    public static Date simpleTimeStringFormat(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(simpleTimeType);
        return sdf.parse(date);
    }

    public static String simpleDateTimeFormat(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(CalendarTimeType);
        Date dates = sdf.parse(date);
        return new SimpleDateFormat(simpleTimeType).format(dates);
    }

}
