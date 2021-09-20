//package febGold2019;

/*
ID: alwang
LANG: JAVA
TASK: paintbarn
 */
import java.io.*;
import java.util.*;

public class paintbarn {
	static int n, k;
	static int currAmt = 0;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		int[][] dp = new int[10][10];
		int[][] actual = new int[10][10];
		n = Integer.parseInt(input.nextToken());
		k = Integer.parseInt(input.nextToken());
		for (int i = 0; i < n; i++) {
			input = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(input.nextToken());
			int b = Integer.parseInt(input.nextToken());
			int c = Integer.parseInt(input.nextToken());
			int d = Integer.parseInt(input.nextToken());
			dp[a][b]++;
			dp[a][d]--;
			dp[c][d]++;
			dp[c][b]--;
		}
		// algorithm
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i != 0)
					dp[i][j] += dp[i - 1][j];
				if (j != 0)
					dp[i][j] += dp[i][j - 1];
				if (i != 0 && j != 0)
					dp[i][j] -= dp[i - 1][j - 1];
				if (dp[i][j] == k - 1)
					actual[i + 1][j + 1] = 1;
				if (dp[i][j] == k) {
					currAmt++;
					actual[i + 1][j + 1] = -1;
				}
			}
		}
		for (int i = 9; i >= 0; i--) {
			for (int item : actual[i]) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				actual[i][j] += actual[i - 1][j];
				actual[i][j] += actual[i][j - 1];
				actual[i][j] -= actual[i - 1][j - 1];
			}
		}
		System.out.println();
		for (int i = 9; i >= 0; i--) {
			for (int item : dp[i]) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 9; i >= 0; i--) {
			for (int item : actual[i]) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		// output
	}
}
