
//package JanGold2019;
/*
ID: alwang
LANG: JAVA
TASK: poetry
 */
import java.util.*;
import java.io.*;

public class poetry {
	static int n, m, k;
	static int[] syllables, rClass;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("poetry.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		n = Integer.parseInt(input.nextToken());
		m = Integer.parseInt(input.nextToken());
		k = Integer.parseInt(input.nextToken());
		syllables = new int[n];
		rClass = new int[n];
		for (int i = 0; i < n; i++) {
			input = new StringTokenizer(f.readLine());
			syllables[i] = Integer.parseInt(input.nextToken());
			rClass[i] = Integer.parseInt(input.nextToken());
		}
		int[] totRhymes = new int[26];
		for (int i = 0; i < m; i++) {
			totRhymes[f.readLine().charAt(0) - 65]++;
		}
		f.close();

		// algorithm dp
		long[] endsWithRhymeClass = new long[n];
		long[] dp = new long[k];
		dp[0] = 1;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				if (syllables[j] + i == k)
					endsWithRhymeClass[rClass[j]
							- 1] = (int) ((endsWithRhymeClass[rClass[j] - 1] + dp[i]) % 1000000007);
				if (syllables[j] + i < k)
					dp[syllables[j] + i] = (dp[syllables[j] + i] + dp[i]) % 1000000007;
			}
		}
		//for(long item : endsWithRhymeClass) System.out.println(item);

		long finalTotal = 1;
		for (int i = 0; i < 26; i++) {
			long store = 0;
			if (totRhymes[i] != 0) {
				for (int j = 0; j < n; j++) {
					store = (int) ((store + exp(endsWithRhymeClass[j], totRhymes[i], 1000000007)) % 1000000007);
				}
				finalTotal = (finalTotal * store) % 1000000007;
			}
		}
		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("poetry.out")));
		out.println(finalTotal);
		out.close();
	}

	public static long exp(long base, int power, int MOD) {
		if (power == 0)
			return 1;
		if (power == 1)
			return (base + MOD) % MOD;
		long ans = exp(base, power / 2, MOD);
		ans = (ans * ans + MOD) % MOD;
		if (power % 2 == 1)
			ans = (ans * base + MOD) % MOD;
		return (ans + MOD) % MOD;
	}
}
