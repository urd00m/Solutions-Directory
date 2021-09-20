package exampleDynamicProgrammingQuestions;

//package janGold2017;
/*
ID: alwang
LANG: JAVA
TASK: hps
 */
import java.io.*;
import java.util.*;

public class hps {
	static int n, k;
	static int[] ns;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("hps.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		n = Integer.parseInt(input.nextToken());
		k = Integer.parseInt(input.nextToken());
		ns = new int[n];
		for (int i = 0; i < n; i++) {
			ns[i] = toNum(f.readLine());
		}
		f.close();

		// algorithm: dp
		int[][][] dp = new int[n + 1][4][k + 2]; // the 0 indices are dummy values
		for (int i = 1; i < 4; i++) {
			dp[1][i][1] = beats(i, ns[0]);
		}

		for (int i = 2; i < n + 1; i++) { // n location
			for (int j = 1; j <= k + 1; j++) { // k location
				for (int K = 1; K < 4; K++) {
					// 4 options don't change, or change from past k values
					// don't change
					dp[i][K][j] = Math.max(dp[i][K][j], dp[i - 1][K][j] + beats(K, ns[i - 1]));
					// changing the one we are using
					for (int K2 = 1; K2 < 4; K2++) {
						dp[i][K][j] = Math.max(dp[i][K][j], dp[i - 1][K2][j - 1] + beats(K, ns[i - 1]));
					}
				}

			}
		}

		// output
		int output = 0;
		for (int i = 1; i <= k + 1; i++) {
			for (int j = 1; j < 4; j++) {
				output = Math.max(output, dp[n][j][i]);
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		out.println(output);
		out.close();
	}

	public static int beats(int a, int b) { // returns true if a beats b
		if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2))
			return 1;
		else
			return 0;
	}

	public static int toNum(String a) {
		if (a.equals("H"))
			return 1;
		else if (a.equals("P"))
			return 2;
		else if (a.equals("S"))
			return 3;
		else
			return -1;
	}
}
