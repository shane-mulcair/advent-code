package com.shane.advent;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4Part1 {

	static String input="ckczppom";
	static String result="00000";
	public static int getLPM() throws UnsupportedEncodingException, NoSuchAlgorithmException{
		int i=0;
		boolean found=false;
		MessageDigest md=MessageDigest.getInstance("MD5");
		while(!found){
			byte[] bytesOfMessage=(input+String.valueOf(i)).getBytes("UTF-8");	
		    byte[] thedigest=md.digest(bytesOfMessage);
		    StringBuffer decoded=new StringBuffer();
		    for (int j = 0; j < thedigest.length; ++j) {
		          decoded.append(Integer.toHexString((thedigest[j] & 0xFF) | 0x100).substring(1,3));
		    }
		    if(decoded.substring(0,5).equals(result)){
		    	found=true;
		    }
		    else{
		    	i++;
		    }
		}
		return i;
	}
}
