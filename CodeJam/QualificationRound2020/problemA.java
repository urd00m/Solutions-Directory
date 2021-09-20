//package QualificationRound2020;
/*
ID: urd00m
LANG: JAVA
TASK: vestigium
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t, n; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input;
		t = Integer.parseInt(f.readLine()); 
		
		//algorithm
		for(int cNum = 1; cNum <= t; cNum++) {
			n = Integer.parseInt(f.readLine()); 
			//record the ones that have passed for each column and row and O(1) checking
			int retr = 0, retc = 0, k = 0; 
			int[][] row = new int[n+1][n+1]; int[][] column = new int[n+1][n+1];
			boolean[] marked = new boolean[2*n+1]; 
			for(int i = 0; i < n; i++) { //row i 
				input = new StringTokenizer(f.readLine()); 
				for(int j = 0; j < n; j++) { //column j
					int cur = Integer.parseInt(input.nextToken());
					if(i == j) k += cur; 
					if(marked[i] == false && row[i][cur] == 1) { retr++; marked[i] = true; } 
					if(marked[j+n] == false && column[j][cur] == 1) { retc++; marked[j+n] = true; } 
					row[i][cur] = 1; 
					column[j][cur] = 1; 
				}
			}
			System.out.println("Case #" + cNum + ": " + k + " " + retr + " " + retc);
		}
		 
	}
}
