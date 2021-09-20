package a119;
/*
ID: urd00m
LANG: JAVA
TASK: uva11957
 */
import java.io.*;
import java.util.*;

public class uva11957 {
	static int t; 
	static int n; 
	static int mod = 1000007; 
	static int[][] dp; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); 
		t = Integer.parseInt(f.readLine()); 
		for(int caseNumber = 1; caseNumber < t+1; caseNumber++) {
			n = Integer.parseInt(f.readLine()); 
			dp = new int[n][n]; int[] startPos = new int[2]; //row column 
			for(int i = n-1; i >= 0; i--) {
				String cur = f.readLine(); 
				for(int j = 0; j < n; j++) {
					dp[i][j] = (cur.charAt(j)=='W') ? 1 : (cur.charAt(j)=='B') ? -1 : 0;   //1 is white piece, -1 is black piece, 0 is empty square 
					if(cur.charAt(j) == 'W') {
						startPos[0] = i; startPos[1] = j; 
					}
				}
			}
			
			//dp: bottom up 
			for(int i = startPos[0]; i < n-1; i++) {
				for(int j = 0; j < n; j++) {
					if(dp[i][j] > 0) {
						if(j > 0) {
							if(dp[i+1][j-1] >= 0) { //checking top left 1 
								dp[i+1][j-1] = (dp[i+1][j-1]+dp[i][j])%mod; 
							}
							else if(i < n-2 && j > 1 && dp[i+2][j-2] >= 0) { //the square is marked by a black square 
								dp[i+2][j-2] = (dp[i+2][j-2]+dp[i][j])%mod; 
							}
						}
						if(j < n-1) {
							if(dp[i+1][j+1] >= 0) { //checking top right 1 
								dp[i+1][j+1] = (dp[i+1][j+1]+dp[i][j])%mod; 
							}
							else if(i < n-2 && j < n-2 && dp[i+2][j+2] >= 0) { //the square is marked by a black square 
								dp[i+2][j+2] = (dp[i+2][j+2]+dp[i][j])%mod; 
							}
						}
					}
				}
			}
			
			//output 
			int ret = 0; 
			for(int j = 0; j < n; j++) {
				if(dp[n-1][j] > 0) ret = (ret + dp[n-1][j])%mod; 
			}
			System.out.println("Case " + caseNumber + ": " + ret);
		}
	}
}
