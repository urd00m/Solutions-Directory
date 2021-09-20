package Chapter2_3;
/*
ID: alan.li2
LANG: JAVA
TASK: money
 */
import java.util.*;
import java.io.*;

public class money {
	static int v, n; 
	static int[] coins; 
	static long[] sums; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("money.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine());
		v = Integer.parseInt(input.nextToken());
		n = Integer.parseInt(input.nextToken());
		coins = new int[v]; 
		sums = new long[n+1];
		input = new StringTokenizer(f.readLine());
		for(int i = 0; i < v; i++) {
			if(input.hasMoreTokens() == false)
				input = new StringTokenizer(f.readLine());
			coins[i] = Integer.parseInt(input.nextToken());
		}
		f.close();
		//algorithm
		//butterfly, dynamic programming
		sums[0] = 1;
		for(int val : coins) {
			for(int i = 0; i < n; i++) {
				if(i + val < n+1)
					sums[i+val] += sums[i]; 
			}
		}
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
		out.println(sums[n]);
		out.close();
	}
}
