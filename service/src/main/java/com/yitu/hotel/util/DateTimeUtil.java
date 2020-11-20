package com.yitu.hotel.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * 时间处理工具类V1.0
 */
public final class DateTimeUtil {

    /**
     * 将时间对象转成字符串
     *
     * @param date    时间
     * @param pattern 格式
     * @return java.lang.String 格式化后的时间串
     * @author zouhao 2018/10/23 16:02
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * 将时间戳转为时间字符串
     *
     * @param millis  毫秒值
     * @param pattern 格式
     * @return java.lang.String 格式化后的时间串
     * @author zouhao 2018/10/23 16:03
     */
    public static String millis2String(long millis, String pattern) {
        return format(new Date(millis), pattern);
    }

    /**
     * 将字符串转化为时间对象
     *
     * @param dateStr 时间字符串
     * @param pattern 格式
     * @return java.utils.Date 转化后的时间对象
     * @author zouhao 2018/10/23 16:03
     */
    public static Date parse(String dateStr, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        if (StringUtils.isEmpty(dateStr)) {
            return date;
        }
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将字符串转换为日期
     *
     * @param dateStr
     * @return java.lang.String
     * @author zouhao
     * @date 2020/11/20 15:48
     */
    public static LocalDate parseLocalDate(String dateStr, DateTimeFormatter dateTimeFormatter) {
        LocalDate localDate = null;
        if (StringUtils.isBlank(dateStr)) {
            return localDate;
        }
        try {
            localDate = LocalDate.parse(dateStr, dateTimeFormatter);
        } catch (DateTimeParseException ex) {
            throw ex;
        }
        return localDate;
    }

    /**
     * 将时间字符串转为时间戳
     *
     * @param dateStr 时间字符串
     * @param pattern 格式
     * @return long 时间戳
     * @author zouhao 2018/10/23 16:05
     */
    public static long string2Millis(String dateStr, String pattern) {
        Date d = parse(dateStr, pattern);
        return d != null ? d.getTime() : 0;
    }

    /**
     * 获取两个时间差（毫秒）
     *
     * @param date1 时间1
     * @param date2 时间2
     * @return long 时间差（毫秒）
     * @author zouhao 2018/10/23 16:08
     */
    public static long getTimeSpan(Date date1, Date date2) {
        return date1.getTime() - date2.getTime();
    }

    /**
     * 计算某个时间距离当前时间的天数、小时数以及分钟数(如：1天2小时3分钟前).
     *
     * @param date 时间
     * @return java.lang.String 距离描述
     * @author zouhao 2018/10/23 17:04
     */
    public static String distanceTime(Date date) {
        if (date == null) {
            return "";
        }
        StringBuilder tips = new StringBuilder();
        Date now = new Date();
        long timestamp = date.getTime() - now.getTime();
        String beforeOrAfter = timestamp > 0 ? "后" : "前";
        timestamp = Math.abs(timestamp);
        long days = (timestamp / (1000 * 60 * 60 * 24));
        if (days > 0) {
            tips.append(days).append("天");
        }
        long hours = (timestamp / (1000 * 60 * 60) - days * 24);
        if (hours > 0 || (days > 0 && hours == 0)) {
            tips.append(hours).append("小时");
        }
        long minutes = (timestamp / (1000 * 60)) - days * 24 * 60 - hours * 60;
        return tips.append(minutes).append("分钟").append(beforeOrAfter).toString();
    }

    /**
     * 计算某个时间到当前时间的距离(如：1年前、1个月前、1天前、1小时前、1分钟前、刚刚)
     *
     * @param date 时间
     * @return java.lang.String 距离描述
     * @author zouhao 2018/10/23 16:35
     */
    public static String distanceFromNow(Date date) {
        StringBuilder tips = new StringBuilder();
        Date now = new Date();
        long timestamp = date.getTime() - now.getTime();
        String beforeOrAfter = timestamp > 0 ? "后" : "前";
        timestamp = Math.abs(timestamp);
        int year = (int) (timestamp / (1000 * 60 * 60 * 24) / 365);
        if (year > 0) {
            tips.append(year).append("年").append(beforeOrAfter);
            return tips.toString();
        }
        int month = (int) (timestamp / (1000 * 60 * 60 * 24) / 30);
        if (month > 0) {
            tips.append(month).append("个月").append(beforeOrAfter);
            return tips.toString();
        }
        int days = (int) (timestamp / (1000 * 60 * 60 * 24));
        if (days > 0) {
            tips.append(days).append("天").append(beforeOrAfter);
            return tips.toString();
        }
        int hours = (int) (timestamp / (1000 * 60 * 60));
        if (hours > 0) {
            tips.append(hours).append("小时").append(beforeOrAfter);
            return tips.toString();
        }
        int minutes = (int) (timestamp / (1000 * 60));
        if (minutes > 0) {
            tips.append(minutes).append("分钟").append(beforeOrAfter);
            return tips.toString();
        }
        return "刚刚";
    }

    /**
     * 将时间戳换成中文描述
     *
     * @param
     * @return
     * @author zouhao 2019/01/12 17:10
     */
    public static String timeStampDesc(long timeStamp) {
        timeStamp = Math.abs(timeStamp);
        StringBuilder tips = new StringBuilder("");
        long days = (timeStamp / (1000 * 60 * 60 * 24));
        if (days > 0) {
            tips.append(days).append("天");
        }
        long hours = (timeStamp / (1000 * 60 * 60) - days * 24);
        if (hours > 0) {
            tips.append(hours).append("小时");
        }
        long minutes = (timeStamp / (1000 * 60)) - days * 24 * 60 - hours * 60;
        if (minutes > 0) {
            tips.append(minutes).append("分钟");
        }
        long seconds = (timeStamp / 1000) - days * 24 * 60 * 60 - hours * 60 * 60 - minutes * 60;
        return tips.append(seconds).append("秒").toString();
    }

    /**
     * @param
     * @return
     * @desc: 格式化星期几
     * @author yanhua
     * @date 2019/4/28
     */
    public static String formatWeekName(int week) {
        switch (week) {
            case Calendar.MONDAY:
                return "周一";
            case Calendar.TUESDAY:
                return "周二";
            case Calendar.WEDNESDAY:
                return "周三";
            case Calendar.THURSDAY:
                return "周四";
            case Calendar.FRIDAY:
                return "周五";
            case Calendar.SATURDAY:
                return "周六";
            case Calendar.SUNDAY:
                return "周日";
        }
        return "";
    }


    /**
     * @param
     * @return
     * @Description: 获取当前日期的星期一日期
     * @author ouyang
     * @date 2019/4/29
     */
    public static Date getCurrentMonday() {
        Date now = new Date();
        final Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        Date monday = null; //周一
        int diffMon = week - Calendar.MONDAY;
        if (diffMon >= 0) {
            monday = DateUtils.addDays(now, -diffMon);
        } else {
            monday = DateUtils.addDays(now, -6);
        }

        return monday;
    }

    /**
     * @param
     * @return
     * @desc: 获取时间的"上午"\"下午"文字
     * @author yanhua
     * @date 2019/4/29
     */
    public static String getAmPmStr(Date time) {
        if (time == null) {
            return "";
        }
        long hour = DateUtils.getFragmentInHours(time, Calendar.DATE);
        if (hour > 12) {
            return "下午";
        }
        return "上午";
    }


    /**
     * 功能描述: 一天之内显示几分钟、几小时前，超过一天显示年月日
     *
     * @Author: J.K
     * @Date: 2019/11/5 15:54
     */
    public static String distanceTimeLimitOneDay(Date date) {
        if (date == null) {
            return "";
        }
        StringBuilder tips = new StringBuilder();
        Date now = new Date();
        long timestamp = date.getTime() - now.getTime();
        String beforeOrAfter = timestamp > 0 ? "后" : "前";
        timestamp = Math.abs(timestamp);
        long days = (timestamp / (1000 * 60 * 60 * 24));
        if (days > 0) {
            return tips.append(format(date, "yyyy-MM-dd")).toString();
        }
        long hours = (timestamp / (1000 * 60 * 60) - days * 24);
        if (hours > 0 || (days > 0 && hours == 0)) {
            tips.append(hours).append("小时");
        }
        long minutes = (timestamp / (1000 * 60)) - days * 24 * 60 - hours * 60;
        return tips.append(minutes).append("分钟").append(beforeOrAfter).toString();
    }

    /**
     * 校验时间有效性
     * <pre>
     *
     *                   startDate 2019-01-11
     *                   endDate 2019-01-10
     *                   month 6
     *                   return false
     *
     *                   startDate 2019-01-11
     *                   endDate 2019-07-11
     *                   month 6
     *                   return true
     *
     *                   startDate 2019-01-11
     *                   endDate 2019-04-11
     *                   month 6
     *                   return true
     *
     *                   startDate 2019-01-11
     *                   endDate 2019-07-12
     *                   month 6
     *                   return false
     *
     * </pre>
     *
     * @param startDate 2019-01-11
     * @param endDate   2019-06-02
     * @param month     6 校验时长 单位月
     * @return boolean true 在时间范围内 , false 不在时间范围内
     * @author zouhao
     * @date 2019-12-10 17:46:24
     */
    public static boolean verifyValidDateScopeByMonth(Date startDate, Date endDate, int month) {
        long x = endDate.getTime() - startDate.getTime();
        if (x <= 0) {
            return false;
        }
        Calendar c1 = Calendar.getInstance();
        c1.setTime(startDate);//2019-01-11
        c1.add(Calendar.MONTH, month); // 6
        Date eTime = c1.getTime();// 6个月后的时间 2019-07-01
        long t = eTime.getTime() - endDate.getTime(); // 2019-07-01 - 2019-06-02
        return t >= 0;
    }


    /**
     * 2019年08月09日 2017-08-28 转换为Date能保存到数据库中
     *
     * @param dateStr
     * @return java.util.Date
     * @author zouhoa
     * @date 2020/7/10 10:23
     */
    public static Date convertJzsgDate(String dateStr) {
        Date pT = parse(dateStr, "yyyy-YY-dd");
        if (pT != null) {
            return pT;
        }
        return parse(dateStr, "yyyy年-YY月-dd日");
    }

    /**
     * 计算两个日期相差几个月
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthSpace(Date date1, Date date2) {
        int result = 0;
        Calendar cal1 = new GregorianCalendar();
        cal1.setTime(date1);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(date2);
        result = (cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR)) * 12 + cal1.get(Calendar.MONTH) - cal2.get(Calendar.MONTH);
        return result == 0 ? 1 : Math.abs(result);
    }

    /**
     * 判断两个日期是否是同一天
     *
     * @param date1
     * @param date2
     * @return boolean
     * @author zouhoa
     * @date 2020/10/16 11:27
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        }
        return false;
    }

    /**
     * 判断两个时间 时分值得大小
     *
     * @param startStr
     * @param endStr
     * @return boolean 返回
     * @author zouhoa
     * @date 2020/10/23 14:48
     */
    public static boolean compareTimeHHmm(String startStr, String endStr) {
        try {
            if (startStr.indexOf(":") < 0 || endStr.indexOf(":") < 0) {
                return false;
            } else {
                String[] array1 = startStr.split(":");
                int total1 = Integer.valueOf(array1[0]) * 3600 + Integer.valueOf(array1[1]) * 60;
                if (array1.length > 2) {
                    total1 += Integer.valueOf(array1[2]);
                }
                String[] array2 = endStr.split(":");
                int total2 = Integer.valueOf(array2[0]) * 3600 + Integer.valueOf(array2[1]) * 60;
                if (array2.length > 2) {
                    total2 += Integer.valueOf(array2[2]);
                }
                return total2 - total1 > 0 ? true : false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断是否是周末
     *
     * @param calendar
     * @return boolean
     * @author zouhoa
     * @date 2020/11/9 16:33
     */
    private static boolean isWeekend(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return (dayOfWeek == 1 || dayOfWeek == 7) ? true : false;
    }

    /**
     * 是否节假日 Bw_Hols 这个表 ON_DUTY F标识不用上班的 T标识要要上班的
     *
     * @param calendar
     * @param holidayList 节假日配置数组
     * @return boolean
     * @author zouhoa
     * @date 2020/11/9 16:35
     */
    private static boolean isHoliday(Calendar calendar, List holidayList) {
        if (holidayList == null) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(calendar.getTime());
        return holidayList.contains(dateStr) ? true : false;
    }

    /**
     * 是否是补班的日子
     *
     * @param calendar
     * @param bbDayList
     * @return boolean
     * @author zouhoa
     * @date 2020/11/17 15:12
     */
    private static boolean isBbDay(Calendar calendar, List bbDayList) {
        if (bbDayList == null) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(calendar.getTime());
        return bbDayList.contains(dateStr) ? true : false;
    }

    /**
     * 将字符串转换为日期
     *
     * @param dateStr
     * @return java.lang.String
     * @author zouhao
     * @date 2020/11/20 15:48
     */
    private static LocalDate parse(String dateStr, DateTimeFormatter dateTimeFormatter) {
        LocalDate localDate = null;
        if (StringUtils.isBlank(dateStr)) {
            return localDate;
        }
        try {
            localDate = LocalDate.parse(dateStr, dateTimeFormatter);
        } catch (DateTimeParseException ex) {
            throw ex;
        }
        return localDate;
    }

}
