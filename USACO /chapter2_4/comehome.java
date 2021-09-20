//package chapter2_4; 
/*
ID: alan.li2
LANG: JAVA
TASK: comehome
 */

import java.io.*; 
import java.util.*;

public class comehome {
	static int p; 
	static int[][] map = new int[52][52]; //adj matrix 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("comehome.in")); 
		p = Integer.parseInt(f.readLine()); 
		StringTokenizer input; 
		//initialize map
		for(int i = 0; i < 52; i++) {
			for(int j = 0; j < 52; j++) {
				map[i][j] = 99999999; 
			}
		}
		
		for(int i = 0; i < p; i++) {
			input = new StringTokenizer(f.readLine()); 
			char a = input.nextToken().charAt(0);
			char b = input.nextToken().charAt(0); 
			int dis = Integer.parseInt(input.nextToken());
			//converting chars to indexes 
			int aIdx; 
			if(Character.isUpperCase(a) == true)
				aIdx = a - 'A' + 26;
			else
				aIdx = a - 'a'; 
			int bIdx; 
			if(Character.isUpperCase(b) == true)
				bIdx = b - 'A' + 26; 
			else
				bIdx = b - 'a'; 
			
			//setting values
			if(dis < map[aIdx][bIdx]) {
				map[aIdx][bIdx] = dis;
				map[bIdx][aIdx] = dis; 
			}
		}	
		f.close();
		
		//initialize 
		for(int i = 0; i < 52; i++) {
			map[i][i] = 0; //ignore going to itself 
		}
		
		//floyd-walsh algorithm 
		for(int i = 0; i < 52; i++) {
			for(int j = 0; j < 52; j++) {
				for(int k = 0; k < 52; k++) {
					if (map[j][i] + map[i][k] < map[j][k]) 
                        map[j][k] = map[j][i] + map[i][k]; 
				}
			}
		}
		
		int fastestDis = 99999999;
		char from = 'a'; 
		for(int i = 26; i < 51; i++) { //don't count barn to itself 
			if(map[i][51] < fastestDis) {
				fastestDis = map[i][51]; 
				from = (char)((i-26)+'A'); 
			}
		}
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));
		out.println(from + " " + fastestDis);
		out.close();
	}
}
