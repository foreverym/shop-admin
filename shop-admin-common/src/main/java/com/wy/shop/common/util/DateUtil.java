package com.wy.shop.common.util;

import org.apache.commons.lang3.StringUtils;
import org.quartz.CronExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public final class DateUtil
{
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_LOGIC_TIMESTAMP = "yyyyMMddHHmmssSSS";
    public static final String DATE_FORMAT_LOGIC_TIMESTAMP_WITHOUT_MSEC = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_LOGIC_TIMESTAMP_WITHOUT_SEC = "yyyyMMddHHmm";
    public static final String DATE_FORMAT_LOGIC_TIMESTAMP_WITHOUT_MIN = "yyyyMMddHH";
    public static final String DATE_FORMAT_DDMMYYYYHHMMSS = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_FORMAT_DDMMYYYYHHMM = "dd/MM/yyyy HH:mm";
    public static final String DATE_FORMAT_DDMMYYYY = "dd/MM/yyyy";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT_MMDDYYYY = "MM/dd/yyyy";
    public static final String DATE_FORMAT_MMDDYYYYHHMMSS = "MM/dd/yyyy HH:mm:ss";
    public static final String DATE_FORMAT_TIME = "HHmmss";
    public static final String DATE_FORMAT_HHMMSS = "HH:mm:ss";
    public static final String DATE_FORMAT_HHMMSSA = "hh:mm:ss a";
    public static final String DATE_FORMAT_YYYYMMDD_HHMMSS = "yyyyMMdd HH:mm:ss";
    public static final String EBXML_DATE_FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String EXCEL_DATE_FORMAT_DDMMYY = "dd-MM-yyyy";
    public static final String DATE_FORMAT_YYYYMMDDHH = "yyyyMMddHH";
    public static final String EXCEL_DATE_FORMAT_YYYYMMDD = "yyyy/MM/dd";
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";
    public static final String DATE_FORMAT_YYYYMM_ = "yyyy-MM";
    public static final String FULLY_MONTH_MMMM = "MMMM";
    public static final String DATE_FORMATE_MMMDDYYYY = "MMM dd, yyyy";

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private static DateUtil instance;


    private DateUtil()
    {
    }


    public static DateUtil getInstance()
    {
        synchronized (DateUtil.class)
        {
            if (instance == null)
            {
                instance = new DateUtil();
            }
        }

        return instance;
    }


    public String convertDateToString(Date inDate)
    {
        if (inDate == null)
        {
            return "";
        }

        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.US);

        return df.format(inDate);
    }


    public String convertDateToString(Date inDate, String dateFormat)
    {
        String resultValue = "";
        if (null == inDate)
        {
            return resultValue;
        }

        try
        {
            SimpleDateFormat df = new SimpleDateFormat(dateFormat == null ? DEFAULT_DATE_FORMAT : dateFormat, Locale.US);
            resultValue = df.format(inDate);
        }
        catch (Exception e)
        {
            logger.error("convertDateToString failed [inDate :::: " + inDate + " && dateFormat :::: " + dateFormat
                    + "]", e.getCause());
        }

        return resultValue;
    }


    /**
     * 
     * 转换date为yyyyMMdd格式的字符串
     *
     * @author Sunyadong
     * @param %param inDate% %param 需要转换的date对象%
     * @return String
     */
    public String convertDateToCommString(Date inDate)
    {
        String resultValue = "";
        if (null == inDate)
        {
            return resultValue;
        }

        try
        {
            SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD, Locale.US);
            resultValue = df.format(inDate);
        }
        catch (Exception e)
        {
            logger.error("convertDateToString failed [inDate :::: " + inDate + " && dateFormat :::: "
                    + DATE_FORMAT_YYYYMMDD + "]", e.getCause());
        }

        return resultValue;
    }


    /**
     * 
     * 转换dateTime为yyyyMMddHHmmss格式的字符串
     *
     * @author Sunyadong
     * @param %param inDate% %param 需要转换的date对象%
     * @return String
     */
    public String convertDateTimeToCommString(Date inDate)
    {
        String resultValue = "";
        if (null == inDate)
        {
            return resultValue;
        }

        try
        {
            SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_LOGIC_TIMESTAMP_WITHOUT_MSEC, Locale.US);
            resultValue = df.format(inDate);
        }
        catch (Exception e)
        {
            logger.error("convertDateToString failed [inDate :::: " + inDate + " && dateFormat :::: "
                    + DATE_FORMAT_LOGIC_TIMESTAMP_WITHOUT_MSEC + "]", e.getCause());
        }

        return resultValue;
    }


    public String convertStringToString(String inDate, String sourceDateFormat, String targetDateFormat)
    {
        String resultValue = "";
        if (null == inDate)
        {
            return resultValue;
        }

        try
        {
            Date sourceDate = convertStringToDate(inDate, sourceDateFormat);
            resultValue = convertDateToString(sourceDate, targetDateFormat);
        }
        catch (Exception e)
        {
            logger.error("convertDateToString failed [inDate :::: " + inDate + " && sourceDateFormat :::: "
                    + sourceDateFormat + " & targetDateFormat :::: " + targetDateFormat + "]", e.getCause());
        }

        return resultValue;
    }


    public Date formatDate(Date dateStr, String format)
    {
        return convertStringToDate(convertDateToString(dateStr, format));
    }


    public Date convertStringToDate(String inDate, String format)
    {
        if (StringUtils.isEmpty(inDate))
        {
            return null;
        }

        SimpleDateFormat df;
        Date resultDate = null;

        try
        {
            df = new SimpleDateFormat(format == null ? DEFAULT_DATE_FORMAT : format, Locale.US);
            df.setLenient(false);
            resultDate = df.parse(inDate);
        }
        catch (Exception e)
        {
            logger.error("convertStringToDate failed [inDate :::: " + inDate + " && format :::: " + format,
                    e.getCause());

        }

        return resultDate;
    }


    /**
     * 
     * 转换yyyyMMdd格式的字符串为date
     *
     * @author Sunyadong
     * @param %param inDate% %param 需要转换的字符串%
     * @return Date
     */
    public Date convertCommStringToDate(String inDate)
    {
        if (StringUtils.isBlank(inDate))
        {
            return null;
        }

        SimpleDateFormat df;
        Date resultDate = null;

        try
        {
            df = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD, Locale.US);
            df.setLenient(false);
            resultDate = df.parse(inDate);
        }
        catch (Exception e)
        {
            logger.error("convertStringToDate failed [inDate :::: " + inDate + " && format :::: "
                    + DATE_FORMAT_YYYYMMDD, e.getCause());

        }

        return resultDate;
    }


    /**
     * 
     * 转换yyyyMMddHHmmss格式的字符串为date
     *
     * @author Sunyadong
     * @param %param inDate% %param 需要转换的字符串%
     * @return Date
     */
    public Date convertCommStringToDateTime(String inDate)
    {
        if (StringUtils.isBlank(inDate))
        {
            return null;
        }

        SimpleDateFormat df;
        Date resultDate = null;

        try
        {
            df = new SimpleDateFormat(DATE_FORMAT_LOGIC_TIMESTAMP_WITHOUT_MSEC, Locale.US);
            df.setLenient(false);
            resultDate = df.parse(inDate);
        }
        catch (Exception e)
        {
            logger.error("convertStringToDate failed [inDate :::: " + inDate + " && format :::: "
                    + DATE_FORMAT_YYYYMMDD, e.getCause());

        }

        return resultDate;
    }


    public Date convertStringToDate(String inDate)
    {
        if (StringUtils.isEmpty(inDate))
        {
            return null;
        }

        SimpleDateFormat df;
        Date resultDate = null;

        try
        {
            df = new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.US);
            df.setLenient(false);
            resultDate = df.parse(inDate);
        }
        catch (Exception e)
        {
            logger.error("convertStringToDate failed [inDate :::: " + inDate + " && dateFormat :::: "
                    + DEFAULT_DATE_FORMAT + "]", e.getCause());
        }

        return resultDate;
    }


    public int compareDate(Date inDate1, Date inDate2)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(inDate1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(inDate2);

        return calendar1.compareTo(calendar2);
    }


    public int compareDay(Date inDate1, Date inDate2)
    {
        if (inDate1 == null)
        {
            return -1;
        }

        if (inDate2 == null)
        {
            return 1;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD, Locale.US);

        Date d1 = null;
        Date d2 = null;
        try
        {
            d1 = sdf.parse(sdf.format(inDate1));
            d2 = sdf.parse(sdf.format(inDate2));
        }
        catch (ParseException e)
        {

        }

        if (d1 == null)
        {
            return -1;
        }

        if (d2 == null)
        {
            return 1;
        }

        return d1.compareTo(d2);
    }


    public Date dateAfterDays(Date inDate, int days)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(inDate);
        calendar1.add(Calendar.DATE, days);

        return calendar1.getTime();
    }


    /**
     * 
     * 根据corePress表达式获取下一次运行时间
     *
     * @author Sunyadong
     * @return
     */
    public Date getNextFireDate(Date inDate, String corePress)
    {
        CronExpression cron;
        try
        {
            cron = new CronExpression(corePress);
            return cron.getNextValidTimeAfter(inDate);
        }
        catch (ParseException e)
        {
            logger.error(">>> getNextFireDate failed!!!", e.getCause());
        }
        return null;

    }


    public List<Date> getDatesBetweenMinAndMax(Date minDate, Date maxDate)
    {
        if (minDate == null || minDate == null || minDate.after(maxDate))
        {
            return null;
        }
        List<Date> dates = new ArrayList<Date>();

        Calendar c1 = Calendar.getInstance();
        c1.setTime(minDate);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(maxDate);

        while (!c1.after(c2))
        {
            dates.add(c1.getTime());
            c1.add(Calendar.DATE, 1);
        }

        return dates;
    }


    public int daysAfterDate(Date originalDate, Date compareDate)
    {
        if (originalDate == null || compareDate == null)
        {
            return 0;
        }
        Calendar c1 = Calendar.getInstance();
        c1.setTime(originalDate);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(compareDate);

        int n = 0;

        while (!c1.after(c2))
        {
            c1.add(Calendar.DATE, 1);
            n++;
        }

        return n - 1;
    }


    public boolean isAfterDays(Date _value1, Date _value2, int intervalDays)
    {
        Date newDate = dateAfterDays(_value1, intervalDays);

        return compareDate(newDate, _value2) > 0;

    }


    public long getTimeStamp(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.getTimeInMillis();
    }


    public static String getLogicTimeStamp(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_LOGIC_TIMESTAMP, Locale.US);

        return sdf.format(date);
    }


    public String getCurrentLogicTimeStamp()
    {
        Date now = new Date();

        return getLogicTimeStamp(now);
    }


    public static String getLogicTimeStampWithoutMsec(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_LOGIC_TIMESTAMP_WITHOUT_MSEC, Locale.US);

        return sdf.format(date);
    }


    public static String getCurrentLogicTimeStampWithoutMsec()
    {
        Date now = new Date();

        return getLogicTimeStampWithoutMsec(now);
    }


    public String getLogicTimeStampWithoutMin(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_LOGIC_TIMESTAMP_WITHOUT_MIN, Locale.US);

        return sdf.format(date);
    }


    public String getCurrentLogicTimeStampWithoutMin()
    {
        Date now = new Date();

        return getLogicTimeStampWithoutMin(now);
    }


    public String getCurrentYearAndMonth()
    {
        Date now = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM", Locale.US);

        return sdf.format(now);
    }


    public String getYearAndMonth(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM", Locale.US);

        return sdf.format(date);
    }


    public Date getDateFromTimeStamp(long timeStamp)
    {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timeStamp);

        return c.getTime();
    }


    public Date getFirstTimeOfDay(Date inDate)
    {
        if (inDate == null)
        {
            return null;
        }

        String inValue_ = getInstance().convertDateToString(inDate, DEFAULT_DATE_FORMAT) + " 00:00:00";

        return getInstance().convertStringToDate(inValue_, DEFAULT_DATE_FORMAT + " HH:mm:ss");
    }


    public Date getLastTimeOfDay(Date inDate)
    {
        if (inDate == null)
        {
            return null;
        }

        String inValue_ = getInstance().convertDateToString(inDate, DEFAULT_DATE_FORMAT) + " 23:59:59";

        return getInstance().convertStringToDate(inValue_, DEFAULT_DATE_FORMAT + " HH:mm:ss");
    }


    public Date getFirstDayOfWeek(Date inDate, int weeks)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);
        calendar1.setTime(inDate);
        calendar1.add(Calendar.WEEK_OF_MONTH, -weeks);
        calendar1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return DateUtil.getInstance().getFirstTimeOfDay(calendar1.getTime());
    }


    public Date getLastDayOfWeek(Date inDate, int weeks)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);
        calendar1.setTime(inDate);
        calendar1.add(Calendar.WEEK_OF_MONTH, -weeks);
        calendar1.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return DateUtil.getInstance().getLastTimeOfDay(calendar1.getTime());
    }


    public Date getMaxTimeOfDate(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);

        return c.getTime();
    }


    public Date getMinTimeOfDate(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }


    public Date getCurrentFirstDayOfMonth()
    {
        Calendar c = Calendar.getInstance();
        c.setTime(getMinTimeOfDate(new Date()));
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }


    public Date getCurrentLastDayOfMonth()
    {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 0);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }


    public long getDistanceHours(Date inDate1, Date inDate2)
    {
        long hours = 0;
        try
        {
            long time1 = inDate1.getTime();
            long time2 = inDate2.getTime();
            long diff;
            if (time1 < time2)
            {
                diff = time2 - time1;
            }
            else
            {
                diff = time1 - time2;
            }

            hours = diff / (60 * 60 * 1000);
        }
        catch (Exception e)
        {
            logger.error("getDistanceHours failed [inDate1 :::: " + inDate1 + " && inDate2 :::: " + inDate2 + "]",
                    e.getCause());
        }

        return hours;
    }


    public String getDistanceHoursAndMinutesAndSeconds(Date inDate1, Date inDate2, long intervalHours)
    {
        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        try
        {
            long time1 = inDate1.getTime();
            long time2 = inDate2.getTime() + intervalHours * 60 * 60 * 1000;
            long diff;
            if (time1 < time2)
            {
                diff = time2 - time1;
            }
            else
            {
                diff = time1 - time2;
            }

            hours = diff / (60 * 60 * 1000);
            minutes = diff % (60 * 60 * 1000) / (60 * 1000);
            seconds = diff % (60 * 60 * 1000) % (60 * 1000) / 1000;
        }
        catch (Exception e)
        {
            logger.error("getDistanceHours failed [inDate1 :::: " + inDate1 + " && inDate2 :::: " + inDate2 + "]",
                    e.getCause());
        }

        return hours + " hour " + minutes + " minute " + seconds + " second";
    }


    public long getDistanceMins(Date inDate1, Date inDate2)
    {
        long mins = 0;
        try
        {
            long time1 = inDate1.getTime();
            long time2 = inDate2.getTime();
            long diff;
            if (time1 < time2)
            {
                diff = time2 - time1;
            }
            else
            {
                diff = time1 - time2;
            }

            mins = diff / (60 * 1000);
        }
        catch (Exception e)
        {
            logger.error("getDistanceHours failed [inDate1 :::: " + inDate1 + " && inDate2 :::: " + inDate2 + "]",
                    e.getCause());
        }

        return mins;
    }


    public Date getFirstDayOfMonth(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(getMinTimeOfDate(date));
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }


    public Date getLastDayOfMonth(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 0);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }


    public boolean isToday(Date inDate)
    {
        if (inDate == null)
        {
            return false;
        }
        Date today = new Date();
        Date firstTimeOfToday = this.getFirstTimeOfDay(today);
        Date lastTimeOfToday = this.getLastTimeOfDay(today);

        return !inDate.before(firstTimeOfToday) && !inDate.after(lastTimeOfToday);
    }


    public boolean isAfterHours(Date nowDate, Date processDate, int intervalHours)
    {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(nowDate);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(processDate);
        c2.add(Calendar.HOUR_OF_DAY, intervalHours);
        return !c1.before(c2);

    }


    public Date getPreviousDayDate(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -1);
        return c.getTime();
    }


    public Date getPreviousDayDate(Date date, Integer days)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -days);
        return c.getTime();
    }


    public Date dateAfterMonths(Date inDate, int months)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(inDate);
        calendar1.add(Calendar.MONTH, -months);
        return calendar1.getTime();
    }


    public Date getLastMonth(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }


    /**
     * 计算两个日期之间相差的天数
     * 
     * @param smdate 较小的时间
     * @param bdate 较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public int daysBetween(Date smdate, Date bdate)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long betweenDays = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(betweenDays));
    }


    /**
     * 比较两个日期之间相差的天数(取绝对值)是否在一个范围内
     * 
     * @param date
     * @param compareDate
     * @param range
     * @return boolean
     */
    public boolean daysBetweenRange(Date date, Date compareDate, int range)
    {
        if (date != null && compareDate != null && Math.abs(daysBetween(date, compareDate)) <= range)
        {
            return true;
        }
        return false;
    }


    public Date addHours(Date date, int hour)
    {
        Calendar cal = Calendar.getInstance(); // creates calendar

        cal.setTime(date); // sets calendar time/date

        cal.add(Calendar.HOUR_OF_DAY, hour); // adds one hour

        return cal.getTime();
    }


    /**
     * 
     * 获取日期的整点最大日期字符串(yyyyMMddHH:59:59)
     *
     * @author Sunyadong
     * @param %param inDate% %param description%
     * @return
     */
    public String getLastHourOfDay(Date inDate)
    {
        if (inDate == null) return null;

        return getInstance().convertDateToString(inDate, "yyyyMMddHH") + "5959";

    }


    public Date getDateWithSpecifyHourMinSecond(Date inDate, String hourMinSecond)
    {
        if (inDate == null)
        {
            return null;
        }

        String inValue_ = getInstance().convertDateToString(inDate, DEFAULT_DATE_FORMAT) + " " + hourMinSecond;

        return getInstance().convertStringToDate(inValue_, DEFAULT_DATE_FORMAT + " HH:mm:ss");
    }

    public long getTodayDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd");
        String formatDate = simpleDateFormat.format(new Date());
        String[] splitDate = formatDate.split(":");
        int year = Integer.valueOf(splitDate[0]);;
        int month = Integer.valueOf(splitDate[1]);
        int day = Integer.valueOf(splitDate[2]);
        Date date = new Date(year, month, day);
        long time = date.getTime();
        return time/1000;
    }




}
