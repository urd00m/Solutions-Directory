package dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DPQModified {
	public static void main(String args[]) {
		int n = 4; 
		ArrayList<pair>[] graph = new ArrayList[n]; 
		for(int i = 0; i < n; i++) graph[i] = new ArrayList<pair>(); 
		/*
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				graph[i].add(new pair(j, 1)); 
				graph[j].add(new pair(i, 1)); 
			}
		}
		*/
		graph[0].add(new pair(3, 10)); 
		graph[3].add(new pair(0, 10)); 
		graph[1].add(new pair(0, 20));
		graph[0].add(new pair(1, 20)); 
		graph[3].add(new pair(1, 3)); 
		graph[1].add(new pair(3, 3)); 
		graph[1].add(new pair(2, 5));
		graph[2].add(new pair(1, 5));
		graph[3].add(new pair(2, 2)); 
		graph[2].add(new pair(3, 2));
		long time = System.currentTimeMillis(); 
		int[] output = dpq(graph, n-1, n); 
		System.out.println("time " + (System.currentTimeMillis()-time));
		for(int item : output) System.out.println(item);
		
	}
	
	//takes in adjancy list, source pair, and pairs and returns list of dists 
	public static int[] dpq(ArrayList<pair>[] graph, int src, int n) {
		int[] dist = new int[n];  
		boolean[] visited = new boolean[n]; 
		PriorityQueue<pair> next = new PriorityQueue<pair>(n, new pair()); 
		next.add(new pair(src, 0)); 
		dist[src] = 0; 
		while(next.isEmpty() == false) {
			pair curNode = next.remove(); 
			visited[curNode.destination] = true;
			for(pair store : graph[curNode.destination]) {
				if(visited[store.destination] == false && (dist[store.destination] == 0 || dist[store.destination] > dist[curNode.destination]+store.weight)) {
					dist[store.destination] = dist[curNode.destination]+store.weight; 
					next.add(new pair(store.destination, dist[store.destination]));  
				}
			}
		}
		return dist; 
	}
	public static class pair implements Comparator<pair> {
		int destination; 
		int weight; 
		public pair() {
		}
		public pair(int a, int b) {
			destination = a; 
			weight = b; 
		}
		@Override
		public int compare(pair o1, pair o2) {
			return o1.weight - o2.weight;
		}
	}
}
