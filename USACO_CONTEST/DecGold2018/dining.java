//package DecGold2018;

/*
ID: alan.li2
LANG: JAVA
TASK: dining
 */
import java.io.*;
import java.util.*;

public class dining {
	static int N, M, K;
	static HashMap<String, Integer> pastures;
	static pair[] food;
	static ArrayList<Integer>[] connections;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("dining.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		N = Integer.parseInt(input.nextToken());
		M = Integer.parseInt(input.nextToken());
		K = Integer.parseInt(input.nextToken());
		pastures = new HashMap<String, Integer>();
		connections = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			connections[i] = new ArrayList<Integer>();
		}
		food = new pair[K];
		for (int i = 0; i < M; i++) {
			input = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(input.nextToken()) - 1;
			int b = Integer.parseInt(input.nextToken()) - 1;
			int distance = Integer.parseInt(input.nextToken());
			pastures.put(a + " " + b, distance);
			pastures.put(b + " " + a, distance);
			connections[a].add(b);
			connections[b].add(a);
		}
		for (int i = 0; i < K; i++) {
			input = new StringTokenizer(f.readLine());
			food[i] = new pair(Integer.parseInt(input.nextToken()) - 1, -1, Integer.parseInt(input.nextToken()));
		}
		f.close();

		// algorithm: graph theory (DPQ 2 runs)
		int[] dist1 = dpq(pastures, N - 1, N);
		for (int i = 0; i < K; i++) {
			pastures.put(N + " " + food[i].source, dist1[food[i].source]-food[i].weight); // or just creates a new connections with
			connections[N].add(food[i].source); 															// negative weight
		}
		int[] dist2 = dpq(pastures, N, N+1);

		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dining.out")));
		for (int i = 0; i < N-1; i++) {
			System.out.println(dist1[i] + " " + dist2[i]);
			if (dist2[i] <= dist1[i])
				out.println("1");
			else
				out.println("0");
		}
		out.close();
	}

	// takes in adjancy list, source pair, and pairs and returns list of dists
	public static int[] dpq(HashMap<String, Integer> graph, int src, int n) {
		int[] dist = new int[n];
		boolean[] visited = new boolean[n];
		PriorityQueue<pair> next = new PriorityQueue<pair>(n, new pair());
		next.add(new pair(src, -1, 0));
		dist[src] = 0;
		while (next.isEmpty() == false) {
			pair curNode = next.remove();
			visited[curNode.source] = true;
			for (int store : connections[curNode.source]) {
				if (visited[store] == false && (dist[store] == 0
								|| dist[store] > dist[curNode.source] + graph.get(curNode.source + " " + store))) {
					dist[store] = dist[curNode.source] + graph.get(curNode.source + " " + store);
					next.add(new pair(store, -1, dist[store]));
				}
			}
		}
		return dist;
	}

	public static class pair implements Comparator<pair> {
		int source;
		int destination;
		int weight;

		public pair() {
		}

		public pair(int a, int b, int c) {
			source = a;
			destination = b;
			weight = c;
		}

		@Override
		public int compare(pair o1, pair o2) {
			// TODO Auto-generated method stub
			return o1.weight - o2.weight;
		}

		public String toString() {
			return source + " " + destination;
		}

	}
}
