package cn.fuqiang.food.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); 
	/**
	 * 将传入的string类型的日期转换成Date类型的日期
	 * @param date String 类型的日期
	 * @return
	 */
	public static Date stringToDate(String date){
		Date temp = null;
		try {
			temp = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return temp;
	}
	/**
	 * 将传入的Date类型的日期转换成String类型的日期
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date){
		String temp = format.format(date);
		return temp;
	}
	/**
	 * 将传入的date类型的日期转换为long类型的日期
	 * @param date 
	 * @return
	 */
	public static long dateToLong(Date date){
		return date.getTime();
	}
	/**
	 * 将传入的long类型的日期转化为date类型的日期
	 * @param date
	 * @return
	 */
	public static Date longToDate(long date){
		Date temp = new Date(date);
		return temp;
	}
}
