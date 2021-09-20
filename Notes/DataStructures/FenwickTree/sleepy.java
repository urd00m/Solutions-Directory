package FenwickTree;
//package JanGold2019;
/*
ID: alwang
LANG: JAVA
TASK: sleepy
 */

import java.util.*;
import java.io.*;

public class sleepy {
	static int n; 
	static int[] cows; 
	static int[] tree; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("sleepy.in"));
		n = Integer.parseInt(f.readLine()); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		cows = new int[n];
		tree = new int[n+1]; 
		for(int i = 0; i < n; i++) {
			cows[i] = Integer.parseInt(input.nextToken()); 
		}
		f.close();
		
		//algorithm
		//ad hoc 
		int i = n-1; 
		while(i > 0 && cows[i-1] < cows[i]) {
			i--; 
		}
		for(int j = i; j < n; j++) {
			update(cows[j]); 
		}
		StringBuilder store = new StringBuilder(); 
		for(int j = 0; j < i; j++) {
			store.append((i-j-1)+sum(cows[j]));
			if(i-j != 1) { //not the last one 
				store.append(" "); 
			}
			update(cows[j]); 
		}
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out"))); 
		out.println(i);
		out.println(store.toString());
		out.close();
	}
	
	public static void update(int cur) {
		while(cur < n+1) {
			tree[cur]++; 
			cur += (cur)&(-cur); 
		}
	}
	public static int sum(int cur) {
		int sum = 0; 
		while(cur > 0) {
			sum += tree[cur]; 
			cur -= (cur)&(-cur); 
		}
		return sum; 
	}
}
