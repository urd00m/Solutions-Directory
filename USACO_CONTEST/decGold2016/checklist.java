//package decGold2016;
/*
ID: alwang
LANG: JAVA
TASK: checklist
 */
import java.util.*;
import java.io.*;

public class checklist {
	static int h, g; 
	static point[] hs, gs; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("checklist.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		h = Integer.parseInt(input.nextToken()); g = Integer.parseInt(input.nextToken()); 
		hs = new point[h+1]; gs = new point[g+1]; 
		for(int i = 1; i < h+1; i++) {
			input = new StringTokenizer(f.readLine()); 
			hs[i] = new point(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken())); 
		}
		for(int i = 1; i < g+1; i++) {
			input = new StringTokenizer(f.readLine()); 
			gs[i] = new point(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken())); 
		}
		f.close();
		
		//algorithm: dp
		int[][][] dp = new int[h+1][g+1][2]; //h count - g count - 0 means you came from h, and 1 means you came from g 
		for(int i = 0; i < h+1; i++) {
			for(int j = 0; j < g+1; j++) {
				for(int k = 0; k < 2; k++) {
					dp[i][j][k] = Integer.MAX_VALUE; 
				}
			}
		}
		dp[1][0][0] = 0; 
		for(int i = 1; i < h; i++) {
			for(int j = 0; j < g+1; j++) { //k depends on where you are coming from
				if(dp[i-1][j][0] != Integer.MAX_VALUE && i != 1) dp[i][j][0] = Math.min(dp[i][j][0], dp[i-1][j][0] + (int)( Math.pow(hs[i-1].x-hs[i].x, 2) + Math.pow(hs[i-1].y-hs[i].y, 2)));
				if(dp[i-1][j][1] != Integer.MAX_VALUE && i != 1) dp[i][j][0] = Math.min(dp[i][j][0], dp[i-1][j][1] + (int)( Math.pow(gs[j].x-hs[i].x, 2) + Math.pow(gs[j].y-hs[i].y, 2)));
				if(j != 0 && dp[i][j-1][0] != Integer.MAX_VALUE) dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j-1][0] + (int)( Math.pow(hs[i].x-gs[j].x, 2)+Math.pow(hs[i].y-gs[j].y, 2))); 
				if(j != 0 && dp[i][j-1][1] != Integer.MAX_VALUE) dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j-1][1] + (int)( Math.pow(gs[j-1].x-gs[j].x, 2)+Math.pow(gs[j-1].y-gs[j].y, 2)));
			}
		}
		
		//final results 
		//looking at h-1 and g
		int output = Integer.MAX_VALUE;
		output = Math.min(output, dp[h-1][g][0] + (int)(Math.pow(hs[h].x-hs[h-1].x, 2) + Math.pow(hs[h].y-hs[h-1].y, 2))); 
		output = Math.min(output, dp[h-1][g][1] + (int)(Math.pow(hs[h].x-gs[g].x, 2) + Math.pow(hs[h].y-gs[g].y, 2))); 
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("checklist.out"))); 
		out.println(output);
		out.close();
		
	}
	
	public static class point {
		int x, y; 
		public point(int a, int b) {
			x = a; 
			y = b; 
		}
	}
}
