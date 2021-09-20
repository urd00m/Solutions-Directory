//package goldDec2019;

import java.util.*;
import java.io.*;

public class cowmbat {
	static final int MN = 100005;
	static final int MA = 26;
	static int n, m, k;
	static String s;
	static int[][] d = new int[MA][MA];
	static int[][] cst = new int[MN][MA];
	static int[][] ps = new int[MN][MA];
	static int[][] dp = new int[MN][MA];
	static int[] mn = new int[MN];

	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowmbat.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		n = Integer.parseInt(input.nextToken());
		m = Integer.parseInt(input.nextToken());
		k = Integer.parseInt(input.nextToken());
		s = f.readLine();
		for (int i = 0; i < m; i++) {
			input = new StringTokenizer(f.readLine());
			for (int j = 0; j < m; j++)
				d[i][j] = Integer.parseInt(input.nextToken());
		}
		for (int c = 0; c < m; c++)
			for (int b = 0; b < m; b++)
				for (int a = 0; a < m; a++)
					d[a][b] = Math.min(d[a][b], d[a][c] + d[c][b]);

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				cst[i][j] = d[s.charAt(i - 1) - 'a'][j];
				ps[i][j] = ps[i - 1][j] + cst[i][j];
			}
		}
		f.close();
		
		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], 999999999);
		Arrays.fill(mn, 999999999);
		mn[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + cst[i][j]);
				if (i >= k)
					dp[i][j] = Math.min(dp[i][j], ps[i][j] - ps[i - k][j] + mn[i - k]);
				mn[i] = Math.min(mn[i], dp[i][j]);
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowmbat.out")));
		out.println(mn[n]);
		out.close();
	}
}
