//package goldFeb2020;
import java.util.*;
import java.io.*;
/*
ID: alwang
LANG: JAVA
TASK: help
 */
public class help {
	static int n; 
	static int[] map; //allow us to figure out in O(1) time the number of elements adding a complexity to the query 
	static int[] po2; //precalculate the powers of 2 since there is overlap 
	static int mod = 1000000007; 
	static int[][] ranges; 
	public static void main(String args[]) throws IOException { 
		//input
		//counting problem 
		BufferedReader f = new BufferedReader(new FileReader("help.in")); StringTokenizer input;  
		n = Integer.parseInt(f.readLine()); map = new int[300000]; //extra space sentinel nodes
		po2 = new int[n+2]; ranges = new int[n][2]; //l and r
		for(int i = 0; i < n; i++) {
			input = new StringTokenizer(f.readLine()); 
			int a = Integer.parseInt(input.nextToken()); int b = Integer.parseInt(input.nextToken());
			ranges[i][0] = a; ranges[i][1] = b; 
			map[a] += 1; 
			map[b] -= 1; 
		}
		for(int i = 1; i < 2*n+1; i++) { //range complete 
			map[i] += map[i-1]; 
		}
		po2[0] = 1; 
		for(int i = 1; i < n+2; i++) {
			po2[i] = (2*po2[i-1])%mod; 
		}
		
		//linearity of expectation 
		int ret = 0; 
		for(int i = 0; i < n; i++) {
			ret = (ret + po2[n-1-map[ranges[i][0]-1]])%mod; //looks to see if anyone has an element inside of the range 
		}
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("help.out"))); 
		out.println(ret);
		out.close();
	}
}
