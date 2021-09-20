//package Chapter3_1;
/*
ID: alan.li2
LANG: JAVA
TASK: inflate
 */

import java.io.*;
import java.util.*;

public class inflate2 {
	static int length;
	static int numOfCats; 
	static int[][] cats; 
	static int[] dp; 
	static int highestVal = 0; 
	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("inflate.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		length = Integer.parseInt(input.nextToken());
		numOfCats = Integer.parseInt(input.nextToken());
		cats = new int[numOfCats][2]; // first number is points, then time
		for (int count = 0; count < numOfCats; count++) {
			input = new StringTokenizer(f.readLine());
			String a = input.nextToken();
			String b = input.nextToken();
			cats[count][0] = Integer.parseInt(a);
			cats[count][1] = Integer.parseInt(b);
		}
		dp = new int[length+1]; 
		f.close();
		//dynamic programming algorithm to solve 
		//modified butterfly  
		for(int i = 0; i < length; i++) {
			if(dp[i] != 0 || i==0) {
				for(int j = 0; j < numOfCats; j++) {
					if(cats[j][1] + i <= length && dp[i+cats[j][1]] < cats[j][0]+dp[i]) {
						dp[i+cats[j][1]] = cats[j][0] + dp[i]; 
						if(dp[i+cats[j][1]] > highestVal)
							highestVal = dp[i+cats[j][1]]; 
					}
				}
			}
		}
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
		out.println(highestVal);
		out.close();
	}
}
