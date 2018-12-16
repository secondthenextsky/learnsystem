package com.learnsystem.utils;

import java.security.MessageDigest;
import java.util.Base64;

public class MD5Uitls {
	
	/**
	 * 调用者必须判断content是否为null
	 * @param content 不能传入null
	 * @return
	 */
	public static String md5(String content){
		String result = null;
		
		try {
			byte[] bs = content.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("md5");
			bs = md.digest(bs);
			bs = Base64.getEncoder().encode(bs);
			result = new String(bs,"UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	

}
