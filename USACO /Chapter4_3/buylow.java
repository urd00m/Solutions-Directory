//package Chapter4_3;
/*
ID: alan.li2
LANG: JAVA
TASK: buylow
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class buylow {
	static int n; 
	static int[] prices; 
	static int[] maxLen;
	static BigInteger[] distNums; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("buylow.in")); 
		n = Integer.parseInt(f.readLine()); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		prices = new int[n]; 
		maxLen = new int[n]; 
		distNums = new BigInteger[n]; 
		for(int i = 0; i < n; i++) {
			if(input.hasMoreElements() == false) input = new StringTokenizer(f.readLine()); 
			prices[i] = Integer.parseInt(input.nextToken());
			distNums[i] = new BigInteger("0");
		}
		f.close();
		
		//algorithm: DP 
		int overallMax = 0; 
		for(int i = 0; i < n; i++) {
			int max = 1; 
			for(int j = i-1; j >= 0; j--) { //finding the maximum length 
				if(prices[j] > prices[i] && maxLen[j]+1 > max) {
					max = maxLen[j]+1; 
				}
			}
			if(max == 1) distNums[i] = new BigInteger("1");
			else {
				int prev = -1; 
				for(int j = i-1; j >= 0; j--) {
					if(prices[j] > prices[i] && maxLen[j]+1 == max && prices[j] != prev) {
						distNums[i] = distNums[i].add(distNums[j]); 
						prev = prices[j]; 
					}
				}
			}
			maxLen[i] = max; 
			if(max > overallMax) overallMax = max; 
		}
		BigInteger distOutput = new BigInteger("0"); 
		int prev = -1; 
		for(int i = n-1; i >= 0; i--) {
			if(maxLen[i] == overallMax && prev != prices[i]) {
				distOutput = distOutput.add(distNums[i]); 
				prev = prices[i];
			}
		}
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buylow.out")));
		out.println(overallMax + " " + distOutput); 
		out.close();
	}
}
