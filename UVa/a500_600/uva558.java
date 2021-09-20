//package a500_600;

/*
ID: urd00m
LANG: JAVA
TASK: uva00558
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static ArrayList<pair>[] graph;
	static int t;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		t = Integer.parseInt(f.readLine());
		for (int caseNumber = 0; caseNumber < t; caseNumber++) {
			input = new StringTokenizer(f.readLine());
			n = Integer.parseInt(input.nextToken());
			int m = Integer.parseInt(input.nextToken());
			graph = new ArrayList[n];
			for (int i = 0; i < n; i++)
				graph[i] = new ArrayList<pair>();
			for (int i = 0; i < m; i++) {
				input = new StringTokenizer(f.readLine());
				graph[Integer.parseInt(input.nextToken())]
						.add(new pair(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken())));
			}
			if (negativeCycleCheck(0) == true)
				System.out.println("possible");
			else
				System.out.println("not possible");
		}
	}

	public static int[] bellmanF(int src) {
		int[] dist = new int[n];
		Arrays.fill(dist, 1000000000);
		dist[src] = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int u = 0; u < n; u++) {
				for (int j = 0; j < graph[u].size(); j++) {
					pair cur = graph[u].get(j);
					dist[cur.first] = Math.min(dist[cur.first], cur.second + dist[u]);
				}
			}
		}
		return dist;
	}

	public static boolean negativeCycleCheck(int src) {
		int[] dist = bellmanF(src);
		boolean negativeCycle = false;
		for (int u = 0; u < n; u++) {
			for (int j = 0; j < graph[u].size(); j++) {
				pair cur = graph[u].get(j);
				if (cur.second + dist[u] < dist[cur.first]) {
					negativeCycle = true;
					break;
				}
			}
			if (negativeCycle == true)
				break;
		}
		return negativeCycle;
	}

	public static class pair {
		int first, second;

		public pair(int a, int b) {
			first = a;
			second = b;
		}
	}
}
