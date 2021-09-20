package negativeCycle;

import java.util.*;

public class bellmanFord {
	static int n;
	static ArrayList<pair>[] graph;

	public static void main(String args[]) {
		n = 3;
		graph = new ArrayList[n]; 
		for(int i = 0; i < n; i++) graph[i] = new ArrayList<pair>(); 
		graph[0].add(new pair(1, 1000)); 
		graph[1].add(new pair(2, 15));
		graph[2].add(new pair(1, -15)); 
		
		System.out.println(negativeCycleCheck(0)); 
		
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
				if( cur.second + dist[u] < dist[cur.first]){
					negativeCycle = true; 
					break; 
				}
			}
			if(negativeCycle == true) break; 
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
