//package a115;

/*
ID: urd00m
LANG: JAVA
TASK: uva11566
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, x, t, k;
	static int[] mean;
	static int[] cost;
	static int[][][] dp; // id, remW, dishes left

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		input = new StringTokenizer(f.readLine());
		n = Integer.parseInt(input.nextToken());
		x = Integer.parseInt(input.nextToken());
		t = Integer.parseInt(input.nextToken());
		k = Integer.parseInt(input.nextToken());
		while (n != 0) {
			// remaining value is (n+1)*(x-t)
			mean = new int[k];
			cost = new int[k];
			for (int i = 0; i < k; i++) {
				while (input.hasMoreTokens() == false)
					input = new StringTokenizer(f.readLine());
				cost[i] = Integer.parseInt(input.nextToken()); // the cost of dim sum plus service charge
				int sum = 0;
				for (int j = 0; j < n + 1; j++) {
					sum += Double.parseDouble(input.nextToken());
				}
				mean[i] = sum;
			}

			dp = new int[k][(int) ((n + 1) * (x / 1.1 - t + 1e-6)) + 1][2 * n + 3]; // cost * 100
			int best = recur(0, (int) ((n + 1) * (x / 1.1 - t + 1e-6)), 0);
			System.out.printf("%.2f\n", best / (double) (n + 1));

			while (input.hasMoreTokens() == false)
				input = new StringTokenizer(f.readLine());
			n = Integer.parseInt(input.nextToken());
			x = Integer.parseInt(input.nextToken());
			t = Integer.parseInt(input.nextToken());
			k = Integer.parseInt(input.nextToken());
		}
	}

	public static int recur(int id, int cashLeft, int dishes) {
		if (cashLeft < 0 || dishes > 2 * n + 2)
			return -1000;
		else if (dishes == 2 * n + 2)
			return 0;
		else if (cashLeft == 0)
			return 0;
		else if (id == k)
			return 0;
		else if (dp[id][(cashLeft)][dishes] > 0)
			return dp[id][(cashLeft)][dishes];
		else {
			return dp[id][(cashLeft)][dishes] = Math.max(recur(id + 1, cashLeft, dishes),
					Math.max(mean[id] + recur(id + 1, cashLeft - cost[id], dishes + 1),
							mean[id] * 2 + recur(id + 1, cashLeft - 2 * cost[id], dishes + 2)));
		}
	}
}
