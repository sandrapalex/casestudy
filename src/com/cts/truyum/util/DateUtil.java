package com.cts.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) {
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/mm/yyyy");
		Date d=new Date();
		try {
			d = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
}
