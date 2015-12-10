package com.shane.advent.movefloors;

import java.util.List;

import com.shane.advent.fileaccess.OpenFileReturnListOfStrings;

public class Day1Part1 {
	public static int getFloor(){
		List<String> input=OpenFileReturnListOfStrings.openFile("C:\\tools\\inputfiles\\santa_floors.txt");
		String instructions=input.get(0);
		int floor=0;
		for(char c:instructions.toCharArray()){
			if(c=='('){
				floor++;
			}
			else{
				floor--;
			}
		}
		return floor;
	}
}
