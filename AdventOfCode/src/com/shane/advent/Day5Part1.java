package com.shane.advent;

import java.util.List;

import com.shane.advent.fileaccess.OpenFileReturnListOfStrings;

/*
Opens the given file and checks the strings to count how many are "nice", i.e how many follow the given rules.
It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
*/
public class Day5Part1 {
	public static String ab = "ab";
	public static String cd = "cd";
	public static String pq = "pq";
	public static String xy = "xy";

	public static int getNumNiceWords(String filePath) {
		int total = 0;
		List<String> words = OpenFileReturnListOfStrings.openFile(filePath);
		if (words.isEmpty()) {
			return 0;
		}
		for (String s : words) {
			if (noBadStrings(s) && hasEnoughVowels(s) && hasRepeatedLetters(s)) {
				total++;
			} 
		}
		return total;
	}

	private static boolean hasRepeatedLetters(String input) {
		for (int i = 1; i < input.length() ; i++) {
			if (input.charAt(i) == input.charAt(i-1)) {
				return true;
			}
		}
		return false;
	}

	private static boolean noBadStrings(String input) {
		if (input.contains(ab) || input.contains(cd) || input.contains(pq) || input.contains(xy)) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean hasEnoughVowels(String s) {
		int vowelCount = 0;
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
		if (c=='a') {
			vowelCount++;
		}
		if (c=='e') {
			vowelCount++;
		}
		if (c=='i') {
			vowelCount++;
		}
		if (c=='o') {
			vowelCount++;
		}
		if (c=='u') {
			vowelCount++;
		}
		}
		if(vowelCount>=3){
			return true;
		}
		else{
			return false;
		}
	}

}
