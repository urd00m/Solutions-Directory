
//package Chapter3_3;
/*
ID: alan.li2
LANG: JAVA
TASK: game1
 */
import java.io.*;
import java.util.*;
import static java.lang.Math.*;
/*
	I took this from https://github.com/TomConerly/Competition-Programming/blob/master/USACO/Chapter3/game1.java
	I didn't know how to start, so i needed to find some code to analyze to gain an understanding of how to solve this problem
 */
public class game1 {
	public static void main(String[] args) throws IOException { 
		//input 
		long start = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new FileReader("game1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("game1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		N = Integer.valueOf(st.nextToken());
		board = new int[N];
		for (int i = 0; i < N; i++) {
			if (!st.hasMoreTokens())
				st = new StringTokenizer(f.readLine());
			board[i] = Integer.valueOf(st.nextToken());
		}
		f.close();
		
		//init 
		dp = new int[N][N]; //timesaver, so you don't go looking recursively for a board that has already been found 
		for (int i = 0; i < N; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		int total = 0;
		for (int i = 0; i < N; i++)
			total += board[i];

		
		//algorithm, look a head, with optimization array 
		int p1 = recur(0, 0); // best score for player 1
		//this code didn't make much sense to me, so i decided to modify his code to fit the idea of an algorithm i Had 
		/*
		int t = (total - p1) / 2; 
		if (p1 > 0)
			out.println(max(t, total - t) + " " + min(t, total - t));
		else
			out.println(min(t, total - t) + " " + max(t, total - t));
		*/
		out.println(p1 + " " + (total-p1)); //the final results 
		out.close();
		System.out.println((System.currentTimeMillis() - start));
		System.exit(0);
	}

	public static int recur(int l, int r) {
		if (l + r == N)
			return 0;
		if (dp[l][r] != Integer.MAX_VALUE)
			return dp[l][r];

		int score = 0;
		// p1 to go
		if ((l + r) % 2 == 0) {
			score = max(board[l] + recur(l + 1, r), board[N - r - 1] + recur(l, r + 1)); //player one gets to pick 
		} else { //if it isn't your turn you don't get the points, the reason it is min is because player two gets the better option 
			score = min(recur(l + 1, r), recur(l, r + 1)); //if you don't get to pick, the original had the points of that position subtracted for some reason, that didn't make sense so i removed it
		}
		dp[l][r] = score;
		return score;
	}

	static int[][] dp;
	static int N;
	static int[] board;
}
