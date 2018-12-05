package com.guide.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author czj
 * @version 1.0
 * @datetime 7:54:44 PM, Sep 13, 2016
 */
public class MD5Util {

	public static String encrypt(String str) {
		String result = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] byteArray = str.getBytes();
			md5.update(byteArray);
			byte[] resultArray = md5.digest();
			result = bytesToString(resultArray);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static String bytesToString(byte[] byteArray) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
				buffer.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			} else {
				buffer.append(Integer.toHexString(0xFF & byteArray[i]));
			}
		}
		return buffer.toString();
	}

}
