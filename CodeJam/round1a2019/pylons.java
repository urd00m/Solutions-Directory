//package round1a2019;
/*
ID: urd00m
LANG: JAVA
TASK: pylons
 */
import java.io.*;
import java.util.*;
//greedy

public class Solution {
	static int t, r, c; 
	
	static int reached; 
	static boolean[][] visited; 
	static int[][] ret; 
	static int[] unvisitedR, unvisitedC; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine()); 
		for(int cn = 1; cn < t+1; cn++) {
			input = new StringTokenizer(f.readLine()); 
			r = Integer.parseInt(input.nextToken()); c = Integer.parseInt(input.nextToken()); 
			visited = new boolean[r][c]; 
			ret = new int[r*c][2]; 
			unvisitedR = new int[r]; unvisitedC = new int[c]; //to determine the position with max unvisited 
			
			//greedy
			boolean found = false; 
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					//reset 
					reached = 1; 
					for(int k = 0; k < r; k++) unvisitedR[k] = c; 
					for(int k = 0; k < c; k++) unvisitedC[k] = r;
					for(int a = 0; a < r; a++) for(int b = 0; b < c; b++) visited[a][b] = false;
					//for(int k = 0; k < r*c; k++) { ret[k][0] = -1; ret[k][1] = -1; } don't think you need this since each run will reset the ret 
					solve(i, j); 
					if(reached == r*c) {
						found = true; 
						break; 
					}
				}
				if(found == true) break; 
			}
			
			if(found == false) System.out.println("Case #" + cn + ": IMPOSSIBLE");
			else {
				 System.out.println("Case #" + cn + ": POSSIBLE");
				 for(int[] ary : ret) System.out.println((ary[0]+1) + " " + (ary[1]+1));
			}
		}
	}
	
	public static void solve(int row, int column) {
		ret[0][0] = row; ret[0][1] = column; 
		while(reached != r*c) {
			visited[row][column] = true;
			unvisitedR[row]--; 
			unvisitedC[column]--; 
			int max = -1; 
			int[] maxLoc = new int[2]; //row-column
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(visited[i][j] == false && i != row && j != column && (row-column) != (i-j) && (row+column) != (i+j)) {
						if(max < (unvisitedR[i] + unvisitedC[j])) {
							max = (unvisitedR[i] + unvisitedC[j]); 
							maxLoc[0] = i; maxLoc[1] = j; 
						}
					}
				}
			}
			if(max != -1) {
				row = maxLoc[0]; 
				column = maxLoc[1]; 
				ret[reached][0] = row; 
				ret[reached][1] = column; 
				reached++; 
			}
			else break; 
		}
	}
}
