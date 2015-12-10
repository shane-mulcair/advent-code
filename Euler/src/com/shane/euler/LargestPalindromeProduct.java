package com.shane.euler;

import java.util.ArrayList;
import java.util.List;

public class LargestPalindromeProduct {

	public static int getLargestPalindrome(){
		int largest=0;
		List<Integer> palindromes=new ArrayList();
		for(int i=100;i<1000;i++){
			for(int j=100;j<1000;j++){
				if(isPalindrome(i*j)>0){
					palindromes.add(i*j);
				}
			}
		}
		for(int i:palindromes){
			if(i>largest){
				largest=i;
			}
		}
		return largest;
	}
	
	private static int isPalindrome(int i){
		String s=String.valueOf(i);
		if (s.equals(new StringBuffer(s).
			      reverse().toString())){
			return Integer.parseInt(s);
		}
		return 0;
	}
}
