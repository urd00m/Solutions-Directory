package a100_200;

/*
ID: urd00m
LANG: JAVA
TASK: uva00108
 */
import java.io.*;
import java.util.*;

public class uva00108 {
	static int n;
	static int[][] A;

	public static void main(String args[]) throws IOException, InterruptedException {
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		Thread.sleep(3000);
		while (f.ready() == true) {
			n = Integer.parseInt(f.readLine());
			StringTokenizer input = new StringTokenizer("");
			A = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					while (input.hasMoreElements() == false)
						input = new StringTokenizer(f.readLine());
					A[i][j] = Integer.parseInt(input.nextToken());
					if (j > 0)
						A[i][j] += A[i][j - 1];
				}
			}
			// kadane's algorithm
			int max = -999999999;
			for (int l = 0; l < n; l++) {
				for (int r = l; r < n; r++) {
					int sum = 0;
					for (int row = 0; row < n; row++) {
						if (l > 0)
							sum += A[row][r] - A[row][l - 1];
						else
							sum += A[row][r];
						if (sum > max) {
							max = sum;
						}
						if (sum < 0)
							sum = 0;
					}
				}
			}
			System.out.println(max);
		}
	}
}
