package cn.fuqiang.food.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); 
	/**
	 * �������string���͵�����ת����Date���͵�����
	 * @param date String ���͵�����
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
	 * �������Date���͵�����ת����String���͵�����
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date){
		String temp = format.format(date);
		return temp;
	}
	/**
	 * �������date���͵�����ת��Ϊlong���͵�����
	 * @param date 
	 * @return
	 */
	public static long dateToLong(Date date){
		return date.getTime();
	}
	/**
	 * �������long���͵�����ת��Ϊdate���͵�����
	 * @param date
	 * @return
	 */
	public static Date longToDate(long date){
		Date temp = new Date(date);
		return temp;
	}
}
