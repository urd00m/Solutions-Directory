//package a200_300;

/*
ID: urd00m
LANG: JAVA
TASK: uva216
 */
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
	static int number = 1;
	static int n;
	static int[][] computers;
	static double[][] graph;
	static double[][] dp;
	static int[][] child;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		while (true) {
			input = new StringTokenizer(f.readLine());
			n = Integer.parseInt(input.nextToken());
			if (n == 0)
				break;

			computers = new int[n][2];
			for (int i = 0; i < n; i++) {
				input = new StringTokenizer(f.readLine());
				int a = Integer.parseInt(input.nextToken());
				int b = Integer.parseInt(input.nextToken());
				computers[i][0] = a;
				computers[i][1] = b;
			}

			graph = new double[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = distance(i, j);
				}
			}

			// running dp
			double min = 999999;
			int minPos = -1;
			int[][] bestChild = null;
			dp = new double[(1 << n) - 1][n];
			for (int i = 0; i < n; i++) {
				child = new int[(1 << n)][n];
				for(int a = 0; a < (1 << n); a++) {
					for(int b = 0; b < n; b++) child[a][b] = -1; 
				}
				double temp = recur(0 | (1 << i), i);
				if (temp < min) {
					min = temp;
					minPos = i;
					bestChild = child;
				}
			}

			// output
			System.out.println("**********************************************************");
			System.out.println("Network #" + number++);

			DecimalFormat df = new DecimalFormat("0.00");
			int cur = minPos;
			int bitmask = (1 << minPos); 
			while (bestChild[bitmask][cur] != -1) {
				int next = bestChild[bitmask][cur];
				double pr = Math.round(graph[cur][next]*100.0)/100.0; 
				System.out.println("Cable requirement to connect (" + computers[cur][0] + "," + computers[cur][1]
						+ ") to (" + computers[next][0] + "," + computers[next][1] + ") is "
						+ df.format(pr) + " feet.");
				cur = next; 
				bitmask |= (1 << next); 
			}
			min = Math.round(min*100.0)/100.0; 
			System.out.println("Number of feet of cable required is " + df.format(min) + ".");

		}
	}

	public static double recur(int bitmask, int pos) {
		if ((bitmask == (1 << n) - 1))
			return 0.0;
		else if (dp[bitmask][pos] > 0)
			return dp[bitmask][pos];
		else {
			double min = 999999;
			int minLoc = -1;
			for (int i = 0; i < n; i++) {
				if ((bitmask & (1 << i)) == 0 && i != pos) {
					double temp = graph[pos][i] + recur(bitmask | (1 << i), i);
					if (min > temp) {
						min = temp;
						minLoc = i;
					}
				}
			}
			child[bitmask][pos] = minLoc;
			return min;
		}
	}

	// return distance between two computers rounded;
	public static double distance(int a, int b) {
		if (a == b)
			return 0.0;
		double ret = Math.sqrt(
				Math.pow(computers[a][0] - computers[b][0], 2) + Math.pow(computers[a][1] - computers[b][1], 2)) + 16.0;
		ret = Math.round(ret * 10000.0) / 10000.0;
		return ret;
	}
}
