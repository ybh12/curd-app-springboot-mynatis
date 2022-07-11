package com.travel.form.utils.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * @author by 李泽阳 2021/12/7 9:40
 * @description：日期格式解析类
 */
public class DateUtil {

    public final static String DATE_FORMAT3 = "yyyy-MM-dd-HH-mm";
    public final static String DATE_FORMAT6 = "yyyyMMddHHmmss";

    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_YMHA_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String DEFAULT_YMMV_FORMAT = "yyyy-MM-dd HH";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    public static final String DAY_TIME_BEGIN = " 00:00:00";

    public static final String DAY_TIME_END = " 23:59:59";
    /**
     * 获取当前时间戳
     * dateFormat==null 返回默认格式 yyyy-MM-dd-HH-mm
     *
     * @param dateFormat 时间格式
     * @return String
     */
    public static String nowTimestamp(String dateFormat) {
        if (null == dateFormat) {
            dateFormat = DATE_FORMAT3;
        }
        DateFormat df = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

    /**
     * LocalDateTime转String
     *
     * @param localDateTime 需要转换的时间
     * @param format        转换格式 ：格式在上final 定义
     * @return
     */
    public static String parseLocalDateTime(LocalDateTime localDateTime, String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        if (null != localDateTime) {
            return df.format(localDateTime);
        } else {
            return df.format(LocalDateTime.now());
        }
    }

    /**
     * String转LocalDateTime
     *
     * @param stringTime 需要转换字符串
     * @param format     转换格式 ：格式在上final 定义
     * @return
     */
    public static LocalDateTime parseStringTime(String stringTime, String format) {
        if (null != stringTime && !"".equals(stringTime)) {
            return LocalDateTime.parse(stringTime, DateTimeFormatter.ofPattern(format));
        } else {
            return LocalDateTime.now();
        }
    }
}
