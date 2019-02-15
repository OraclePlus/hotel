package cn.yisou.hotel.utils;

import java.security.MessageDigest;

public class GetMD5Byte {
	public static byte[] getMD5Byte(String s){
		byte[] b = null;
		try {
			MessageDigest  md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			b = md.digest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public static boolean isMD5Equals(byte[] b1,byte[] b2){
		boolean flag = false;
		try {
			MessageDigest  md = MessageDigest.getInstance("MD5");
			flag = md.isEqual(b1, b2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
