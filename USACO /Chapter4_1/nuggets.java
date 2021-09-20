//package Chapter4_1;
/*
ID: alan.li2
LANG: JAVA
TASK: nuggets
 */
import java.io.*;
import java.util.*;

public class nuggets {
	static int n; 
	static int[] packages; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("nuggets.in")); 
		n = Integer.parseInt(f.readLine()); 
		packages = new int[n]; 
		boolean odd = false; 
		for(int i = 0; i < n; i++) {
			packages[i] = Integer.parseInt(f.readLine()); 
			if(packages[i]%2 == 1) odd = true; 
		}
		f.close();
		
		//algorithm DP to find the greatest number that they can't create, if you don't have an odd number print 0
		int[] dp = new int[1000000];
		int max = 0; 
		dp[0] = 1; 
		for(int i = 0; i < 1000000; i++) {
			if(dp[i] == 0) {
				max = i; 
			}
			else {
				for(int item : packages) {
					if(i+item < 1000000) dp[i+item] = 1; 
				}
			}
		}
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nuggets.out"))); 
		if(odd == true) out.println(max);
		else out.println(0);
		out.close();
	}
}
