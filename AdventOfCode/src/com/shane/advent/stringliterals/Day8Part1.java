package com.shane.advent.stringliterals;

import java.util.ArrayList;
import java.util.List;

import com.shane.advent.fileaccess.OpenFileReturnListOfStrings;

public class Day8Part1 {

	public static int getLiteralsMinusValues(){
		List<String> input1=OpenFileReturnListOfStrings.openFile("C:\\tools\\inputfiles\\string_literals.txt");
		List<char[]> char1=new ArrayList<char[]>();
		for(String s: input1){
			char1.add(s.toCharArray());
		}
		int totalLiterals=0;
		int totalStrings=0;
		for(char[] c:char1){
			totalLiterals+=c.length;
		}
		System.out.println("Total string literals: "+totalLiterals);
		List<String> input2=OpenFileReturnListOfStrings.openFile("C:\\tools\\inputfiles\\string_parsed.txt");
		List<char[]> char2=new ArrayList<char[]>();
		for(String s: input2){
			char2.add(s.toCharArray());
		}
		for(char[] d:char2){
			totalStrings+=d.length;
		}
		System.out.println(totalLiterals-totalStrings);
		return 0;
	}
}
