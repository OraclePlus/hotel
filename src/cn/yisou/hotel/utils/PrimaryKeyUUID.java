package cn.yisou.hotel.utils;

import java.util.UUID;

public class PrimaryKeyUUID {
	public static String getPrimaryKey(){
		int uid= -1;
		while (uid<0) {
			uid=UUID.randomUUID().hashCode();
		}
		return String.valueOf(uid);
	}
}	
