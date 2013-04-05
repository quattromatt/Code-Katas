package com.codekata.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	public static final String hash(String data) {
		MessageDigest m = null;
		String returnString = null;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(data.getBytes(), 0, data.length());
			returnString = new BigInteger(1, m.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return returnString;
	}
}
