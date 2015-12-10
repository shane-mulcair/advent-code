package com.shane.advent.stringliterals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day8Part2 {
public static int getNumLiterals() throws IOException{
	Charset cs=StandardCharsets.UTF_8;
	Path filePath = Paths.get("C:\\tools\\literals.txt");
	List<String> inputs=Files.readAllLines(filePath, cs);
	int totalLiterals=0;
	int totalEncoded=0;
	for(String s:inputs){
		totalLiterals+=s.length();
		char[] c=s.toCharArray();
		for(int i=0;i<s.length();i++){
			if(c[i]=='\"'){
				totalEncoded+=3;
			}
			else if(c[i]=='\\'&&c[i+1]=='x'){
				totalEncoded+=2;
			}
			else if(c[i]=='\\'){
				totalEncoded+=4;
				i++;
			}
			else{
				totalEncoded++;
			}
			
		}
	}
	System.out.println("Total Literals:"+totalLiterals);
	System.out.println("Total Values: "+totalEncoded);
	
	return totalEncoded-totalLiterals;
}
}
