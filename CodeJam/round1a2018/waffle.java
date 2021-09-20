package round1a2018;
/*
ID: urd00m
LANG: JAVA
TASK: waffle
 */
import java.io.*;
import java.util.*;

public class waffle {
	static int t; 
	static int r, c, h, v; //h is horozontal cuts and v is vertical cuts 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine()); 
		for(int cn = 1; cn < t+1; cn++) {
			input = new StringTokenizer(f.readLine()); 
			r = Integer.parseInt(input.nextToken()); c = Integer.parseInt(input.nextToken()); h = Integer.parseInt(input.nextToken()); v = Integer.parseInt(input.nextToken()); 
			//each rectangle has to have a specific number of chips based on the total number of chips 
			//so do the horozontal cuts then do the vertical cuts, if it isn't possible to split it into the chuncks then it is impossible 
			//but you also need to check each rectangle to ensure that they all have the neccessary amount of chips at the end as well
			int[] chipsR = new int[r]; //stores the number of chips in each row 
			int[] chipsC = new int[c]; 
			int[][] graph = new int[r][c]; //0 is no chip 1 is chip
			int total = 0; 
			for(int i = 0; i < r; i++) {
				String cur = f.readLine(); 
				for(int j = 0; j < c; j++) {
					if(cur.charAt(j) == '@') {
						graph[i][j] = 1;
						total++; 
						chipsR[i]++;
						chipsC[j]++; 
					}
				}
			}
			
			int chipsNeeded = (total/(h+1));
			int[][] rowIntervals = new int[h+1][2]; //inclusive  
			int j = 0; 
			boolean impossible = false;
			if(total%(h+1) != 0) impossible = true; 
			for(int i = 0; i < h+1; i++) {
				int cur = 0;
				while(cur != chipsNeeded && cur < chipsNeeded) {
					cur += chipsR[j]; 
					j++; 
				}
				if(cur == chipsNeeded) {
					if(i != 0) rowIntervals[i][0] = rowIntervals[i-1][1]+1; 
					else rowIntervals[i][0] = 0; 
					rowIntervals[i][1] = j-1; 
				}
				if(cur > chipsNeeded) {
					impossible = true; 
					break; 
				}
			}
			//begin checking column intervals
			if(total%(v+1) != 0) impossible = true; 
			int[][] columnIntervals = new int[v+1][2]; 
			chipsNeeded = (total/(v+1));
			j = 0; 
			for(int i = 0; i < v+1; i++) {
				int cur = 0; 
				while(cur != chipsNeeded && cur < chipsNeeded) {
					cur += chipsC[j]; 
					j++; 
				}
				if(cur == chipsNeeded) {
					if(i != 0) columnIntervals[i][0] = columnIntervals[i-1][1]+1; 
					else columnIntervals[i][0] = 0; 
					columnIntervals[i][1] = j-1; 
				}
				if(cur > chipsNeeded) {
					impossible = true; 
					break; 
				}
			}
			
			//checks the rectangles formed
			chipsNeeded = (total/((v+1)*(h+1))); 
			for(int i = 0; i < h+1; i++) {
				for(j = 0; j < v+1; j++) {
					int cur = 0; 
					for(int a = rowIntervals[i][0]; a < rowIntervals[i][1]+1; a++) {
						for(int b = columnIntervals[j][0]; b < columnIntervals[j][1]+1; b++) {
							cur += graph[a][b]; 
						}
					}
					if(cur != chipsNeeded) {
						impossible = true; 
						break; 
					}
				}
			}
			
			if(impossible == false) 
				System.out.println("Case #" + cn + ": POSSIBLE");
			else 
				System.out.println("Case #" + cn + ": IMPOSSIBLE");
		}
	}
}
