//package DecGold2018;
/*
ID: alwang
LANG: JAVA
TASK: teamwork
 */

import java.util.*;
import java.io.*;

public class teamwork {
	static int n, k; 
	static int[] skills; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("teamwork.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); 
		k = Integer.parseInt(input.nextToken()); 
		skills = new int[n]; 
		for(int i = 0; i < n; i++) {
			skills[i] = Integer.parseInt(f.readLine()); 
		}
		f.close();
		
		//algorithm dp 
		int[] dp = new int[n]; 
		dp[0] = skills[0]; 
		for(int i = 1; i < n; i++) {
			int max = skills[i]; 
			for(int j = i; j >= 0 && i-j+1 <= k; j--) {
				max = Math.max(max, skills[j]); 
				if(j == 0) dp[i] = Math.max(dp[i], max*(i-j+1)); 
				else dp[i] = Math.max(dp[i], dp[j-1]+max*(i-j+1)); 
			}
		}
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teamwork.out"))); 
		out.println(dp[n-1]); 
		out.close();
	}
}
