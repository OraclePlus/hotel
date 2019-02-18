package cn.yisou.hotel.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SqlDateConvert {
	public static Date convert(String d) {
		java.util.Date date=null;
		SimpleDateFormat sFormat=new SimpleDateFormat("MM/dd/yy");
		try {
			date = sFormat.parse(d);
			Date sqlDate=new Date(date.getTime());
			//System.out.println("sqldate"+sqlDate);
			return sqlDate ;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*public static void main(String[] args) {
		Date convert = SqlDateConvert.convert("02/06/2019");
		Date convert2 = SqlDateConvert.convert("02/07/2019");
	}*/
}
