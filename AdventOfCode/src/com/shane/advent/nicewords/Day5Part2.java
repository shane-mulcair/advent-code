package com.shane.advent.nicewords;

import java.util.List;
import java.util.regex.Pattern;

import com.shane.advent.fileaccess.OpenFileReturnListOfStrings;

/*
 * Second rule set:
 * It contains a pair of any two letters that
 * appears at least twice in the string without overlapping, like xyxy (xy) or aabcdefgaa (aa),
 * but not like aaa (aa, but it overlaps).
 * It contains at least one letter which repeats with exactly one letter between them,
 * like xyx, abcdefeghi (efe), or even aaa
 */
public class Day5Part2 {
	public static int getNumNiceWords(String filePath) {
		int total = 0;
		int hasTwopairs=0;
		int hasLetters=0;
		int newTotal=0;
		List<String> words = OpenFileReturnListOfStrings.openFile(filePath);
		if (words.isEmpty()) {
			return 0;
		}
		Pattern p2_p1 = Pattern.compile("(..).*\\1");
        Pattern p2_p2 = Pattern.compile("(.).\\1");
		for (String s : words) {
			if(p2_p1.matcher(s).find()&&p2_p2.matcher(s).find()){
			newTotal++;
			}
			
			if(hasTwoPairs(s))hasTwopairs++;
			if(hasLetterMatch(s)) hasLetters++;
			if (hasTwoPairs(s) ) {
				total++;
			}
		}
		 
	        System.out.println("New total: "+newTotal);
		System.out.println(hasTwopairs);
		System.out.println(hasLetters);
		return total;
	}

	private static boolean hasTwoPairs(String input) {
		for (int j = 0; j < input.length()-2; j++) {
			String subseq = input.substring(j, j + 2);
			if (input.substring(j + 1, input.length() - 1).contains(subseq)) {
				return hasLetterMatch(input);
			}
		}
		return false;
	}

	private static boolean hasLetterMatch(String input) {
		for (int i = 0; i < input.length() - 2; i++) {
			char first = input.charAt(i);
			char third = input.charAt(i + 2);
			if (first == third) {
				return true;
			}
		}
		return false;
	}
}
