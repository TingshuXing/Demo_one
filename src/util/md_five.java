package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md_five {
	public static String addPassword(String str) throws Exception{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] srcBytes = str.getBytes();
		md5.update(srcBytes);
		byte[] resultBytes = md5.digest();
		String result = new String(resultBytes);
		return result;
	}
}
