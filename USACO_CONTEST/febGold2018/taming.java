//package febGold2018;
/*
ID: alwang
LAnG: JAVA
TASK: taming
 */
import java.io.*;
import java.util.*;

public class taming {
	static int n; 
	static int[] log; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("taming.in")); 
		n = Integer.parseInt(f.readLine()); 
		log = new int[n];
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		for(int i = 0; i < n; i++) log[i] = Integer.parseInt(input.nextToken()); 
		f.close();

		int[][][] dp = new int[n+1][n+1][n+1];
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < n+1; j++) {
				for(int k = 0; k < n+1; k++) {
					dp[i][j][k] = 99999999; 
				}
			}
		}
		
		//algorithm: dp
		if(log[0] == 0) dp[0][0][1] = 0;
		else dp[0][0][1] = 1; 
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=i;j++)
				for(int k=1;k<=i+1;k++)
				{
					if(j < i) 
						dp[i][j][k] = dp[i-1][j][k];
					else
						for(int j1=0;j1<i;j1++)
							dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][j1][k-1]);
					if(log[i] != i-j) 
						dp[i][j][k]++;
					//System.out.println(i + " " + j + " " + k + " " + dp[i][j][k]);
				}
		}
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
		for(int k = 1; k <= n; k++) {
			int output = Integer.MAX_VALUE;
			for(int j = 0; j <= n; j++) {
				output = Math.min(output, dp[n-1][j][k]); 
			}
			out.println(output); 
		}
		out.close();
	}
}
