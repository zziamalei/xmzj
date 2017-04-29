package com.xmzj.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
	public static SimpleDateFormat DateTime24h=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat DateTime24hTwo=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static SimpleDateFormat YearMonth=new SimpleDateFormat("yyyy-MM");
	public static SimpleDateFormat YearMonth6c=new SimpleDateFormat("yyyyMM");
	public static SimpleDateFormat DateSdf=new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat DateSdf8c=new SimpleDateFormat("yyyyMMdd");
	public static SimpleDateFormat TimeSdf=new SimpleDateFormat("HH:mm:ss");
	public static SimpleDateFormat DateTime24hMs=new SimpleDateFormat("yyyyMMddHHmmssSSS");
	public static SimpleDateFormat DateTime24hM=new SimpleDateFormat("yyyyMMddHHmmss");
	public static SimpleDateFormat DateTimeChs=new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
	
	public static String newBlackListDateString() {
		String endTime=DateTime24h.format(newBlackListDate());//截止时间
		return endTime;
	}
	
	public static Date newBlackListDate() {
		Calendar calendar=Calendar.getInstance();
		//calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, 99);
		return calendar.getTime();
	}
	
	public static Date getTodayDate(){
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static String nowTime() {
		return DateTimeToString(new Date());
	}
	public static Date nowDateTime() {
		return new Date();
	}
	
	public static String nowTimeChs() {
		return DateTimeToStringChs(new Date());
	}
	
	public static String nowTimeMs() {
		return DateTimeToStringMs(new Date());
	}
	
	public static String DateTimeToString(Date date) {
		return DateTime24h.format(date);
	}
	
	public static String DateTimeToStringChs(Date date) {
		return DateTimeChs.format(date);
	}
	
	public static String DateToString(Date date) {
		return DateSdf.format(date);
	}
	public static String yearMonthToString(Date date) {
		return YearMonth.format(date);
	}
	
	public static String DateTimeToStringMs(Date date) {
		return DateTime24hMs.format(date);
	}
	public static String DateTimeToStringM(Date date) {
		return DateTime24hM.format(date);
	}
	
	public static Date parseDateNoTime(String dateString) throws Exception {
		return DateSdf.parse(dateString);
	}
	
	public static Date parseDate(String dateString)  {
		try {
			return DateTime24h.parse(dateString);
		} catch (ParseException e) {
			return new Date();
		}
	}
	public static Date parseDateToDay(String dateString) throws Exception {
		return DateSdf.parse(dateString);
	}
	
	public static Timestamp getNowTimeStamp(){
		return  new Timestamp(System.currentTimeMillis());
	}
	
	public static long getBetweenTimeStamp(Timestamp start,Timestamp end){
		return end.getTime()-start.getTime();
	}
	public static long getBetweenTime(Date start,Date end){
		return (end.getTime()-start.getTime())/60000;
	}
	 //公用方法
    public static Date formatDate(Date tempDate){
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = (Date) Timestamp.valueOf(formatter.format(tempDate));
		return time;
    }
    //获取上个月的时间
    public static String getMonthAgo(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, -1);
		return DateTimeToString(cal.getTime());
	}
    
    //获取当前月下个月的时间
    public static Date getNextMonth(Date nowDate){
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(nowDate);
    	cal.add(Calendar.MONTH, 1);
    	return cal.getTime();
    }
    
    public static Calendar dateStr2Calendar(String dateString){
    	Date d=DateTimeUtil.parseDate(dateString);
    	Calendar c=Calendar.getInstance();
    	c.setTime(d);
    	return c;
    }
    
    public static void main(String[] args) {
    	
    	Date start=DateTimeUtil.parseDate("2016-09-28 12:20:30");
    	Date end=DateTimeUtil.parseDate("2016-09-28 12:25:30");
    	
    	System.out.println(DateTimeUtil.getBetweenTime(start, end));
    	
    	Calendar ca=Calendar.getInstance();
    	System.out.println(ca.getTimeInMillis());
	}
}
