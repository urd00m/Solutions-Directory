
//package goldDec2019;
/*
ID: alwang
LANG: JAVA
TASK: cowmbat
 */
import java.io.*;
import java.util.*;

public class cowmbat {
	static int n, m, k;
	static String s;
	static int[][] graph;
	static int[][] minCost;
	static int[][] ps;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("cowmbat.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		n = Integer.parseInt(input.nextToken());
		m = Integer.parseInt(input.nextToken());
		k = Integer.parseInt(input.nextToken());
		s = f.readLine();
		init();

		// input cont
		for (int i = 0; i < m; i++) {
			input = new StringTokenizer(f.readLine());
			for (int j = 0; j < m; j++)
				graph[i][j] = Integer.parseInt(input.nextToken());
		}
		f.close();

		// algorith: dp
		// floyd-warshall
		for (int c = 0; c < m; c++)
			for (int b = 0; b < m; b++)
				for (int a = 0; a < m; a++)
					graph[a][b] = Math.min(graph[a][b], graph[a][c] + graph[c][b]);
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				minCost[i][j] = graph[s.charAt(i - 1) - 'a'][j];
				ps[i][j] = ps[i - 1][j] + minCost[i][j];
			}
		}

		// dp
		int[][] dp = new int[n + 1][m];
		int[] mn = new int[n + 1];
		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], 1061109567);
		Arrays.fill(mn, 1061109567);
		mn[0] = 0;
		
		//if you ensure that at the start you have a streak it is guarenteed to continue on throughout the rest of dp
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + minCost[i][j]);
				if (i >= k)
					dp[i][j] = Math.min(dp[i][j], ps[i][j] - ps[i - k][j] + mn[i - k]);
				mn[i] = Math.min(mn[i], dp[i][j]);
			}
		}

		/*
		for (int[] ary : dp) {
			for (int item : ary)
				System.out.print(item + " ");
			System.out.println();
		}
		System.out.println();
		for (int[] ary : minCost) {
			for (int item : ary)
				System.out.print(item + " ");
			System.out.println();
		}
		System.out.println();
		for (int[] ary : ps) {
			for (int item : ary)
				System.out.print(item + " ");
			System.out.println();
		}
*/

		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowmbat.out")));
		out.println(mn[n]);
		out.close();
	}

	public static void init() {
		graph = new int[m][m];
		minCost = new int[n + 1][m];
		ps = new int[n + 1][m];
	}
}
