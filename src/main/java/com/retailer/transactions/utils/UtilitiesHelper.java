package com.retailer.transactions.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilitiesHelper {
	
	public static String dateFormaterHelper(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");  
		return dateFormat.format(date); 		
	}
}
