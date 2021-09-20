package exampleDynamicProgrammingQuestions;
//package jan2018gold;
/*
ID: alwang
LANG: JAVA 
TASK: spainting
 */
import java.io.*;
import java.util.*;

public class spainting {
	static int n, m, k; 
	static int mod = 1000000007; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("spainting.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); m = Integer.parseInt(input.nextToken());  k = Integer.parseInt(input.nextToken());
		f.close();
		
		//algorithm
		long[] dp = new long[n+1];
		dp[0] = 0; 
		for(int i = 1; i < k; i++) {
			dp[i] = (m*(long)dp[i-1]+m)%mod; 
		}
		for(int i = k; i < n+1; i++) {
			dp[i] = ((m*(long)dp[i-1])%mod)+mod-(((m-1)*(long)dp[i-k])%mod);
		}
		long output = 1; 
		for(int i = 0; i < n; i++) {
			output = (long)(output*m)%mod; 
		}
		
		output = (output + mod - ((long)dp[n]-dp[n-1])%mod)%mod; 
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("spainting.out"))); 
		out.println(output);
		out.close();
	}
}
