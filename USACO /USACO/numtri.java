package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: numtri
 */
import java.util.*;
import java.io.*;
public class numtri {
	static int answer = 0;
	static int n; 
	public static void main(String args[]) throws IOException {
		 //recursively output the sum
		BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
		StringTokenizer g = new StringTokenizer(f.readLine());
		n = Integer.parseInt(g.nextToken());
		int[][] tree = new int[n][n];
		//take in input 
		for(int i = 0; i < n; i++) {
			StringTokenizer in = new StringTokenizer(f.readLine());
			for(int j = 0; j < i+1; j++)
				tree[i][j] = Integer.parseInt(in.nextToken());
		}
		//recursively find the max
		find(tree);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		out.println(answer);
		out.close();
	}
	
	public static void find(int[][] tree) {
		//go backwards
		for(int i = n-2; i >= 0; i--) {
			for(int j = 0; j <= i; j++ ) {
				tree[i][j] += Math.max(tree[i+1][j], tree[i+1][j+1]);
			}
			
		}
		answer = tree[0][0];
	}
}
