package com.witskies.appmarket.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName: TimeUtil
 * @Description: 时间工具类
 * @author LanJie.Chen
 * @date 2014-8-29 下午4:05:05
 * @version V1.0
 * @Company:山西润叶网络科技有限公司
 */
public class TimeUtils {
	/**
	 * 
	 * @Description: 获取系统当前时间
	 * @return String
	 */
	public static String getCurrentTime() {
		String curTime = "";
		DateFormat formatter = new SimpleDateFormat("MM-dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		curTime = formatter.format(curDate);

		return curTime;
	}

	/**
	 * 
	 * @Description: 获取时间差
	 * @param oldTime
	 *            过去时间
	 * @param curTime
	 *            当前时间
	 * @return String
	 */
	public static String getTimeDifference(String oldTime, String curTime) {
		String diff = "";
		DateFormat formatter = new SimpleDateFormat("MM-dd HH:mm:ss");
		Date date1 = null, date2 = null;
		try {
			date1 = formatter.parse(curTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			date2 = formatter.parse(oldTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long temp = date1.getTime() - date2.getTime();
		long day = temp / (1000 * 60 * 60 * 24);
		long hour = (temp / (60 * 60 * 1000) - day * 24);
		long min = ((temp / (60 * 1000)) - day * 24 * 60 - hour * 60);
		diff = day + "天" + hour + "小时" + min + "分";
		// if (day > 0 && hour > 0 && min > 0) {
		//
		// }
		// if (day <= 0 && hour > 0 && min > 0) {
		//
		// diff = hour + "小时" + min + "分";
		// }
		// if (day <= 0 && hour <= 0 && min > 0) {
		//
		// diff = min + "分";
		// }
		// if (!diff.equals("")) {

		return diff;
		// }
	}

	/**
	 * 
	 * @Description: 获取时间差
	 * @param oldTime
	 *            过去时间
	 * @param curTime
	 *            当前时间
	 * @return String
	 */
	public static String getTimeDifference2(String oldTime, String curTime) {
		String diff = "";
		DateFormat formatter = new SimpleDateFormat("MM-dd HH:mm:ss");
		Date date1 = null, date2 = null;
		try {
			date1 = formatter.parse(curTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			date2 = formatter.parse(oldTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long l = date1.getTime() - date2.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long minute = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long second = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - minute * 60);
		diff = day + "天" + hour + "小时" + minute + "分" + second + "秒";
		return diff;
		// }
	}
}
