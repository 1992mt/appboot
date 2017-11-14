package com.app.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class TimeUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(TimeUtil.class);
	public final static String DateFormatYYYYMMDDHHMMSS14 = "yyyyMMddHHmmss";
	public final static String DateFormatYYYYMMDD8 = "yyyyMMdd";
	public final static String DateFormatYYYYMMDDHHMMSS19 = "yyyy-MM-dd HH:mm:ss";
	public final static String DateFormatYYYYMMDD10 = "yyyy-MM-dd";
	public final static String DateFormatMMDDYYYYHHMMSS1 = "MM/dd/yyyy HH:mm:ss";
	
  /**
   * 在一个时间上加上对应的年
   * @param ti long
   * @param i int
   * @throws Exception
   * @return Date
   */
  public static Date addOrMinusYear(long ti, int i) throws Exception{
    Date rtn = null;
    GregorianCalendar cal = new GregorianCalendar();
    Date date = new Date(ti);
    cal.setTime(date);
    cal.add(GregorianCalendar.YEAR, i);
    rtn = cal.getTime();
    return rtn;
  }

  /**
   * 在一个时间上加上对应的月份数
   * @param ti long
   * @param i int
   * @throws Exception
   * @return Date
   */
  public static Date addOrMinusMonth(long ti, int i) throws Exception{
    Date rtn = null;
    GregorianCalendar cal = new GregorianCalendar();
    Date date = new Date(ti);
    cal.setTime(date);
    cal.add(GregorianCalendar.MONTH, i);
    rtn = cal.getTime();
    return rtn;
  }
  /**
   * 在一个时间上加上或减去周
   * @param ti long
   * @param i int
   * @return Date
   */
  public static Date addOrMinusWeek(long ti, int i) {
    Date rtn = null;
    GregorianCalendar cal = new GregorianCalendar();
    Date date = new Date(ti);
    cal.setTime(date);
    cal.add(GregorianCalendar.WEEK_OF_YEAR, i);
    rtn = cal.getTime();
    return rtn;
  }

  /**
   * 在一个时间上加上或减去天数
   * @param ti long
   * @param i int
   * @return Date
   */
  public static Date addOrMinusDays(long ti, int i) {
    Date rtn = null;
    GregorianCalendar cal = new GregorianCalendar();
    Date date = new Date(ti);
    cal.setTime(date);
    cal.add(GregorianCalendar.DAY_OF_MONTH, i);
    rtn = cal.getTime();
    return rtn;
  }
  /**
   * 在一个时间上加上或减去小时
   * @param ti long
   * @param i int
   * @return Date
   */
  public static Date addOrMinusHours(long ti, int i) {
    Date rtn = null;
    GregorianCalendar cal = new GregorianCalendar();
    Date date = new Date(ti);
    cal.setTime(date);
    cal.add(GregorianCalendar.HOUR, i);
    rtn = cal.getTime();
    return rtn;
  }
  /**
   * 在一个时间上加上或减去分钟
   * @param ti long
   * @param i int
   * @return Date
   */
  public static Date addOrMinusMinutes(long ti, int i) {
    Date rtn = null;
    GregorianCalendar cal = new GregorianCalendar();
    Date date = new Date(ti);
    cal.setTime(date);
    cal.add(GregorianCalendar.MINUTE, i);
    rtn = cal.getTime();
    return rtn;
  }
  /**
   * 在一个时间上加上或减去秒数
   * @param ti long
   * @param i int
   * @return Date
   */
  public static Date addOrMinusSecond(long ti, int i) {
    Date rtn = null;
    GregorianCalendar cal = new GregorianCalendar();
    Date date = new Date(ti);
    cal.setTime(date);
    cal.add(GregorianCalendar.SECOND, i);
    rtn = cal.getTime();
    return rtn;
  }

    /**
     * 根据指定的日期获取下个月的第一天的时间
     * @param date
     * @return
     * @author shaosm
     */
    public static Timestamp getDateOfNextMonthFirstDay(Date date) {
	Calendar rightNow = Calendar.getInstance();
	rightNow.setTime(date);
	rightNow.set(Calendar.DAY_OF_MONTH,1);
	rightNow.set(Calendar.HOUR_OF_DAY,0);
	rightNow.set(Calendar.MILLISECOND,0);
	rightNow.set(Calendar.SECOND,0);
	rightNow.set(Calendar.MINUTE,0);
	rightNow.set(Calendar.MONTH,rightNow.get(Calendar.MONTH)+1);
	return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * 根据指定的日期获取上个月的第一天的时间
     * 
     * @param date
     * @return
     */
    public static Timestamp getDateOfPreMonthFirstDay(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(Calendar.DAY_OF_MONTH,1);
        rightNow.set(Calendar.HOUR_OF_DAY,0);
        rightNow.set(Calendar.MILLISECOND,0);
        rightNow.set(Calendar.SECOND,0);
        rightNow.set(Calendar.MINUTE,0);
        rightNow.set(Calendar.MONTH,rightNow.get(Calendar.MONTH)-1);
        return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * 将带有时间类型的日期转换成不带时间的日期
     *
     * @param date
     * @return
     */
    public static Timestamp formatDateTimeToDate(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(Calendar.HOUR_OF_DAY,0);
        rightNow.set(Calendar.MILLISECOND,0);
        rightNow.set(Calendar.SECOND,0);
        rightNow.set(Calendar.MINUTE,0);
        return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * 根据指定日期获取该月的最后一天的最后时间点
     *
     * @param date
     * @return
     */
    public static Timestamp getDateOfCurrentMonthEndDay(Date date) {
	Calendar rightNow = Calendar.getInstance();
	rightNow.setTime(date);
	rightNow.set(Calendar.DAY_OF_MONTH,rightNow.getActualMaximum(Calendar.DAY_OF_MONTH));
	rightNow.set(Calendar.HOUR_OF_DAY,23);
	rightNow.set(Calendar.MILLISECOND,59);
	rightNow.set(Calendar.SECOND,59);
	rightNow.set(Calendar.MINUTE,59);
	rightNow.set(Calendar.MONTH,rightNow.get(Calendar.MONTH));
	return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * 根据指定日期获取当天的最后的时间点
     *
     * @param date
     * @return
     */
    public static Timestamp getLastDate(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(Calendar.HOUR_OF_DAY, 23);
        rightNow.set(Calendar.MILLISECOND, 59);
        rightNow.set(Calendar.SECOND, 59);
        rightNow.set(Calendar.MINUTE, 59);
        rightNow.set(Calendar.MONTH, rightNow.get(Calendar.MONTH));
        return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * 根据指定日期获取前一天的最后的时间点
     *
     * @param date
     * @return
     */
    public static Timestamp getPreLastDate(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(Calendar.DAY_OF_MONTH,rightNow.get(Calendar.DAY_OF_MONTH)-1);
        rightNow.set(Calendar.HOUR_OF_DAY, 23);
        rightNow.set(Calendar.MILLISECOND, 59);
        rightNow.set(Calendar.SECOND, 59);
        rightNow.set(Calendar.MINUTE, 59);
        rightNow.set(Calendar.MONTH, rightNow.get(Calendar.MONTH));
        return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * 根据指定日期获取下一天的开始的时间点
     *
     * @param date
     * @return
     */
    public static Timestamp getNextDay(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(Calendar.DAY_OF_MONTH,rightNow.get(Calendar.DAY_OF_MONTH)+1);
        rightNow.set(Calendar.HOUR_OF_DAY, 0);
        rightNow.set(Calendar.MILLISECOND, 0);
        rightNow.set(Calendar.SECOND, 0);
        rightNow.set(Calendar.MINUTE, 0);
        rightNow.set(Calendar.MONTH, rightNow.get(Calendar.MONTH));
        return new Timestamp(rightNow.getTimeInMillis());
    }
    
    /**
     * 为一个日期添加指定的时间
     *
     * @param date
     * @param time
     * @return
     */
    public static Timestamp dateAddTime(Date date, String time) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
        rightNow.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time.split(":")[0]));
        rightNow.set(Calendar.MINUTE, Integer.parseInt(time.split(":")[1]));
        rightNow.set(Calendar.SECOND, Integer.parseInt(time.split(":")[2]));			        
        rightNow.set(Calendar.MILLISECOND, 00);
        return new Timestamp(rightNow.getTimeInMillis());
	}

    /**
     * 将时间格式化为YYYY-MM-DD
     * @param date
     * @return
     */
    public static String getYYYYMMDD(Date date){
	    if(date==null)
		    return null;
	    DateFormat dateformat = new SimpleDateFormat(DateFormatYYYYMMDD10);
	    return dateformat.format(date);
    }

    /**
     * 将时间格式化为YYYYMMDD
     * @param date
     * @return
     */
    public static String getNoLineYYYYMMDD(Date date){
	    if(date==null)
		    return null;
	    DateFormat dateformat = new SimpleDateFormat(DateFormatYYYYMMDD8);
	    return dateformat.format(date);
    }
    
    /**
     * 将时间格式化为YYYY-MM-DD HH:MM:SS
     * @param date
     * @return
     */
    public static String getYYYYMMDDHHMMSS(Date date){
	    if(date==null)
		    return null;
	    DateFormat dateformat = new SimpleDateFormat(DateFormatYYYYMMDDHHMMSS19);
	    return dateformat.format(date);
    }

    /**
     * 将时间格式化为YYYYMMDDHHMMSS
     * @param date
     * @return
     */
    public static String getNoLineYYYYMMDDHHMMSS(Date date){
	    if(date==null)
		    return null;
	    DateFormat dateformat = new SimpleDateFormat(DateFormatYYYYMMDDHHMMSS14);
	    return dateformat.format(date);
    }
    
    
    /**
     * 将指定的日期取整
     * @param date
     * @return
     * @author shaosm
     */
    public static Timestamp getTruncDate(Date date) {
	Calendar rightNow = Calendar.getInstance();
	rightNow.setTime(date);
	rightNow.set(Calendar.HOUR_OF_DAY,0);
	rightNow.set(Calendar.MILLISECOND,0);
	rightNow.set(Calendar.SECOND,0);
	rightNow.set(Calendar.MINUTE,0);
	return new Timestamp(rightNow.getTimeInMillis());
    }
    /**
     * 根据指定的日期获取月的第一天的时间
     * 
     * @param date
     * @return
     */
    public static Timestamp getDateOfMonthFirstDay(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(Calendar.DAY_OF_MONTH,1);
        rightNow.set(Calendar.HOUR_OF_DAY,0);
        rightNow.set(Calendar.MILLISECOND,0);
        rightNow.set(Calendar.SECOND,0);
        rightNow.set(Calendar.MINUTE,0);
        rightNow.set(Calendar.MONTH,rightNow.get(Calendar.MONTH));
        return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * 根据指定日期获取最后时间点
     *
     * @param date
     * @return
     */
    public static Timestamp getDateOfCurrentEndDay(Date date) {
	Calendar rightNow = Calendar.getInstance();
	rightNow.setTime(date);
	rightNow.set(Calendar.HOUR_OF_DAY,23);
	rightNow.set(Calendar.MILLISECOND,59);
	rightNow.set(Calendar.SECOND,59);
	rightNow.set(Calendar.MINUTE,59);
	rightNow.set(Calendar.MONTH,rightNow.get(Calendar.MONTH));
	return new Timestamp(rightNow.getTimeInMillis());
    }

	/**
	 * 根据时间串获得时间日期对象
	 * 
	 * @param time String 时间串
	 * @param pattern String 时间格式
	 * @throws Exception
	 * @return Timestamp
	 */
	public static Date getDateByPattern(String time, String pattern)
			throws Exception {
		Date rtn = null;
		DateFormat dateformat = new SimpleDateFormat(pattern);
		rtn = dateformat.parse(time.trim());
		return rtn;
	}

    
	/**
	 * 根据时间串获得时间对象
	 * 
	 * @param time String 时间串(格式：yyyy-mm-dd hh24:mi:ss)
	 * @param pattern String 时间格式
	 * @throws Exception
	 * @return Timestamp
	 */
	public static Timestamp getTimestampByPattern(String time, String pattern)
			throws Exception {
		Timestamp rtn = null;
		DateFormat dateformat = new SimpleDateFormat(pattern);
		rtn = new Timestamp(dateformat.parse(time.trim()).getTime());
		return rtn;
	}
	
	
	/**
	 * 根据时间串获得时间对象
	 * 
	 * @param time String 时间串(格式：yyyy-mm-dd hh24:mi:ss)
	 * @throws Exception
	 * @return Timestamp
	 */
	public static Timestamp getTimestampByString(String time)
			throws Exception {
		Timestamp rtn = null;
		if(!StringUtils.isEmpty(time))
		{
			String pattern = DateFormatYYYYMMDDHHMMSS19;
			if(time.trim().length()<=10)
			{
				pattern = DateFormatYYYYMMDD10;
			}			
			DateFormat dateformat = new SimpleDateFormat(pattern);
			rtn = new Timestamp(dateformat.parse(time.trim()).getTime());
		}
		return rtn;
	}
	  /**
	   * 获得时间的字符串
	   * @param ts Timestamp
	   * @param pattern String
	   * @throws Exception
	   * @return String
	   */
	  public static String getStringByTimestamp(Timestamp ts,String pattern){
		if(ts==null){
		  return null;
		}
		DateFormat dateformat = new SimpleDateFormat(pattern);
		String str = dateformat.format(ts);
		return str;
	  }	
	  
	  /**
	   * 把秒转换成小时
	   * @param date long
	   * @return String
	   */
	  public static String getHHMMSS(long lDate) {
	    String strHH = "";
	    String strMM = "";
	    String strSS = "";
	    strHH = String.valueOf(lDate / (60 * 60));
	    strMM = String.valueOf(lDate % (60 * 60) / 60);
	    strSS = String.valueOf((lDate % (60 * 60)) % 60);
	    if (strHH.length() == 1) {
	      strHH = "0" + strHH;
	    }
	    if (strMM.length() == 1) {
	      strMM = "0" + strMM;
	    }
	    if (strSS.length() == 1) {
	      strSS = "0" + strSS;
	    }
	    return strHH + ":" + strMM + ":" + strSS;
	  }
	  
	  
	  /**
	   * 把时间格式的字符串转换成长整型
	   * @param lDate String  时间格式的字符串
	   * @return long         长整型
	   */
	  public static long getHHMMSS(String lDate) {
	    long ldate = 0L;
	    ldate =  Long.parseLong(lDate.substring(0, 1)) * 10 * 60 * 60 +
	             Long.parseLong(lDate.substring(1, 2)) * 1 * 60 * 60;
	    ldate += Long.parseLong(lDate.substring(3, 4)) * 10 * 60 +
	             Long.parseLong(lDate.substring(4, 5)) * 1 * 60;
	    ldate += Long.parseLong(lDate.substring(6, 7)) * 10 +
	             Long.parseLong(lDate.substring(7, 8)) * 1;
	    return ldate;
	  }	  
	  
	public static String getCurrentTime() {
		String now = "";
		Timestamp ts = new Timestamp(new Date().getTime());
		try {
			now = TimeUtil.getStringByTimestamp(ts,
					TimeUtil.DateFormatYYYYMMDDHHMMSS14);
		} catch (Exception e) {
			logger.error("",e);
		}
		return now;
	}
	
	
	public static Date getDateByString(String time, String pattern){
		Timestamp timestampByPattern = null;
		try {
			timestampByPattern = getTimestampByPattern(time, pattern);
		} catch (Exception e) {
			logger.error("", e);
		}
		return timestampByPattern;
	}
	
	public static String getStringByDate(Date time, String pattern){
		String stringByTimestamp = null;
		Timestamp ts = new Timestamp(time.getTime());
		try {
			 stringByTimestamp = getStringByTimestamp(ts, pattern);
		} catch (Exception e) {
			logger.error("", e);
		}
		return stringByTimestamp;
	}
}
