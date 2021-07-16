package net.epiclanka.training.utill.core;

import java.util.Base64;

public class UtillBase64 {

	
	public static String getEncodedString(String str) {
		return new String(Base64.getEncoder().encode(str.getBytes()));
	}

	public static String getDecodedString(String encodedstr) {
		 
		return new String( Base64.getDecoder().decode(encodedstr.getBytes()));
	}
	
}
