package a108;
/*
ID: urd00m
LANG: JAVA
TASK: uva10801
 */

import java.io.*;
import java.util.*;

public class uva10801 {
	static int n, k;
	static int[] time;
	static ArrayList<pair>[] graph;

	public static void main(String args[]) throws IOException, InterruptedException {
		// input
		Thread.sleep(3000);
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		while (f.ready() == true) { // SSSP
			input = new StringTokenizer(f.readLine());
			n = Integer.parseInt(input.nextToken());
			k = Integer.parseInt(input.nextToken());
			time = new int[n];
			input = new StringTokenizer(f.readLine());
			for (int i = 0; i < n; i++) {
				time[i] = Integer.parseInt(input.nextToken());
			}
			graph = new ArrayList[101];
			for (int i = 0; i < 101; i++)
				graph[i] = new ArrayList<pair>();
			for (int i = 0; i < n; i++) {
				input = new StringTokenizer(f.readLine());
				ArrayList<Integer> store = new ArrayList<Integer>();
				while (input.hasMoreTokens() == true)
					store.add(Integer.parseInt(input.nextToken()));
				for (int j = 0; j < store.size(); j++) {
					for (int k = j + 1; k < store.size(); k++) {
						int a = store.get(j);
						int b = store.get(k);
						graph[a].add(new pair(b, Math.abs(a - b) * time[i], i));
						graph[b].add(new pair(a, Math.abs(a - b) * time[i], i));
					}
				}
			}

			// runnning SSSP
			int[] dist = dpq(graph, 0, 101);

			// output
			if (dist[k] != -1)
				System.out.println(dist[k]);
			else
				System.out.println("IMPOSSIBLE");
		}
	}

	public static int[] dpq(ArrayList<pair>[] graph, int src, int n) {
		int[] dist = new int[n];
		Arrays.fill(dist, -1);
		boolean[] visited = new boolean[n];
		int[] elevatorType = new int[n];
		Arrays.fill(elevatorType, -1);
		PriorityQueue<pair> next = new PriorityQueue<pair>(n, new pair());
		next.add(new pair(src, 0, -1));
		dist[src] = 0;
		while (next.isEmpty() == false) {
			pair curNode = next.remove();
			visited[curNode.destination] = true;
			for (pair store : graph[curNode.destination]) {
				int addon = 0;
				if (elevatorType[curNode.destination] != -1 && elevatorType[curNode.destination] != store.type)
					addon = 60;
				if (visited[store.destination] == false && (dist[store.destination] == -1
						|| dist[store.destination] > dist[curNode.destination] + store.weight + addon)) {
					dist[store.destination] = dist[curNode.destination] + store.weight + addon;
					next.add(new pair(store.destination, dist[store.destination], store.type));
					elevatorType[store.destination] = store.type;
				}
			}
		}
		return dist;
	}

	public static class pair implements Comparator<pair> {
		int destination;
		int weight;
		int type;

		public pair() {
		}

		public pair(int a, int b, int c) {
			destination = a;
			weight = b;
			type = c;
		}

		@Override
		public int compare(pair o1, pair o2) {
			return o1.weight - o2.weight;
		}
	}
}
