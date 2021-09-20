//package a900_1000;
/*
ID: urd00m
LANG: JAVA
TASK: uva00907
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n; 
	static int k; 
	static int[] edges; 
	static int[][] memo;
	public static void main(String args[]) throws IOException, InterruptedException {
		//input;
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		while(f.ready()) {
			input = new StringTokenizer(f.readLine()); 
			n = Integer.parseInt(input.nextToken()); int k = Integer.parseInt(input.nextToken());
			edges = new int[n+1]; //n+2 nodes start + end, + (n)  nodes  
			memo = new int[n+2][k+2]; //at most k+1 days, once it reaches k it must get to the end  0 is never used
			for(int i = 0; i < n+1; i++) {
				edges[i] = Integer.parseInt(f.readLine()); 
			}
			
			//top down DP with memo 
			int ret = dp(0, k+1, 0);

			//output
			System.out.println(ret);
		}
	}
	
	//states: current campsite (0 is start, and n+1 is the end) 
	//states: daysLeft, the nights+1 since we can travel for k+1 days 
	public static int dp(int campsite, int daysLeft, int distance) {
		if(daysLeft == 0 && campsite != n+1) { //out of time and not at the end
			return Integer.MAX_VALUE; //return failure 
		}
		else if(daysLeft == 0 && campsite == n+1) { //we made it
			return distance; //return finish 
		}
		else if(memo[campsite][daysLeft] != 0) return memo[campsite][daysLeft]; //memoization
		else {
			int sum = 0; 
			int tempMin = Integer.MAX_VALUE; 
			for(int i = campsite; i < n+1; i++) {
				sum += edges[i]; //the distance we are traveling 
				if(sum < tempMin) tempMin = Math.min(tempMin, Math.max(dp(i+1, daysLeft-1, sum), sum)); //if it has the potential to be less then explore //
			}
			memo[campsite][daysLeft] = tempMin; 
			return tempMin; 
		}
		
	}
}
