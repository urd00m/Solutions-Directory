//package goldJan2020;

/*
ID: alwang
LANG: JAVA
TASK: threesum
 */
import java.io.*; 
import java.util.*;
public class threesum {
	static int n, q;
	static int[] a; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("threesum.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); q = Integer.parseInt(input.nextToken()); 
		a = new int[n]; 
		input = new StringTokenizer(f.readLine()); 
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(input.nextToken());
		long[][] dp = new long[n][n]; 
		int[] temp = new int[2000001];
		for(int i = n-1; i >=0; i--) {
			for(int j = i+1; j < n; j++) {
				int idx = 1000000-a[i]-a[j]; 
				if(idx >= 0 && idx <= 2000000) dp[i][j] = temp[idx]; 
				temp[1000000+a[j]]++;
			}
			for(int j = i+1; j<n; j++) {
				temp[1000000+a[j]]--; //reset 
			}
		}
		for(int i = n-1; i >= 0; i--) {
			for(int j = i+1; j < n; j++) {
				dp[i][j] += dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1]; 
			}
		}
		//algorithm: dp in a way
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out"))); 
		for(int i = 0; i < q; i++) {
			input = new StringTokenizer(f.readLine()); 
			out.println( (dp[Integer.parseInt(input.nextToken())-1][Integer.parseInt(input.nextToken())-1]) );
		}
		f.close();
		out.close();
		
	}
}
