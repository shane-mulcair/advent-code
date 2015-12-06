package com.shane.advent.fileaccess;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenFileReturnListOfStrings {
public static List<String> openFile(String path){
	List<String> output = new ArrayList<String>();
	Path filePath= Paths.get(path);
	try {
		output=Files.readAllLines(filePath);
		System.out.println("Output size:"+output.size());
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	return output;
}
}
