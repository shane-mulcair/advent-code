package com.shane.advent;

import java.util.List;

import com.shane.advent.fileaccess.OpenFileReturnListOfStrings;

public class Day6Part1 {
	static int[][] array = new int[1000][1000];
	
	public static int lightController(String filePath){
		List<String> instructions=OpenFileReturnListOfStrings.openFile(filePath);
		
		for(String s:instructions){
			if(s.contains("turn on")){
				getValues(s,2,4,1);
			}
			else if(s.contains("turn off")){
				getValues(s,2,4,2);
			}
			else{
				getValues(s, 1, 3,3);
			}
		}
		return countLights();
	}
	private static int countLights(){
		int total=0;
		for(int i=0;i<1000;i++){
			for(int j=0;j<1000;j++){
				if(array[i][j]==1){
					total++;
				}
			}
		}
		return total;
	}
	private static void getValues(String s, int i, int j,int state){
		String[] inputs=s.split("\\s");
		String[] firsts=inputs[i].split(",");
		String[] seconds=inputs[j].split(",");
		int x1=0;
		int x2=0;
		int y1=0;
		int y2=0;
		x1=Integer.parseInt(firsts[0]);
		y1=Integer.parseInt(firsts[1]);
		x2=Integer.parseInt(seconds[0]);
		y2=Integer.parseInt(seconds[1]);
		changeLights(x1,y1,x2,y2,state);
	}
	private static void changeLights(int x1, int y1, int x2, int y2,int state){
		for(int i=x1;i<=x2;i++){
			for(int j=y1;j<=y2;j++){
				if(state==1){
				array[i][j]=1;
				}
				else if(state==2){
					array[i][j]=0;
				}
				else{
					if(array[i][j]==1){
						array[i][j]=0;
					}
					else{
						array[i][j]=1;
					}
				}
			}
		}
	}
}
