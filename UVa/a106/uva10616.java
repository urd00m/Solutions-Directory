package a106;


/*
ID: urd00m
LANG: JAVA
TASK: uva10616
 */

import java.io.*;
import java.util.*;

public class uva10616 {
	static int n, q, d, m; 
	static int[] val;  
	static int set = 1; 
	static int[][][] dp; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		//top down recursive backtracking 
		input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); q = Integer.parseInt(input.nextToken()); 
		while(n != 0) {
			System.out.println("SET " + set++ + ":"); 
			val = new int[n]; 
			for(int i = 0; i < n; i++) val[i] = Integer.parseInt(f.readLine()); 
			for(int i = 0; i < q; i++) {
				input = new StringTokenizer(f.readLine()); 
				d = Integer.parseInt(input.nextToken()); m = Integer.parseInt(input.nextToken());
				dp = new int[n][m][d]; //depth and value 
				int ret = recur(0, 0, d, 0); 
				System.out.println("QUERY " + (i+1) + ": " + ret);

			} 
			
			input = new StringTokenizer(f.readLine()); 
			n = Integer.parseInt(input.nextToken()); q = Integer.parseInt(input.nextToken()); 
		}
	}
	
	public static int recur(long sum, int depth, int d, int id) {
		if(depth == m && sum == 0) {
			return 1; 
		}
		if(depth == m && sum != 0) {
			return 0; 
		}
		else if(id == n) return 0;  
		else if(dp[id][depth][(int)(sum)] > 0) return dp[id][depth][(int)(sum)];
		else {
			int total = 0; 
			int next = (int) ((sum+val[id])%d); 
			if(next < 0) next = d-Math.abs(next); 
			total += recur(next, depth+1, d, id+1);  
			total += recur(sum, depth, d, id+1);
			dp[id][depth][(int)(sum)] = total; 
			return total; 
		}
	}
}
