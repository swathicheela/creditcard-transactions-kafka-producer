package com.myhu.cheela.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String getCurrentDateTime() {
		format.setTimeZone(TimeZone.getTimeZone("EST"));
		return format.format(new Date());
	}
	
}
