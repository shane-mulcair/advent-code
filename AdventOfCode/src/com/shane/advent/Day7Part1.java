package com.shane.advent;

import java.util.ArrayList;
import java.util.List;

import com.shane.advent.fileaccess.OpenFileReturnListOfStrings;

public class Day7Part1 {

	public static void createList() {
		List<String> inputs = OpenFileReturnListOfStrings.openFile("C:\\tools\\inputfiles\\logic_gates.txt");
		List<String> wires = new ArrayList<String>();
		for (String s : inputs) {
			String[] subs = s.split(" -> ");
			wires.add(subs[1]);
		}
		for (String c : wires) {
			System.out.println(c);
		}
	}
}
