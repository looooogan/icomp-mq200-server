package com.icomp.common.utils;

import com.icomp.common.constant.IConstant;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间格式转化工具
 *
 * @author TYY
 * @className DateFormatUtil
 * @date 2015年10月12日14:15:02
 */
public class DateFormatUtil {
    public static String DATE_FORMA = "yyyy-MM-dd";
    public static String TIME_FORMA = "yyyy-MM-dd HH:mm:ss";
    public static String TIME_HOUR_FORMA = "yyyy-MM-dd HH:mm";
    public static String DATE_FORMA_XIE = "yyyy/MM/dd";
    public static String DATE_FORMA_CHAINESE = "yyyy年MM月dd日";
    public static String TIME_FORMA_CHAINESE = "yyyy年MM月dd日 HH:mm:ss";
    public static String YEAR_MONTH_FORMA = "yyyy-MM";
    public static String YEAR_MONTH_DAY = "yyyyMMdd";

    /**
     * 把日期转为字符串
     *
     * @param date
     * @param type (0-"yyyy-MM-dd" ,
     *             1-"yyyy-MM-dd HH:mm:ss",
     *             2-"yyyy/MM/dd",
     *             3-"yyyy年MM月dd日",
     *             4- "yyyy年MM月dd日 HH:mm:ss"
     *             5- "yyyy-MM-dd HH:mm")
     *             6- "yyyyMMdd")
     * @return
     */
    public static String dateToString(Date date, int type) {
        DateFormat df = null;
        if (date == null) {
            return "";
        }
        try {
            if (type == 0) {
                df = new SimpleDateFormat(DATE_FORMA);
            } else if (type == 1) {
                df = new SimpleDateFormat(TIME_FORMA);
            } else if (type == 2) {
                df = new SimpleDateFormat(DATE_FORMA_XIE);
            } else if (type == 3) {
                df = new SimpleDateFormat(DATE_FORMA_CHAINESE);
            } else if (type == 4) {
                df = new SimpleDateFormat(TIME_FORMA_CHAINESE);
            } else if (type == 5) {
                df = new SimpleDateFormat(TIME_HOUR_FORMA);
            } else if (type == 6){
                df = new SimpleDateFormat(YEAR_MONTH_DAY);
            } else {
                df = new SimpleDateFormat(YEAR_MONTH_FORMA);
            }
        } catch (Throwable e) {
            System.out.printf("dateToString--" + e.toString());
            return "";
        }
        return df.format(date);
    }

    /**
     * 把字符串转为日期
     *
     * @param strDate
     * @param type    (0-"yyyy-MM-dd" ,
     *                1-"yyyy-MM-dd HH:mm:ss",
     *                2-"yyyy/MM/dd",
     *                3-"yyyy年MM月dd日",
     *                4- "yyyy年MM月dd日 HH:mm:ss"
     *                5- "yyyy-MM-dd HH:mm")
     * @return
     * @throws Exception
     */
    public static Date converToDate(String strDate, int type) {
        Date date = null;
        DateFormat df = new SimpleDateFormat(TIME_FORMA);
        try {
            if (type == 0) {
                df = new SimpleDateFormat(DATE_FORMA);
            } else if (type == 1) {
                df = new SimpleDateFormat(TIME_FORMA);
            } else if (type == 2) {
                df = new SimpleDateFormat(DATE_FORMA_XIE);
            } else if (type == 3) {
                df = new SimpleDateFormat(DATE_FORMA_CHAINESE);
            } else if (type == 4) {
                df = new SimpleDateFormat(TIME_FORMA_CHAINESE);
            } else if (type == 5) {
                df = new SimpleDateFormat(TIME_HOUR_FORMA);
            } else {
                df = new SimpleDateFormat(YEAR_MONTH_FORMA);
            }
            date = df.parse(strDate);

        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
        return date;
    }

    /**
     * 实现将初始日期时间2012年07月02日 16:45 拆分成年 月 日 时 分 秒,并赋值给calendar
     *
     * @param initDateTime 初始日期时间值 字符串型
     * @return Calendar
     */
    private Calendar getCalendarByInintData(String initDateTime) {
        Calendar calendar = Calendar.getInstance();

        // 将初始日期时间2012年07月02日 16:45 拆分成年 月 日 时 分 秒
        String date = spliteString(initDateTime, "日", "index", "front"); // 日期
        String time = spliteString(initDateTime, "日", "index", "back"); // 时间

        String yearStr = spliteString(date, "年", "index", "front"); // 年份
        String monthAndDay = spliteString(date, "年", "index", "back"); // 月日

        String monthStr = spliteString(monthAndDay, "月", "index", "front"); // 月
        String dayStr = spliteString(monthAndDay, "月", "index", "back"); // 日

        String hourStr = spliteString(time, ":", "index", "front"); // 时
        String minuteStr = spliteString(time, ":", "index", "back"); // 分

        int currentYear = Integer.valueOf(yearStr.trim()).intValue();
        int currentMonth = Integer.valueOf(monthStr.trim()).intValue() - 1;
        int currentDay = Integer.valueOf(dayStr.trim()).intValue();
        int currentHour = Integer.valueOf(hourStr.trim()).intValue();
        int currentMinute = Integer.valueOf(minuteStr.trim()).intValue();

        calendar.set(currentYear, currentMonth, currentDay, currentHour, currentMinute);
        return calendar;
    }

    /**
     * 年月日变成符号
     * 2015年09月13日变成2015-09-13
     *
     * @param initDateTime
     * @return
     */
    public static String getChainseChar(String initDateTime) {
        return initDateTime.replace("年", "-").replace("月", "-").replace("日", "");
    }

    /**
     * 2015-09-13变成2015年09月13日
     *
     * @param initDateTime
     * @return
     */
    public static String getChartoChainse(String initDateTime) {
        if (initDateTime == null || "".equals(initDateTime)) {
            return "";
        }
        String reVal = "";
        String[] string1 = initDateTime.split(" ");
        if (string1.length > 1) {
            String[] strings = string1[0].split("-");
            reVal = strings[0] + "年" + strings[1] + "月" + strings[2] + "日 " + string1[1];
        } else {
            String[] strings = initDateTime.split("-");
            reVal = strings[0] + "年" + strings[1] + "月" + strings[2] + "日";
        }
        return reVal;
    }

    /**
     * 截取子串
     *
     * @param srcStr      源串
     * @param pattern     匹配模式
     * @param indexOrLast
     * @param frontOrBack
     * @return
     */
    public static String spliteString(String srcStr, String pattern, String indexOrLast, String frontOrBack) {
        String result = "";
        int loc = -1;
        if (indexOrLast.equalsIgnoreCase("index")) {
            loc = srcStr.indexOf(pattern); // 取得字符串第一次出现的位置
        } else {
            loc = srcStr.lastIndexOf(pattern); // 最后一个匹配串的位置
        }
        if (frontOrBack.equalsIgnoreCase("front")) {
            if (loc != -1)
                result = srcStr.substring(0, loc); // 截取子串
        } else {
            if (loc != -1)
                result = srcStr.substring(loc + 1, srcStr.length()); // 截取子串
        }
        return result;
    }

    public static String getDayOfWeek(Date date) {
        //		根据日期获取星期
        String result = "'";
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int key = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        for (int i = 0; i < weekDays.length; i++) {
            if (key == i) {
                result = weekDays[i];
            }
        }
        return result;
    }

    /**
     * 如果是当前月的最后一星期刚返回Ture;
     * 否则返回 false.
     *
     * @return
     */
    public static Boolean findThisMonthLastWeek() {
        Calendar calendar = Calendar.getInstance();
        // 声明一个int变量year
        int year = calendar.get(Calendar.YEAR);

        //声明一个int变量month
        int month = calendar.get(Calendar.MONTH) + 1;

        // 获取几号
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day >= 24) {
                return true;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day >= 23) {
                return true;
            }
        } else if (year % 4 == 0) { //闰年
            if (day >= 22) {
                return true;
            }
        } else {
            if (day >= 21) {
                return true;
            }
        }
        return false;
    }

    /**
     * 取出当前时间的前后几天
     * 正数 今天之后
     * 负数 今天之前
     * 0为今天
     *
     * @param day
     * @return
     */
    public static String getThisDateAddParamNum(int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, day);
        // 月
        int month = c.get(Calendar.MONTH) + 1;
        String monString = null;
        if (month < 10) {
            monString = "0"+ month;
        } else {
            monString = month + "";
        }

        // 日
        int date = c.get(Calendar.DATE);
        String dateString = null;
        if (date < 10) {
            dateString = IConstant.STRING_0 + date;
        } else {
            dateString = "" + date;
        }
        // 取出明天时间
        String paramtorDate = c.get(Calendar.YEAR) + "-" + monString + "-" + dateString;
        return paramtorDate;
    }

    /**
     * 获取某一个时间的时间戳
     * dates yyyy-MM-dd
     *
     * @param dates
     * @return
     */
    public static long getXtimes(String dates) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(dates);
        } catch (Exception e) {
            date = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getTimeInMillis();
    }

    /**
     * 查询年月
     *
     * @param years 年   month月份
     * @return 当前年-月份
     */
    public static String getYearsMonth(String years, String workDate) {
        String monthString = null;
        Calendar c = Calendar.getInstance();
        int month = 0;
        if (StringUtils.isEmpty(workDate)) {
            month = c.get(Calendar.MONTH) + 1;
            if (month < 10) {
                monthString = "0" + month;
            } else {
                monthString = "" + month;
            }
        } else {

            int workDateINT = Integer.parseInt(workDate);
            if (workDateINT < 10) {
                monthString = "0" + workDateINT;
            } else {
                monthString = "" + workDateINT;
            }
        }
        // 年
        int year = 0;
        String yearString = "0";
        if (StringUtils.isEmpty(years)) {
            //当前年
            year = c.get(Calendar.YEAR);
            yearString = "" + year;
        } else {
            yearString = years;
        }
        // 查询年月
        return yearString + "-" + monthString;
    }

    /**
     * 获取当前时间(精确到毫秒)的时间戳
     *
     * @param 
     * @return t
     */
    public static long getTimes(){
    	Date date = new Date();
		Long t = date.getTime();
        return t;
    }
}
