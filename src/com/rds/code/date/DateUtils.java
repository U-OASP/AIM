package com.rds.code.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static SimpleDateFormat lineformat = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static SimpleDateFormat zhformat = new SimpleDateFormat(
			"yyyy年MM月dd日");

	public static SimpleDateFormat intformat = new SimpleDateFormat("yyyyMMdd");
	
	public static SimpleDateFormat formatzh2 = new SimpleDateFormat("yyyy年M月d日");

	/**
	 * 把yyyy-MM-dd格式日期转为yyyy年MM月dd日格式日期
	 * 
	 * @param dateString
	 * @return date
	 */
	public static String DateString2DateString(String dateString) {
		String date = "";
		try {
			date = zhformat.format(lineformat.parse(dateString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 日期转yyyyMMdd格式字符串
	 * @param date
	 * @return
	 */
	public static String Date2String(Date date){
		return intformat.format(date);
	}
}
