package com.wkl.util;

public class DateUtil {
	
	public static java.util.Date d2t(java.sql.Timestamp t){
		if(null==t) return null;
		return new java.util.Date(t.getTime());
	}
	
	public static java.sql.Timestamp t2d(java.util.Date d){
		if(null==d) return null;
		return new java.sql.Timestamp(d.getTime());
	}
}
