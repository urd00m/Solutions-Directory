//package goldJan2020;
/*
ID: alwang
LANG: JAVA
TASK: time
 */
import java.io.*;
import java.util.*;

public class time {
	static int n, m, c; 
	static int[] cityCost; 
	static ArrayList<Integer>[] graph; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("time.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); m = Integer.parseInt(input.nextToken()); c = Integer.parseInt(input.nextToken()); 
		cityCost = new int[n]; 
		input = new StringTokenizer(f.readLine()); 
		for(int i = 0; i < n; i++) {
			cityCost[i] = Integer.parseInt(input.nextToken()); 
		}
		graph = new ArrayList[n]; 
		for(int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>(); 
		for(int i = 0; i < m; i++) {
			input = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(input.nextToken())-1; int b = Integer.parseInt(input.nextToken())-1; 
			graph[a].add(b); 
		}
		f.close();
		
		//algorithm dp
		int[][] dp = new int[n][501]; 
		for(int i = 0; i < 500; i++) { //the days 
			for(int j = 0; j < n; j++) { //the nodes
				if(dp[j][i] != 0 || (j == 0 && i == 0))
					for(int item : graph[j]) {
						//System.out.println(j + " " + item + " " + (dp[j][i]+cityCost[j]));
						dp[item][i+1] = Math.max(dp[item][i+1], dp[j][i]+cityCost[item]); 
					}
			}
		}
		
		int output = 0; 
		for(int i = 0; i < 500; i++) {
			output = Math.max(output, dp[0][i]-c*i*i); 
		}
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("time.out"))); 
		out.println(output);
		out.close();
	}
}
