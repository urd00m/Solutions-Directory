//package a106;
/*
ID: urd00m
LANG: JAVA
TASK: uva10600
 */
import java.io.*;
import java.util.*;

public class Main {
	static int t; 
	
	static int n, m; 
	static int[] taken; 
	static PriorityQueue<pair> pq; 
	static ArrayList<pair>[] graph; 
	static int[][] used; 
	static int id; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine());
		for(int count = 0; count < t; count++) {
			input = new StringTokenizer(f.readLine()); 
			n = Integer.parseInt(input.nextToken()); int m = Integer.parseInt(input.nextToken()); 
			graph = new ArrayList[n]; 
			for(int i = 0; i < n; i++) graph[i] = new ArrayList<pair>(); 
			for(int i = 0; i < m; i++) {
				input = new StringTokenizer(f.readLine()); 
				int a = Integer.parseInt(input.nextToken())-1; int b = Integer.parseInt(input.nextToken())-1; int c = Integer.parseInt(input.nextToken()); 
				graph[a].add(new pair(b, c)); 
				graph[b].add(new pair(a, c)); 
			}
			taken = new int[n]; 
			pq = new PriorityQueue<pair>(n, new pair()); 
			used = new int[n][3]; //the best MST has n-1 edges 
			id = 0; 
			
		
			//run prims 
			int best = prim(n);
			
			//running prims again but finding the 2nd best 
			int[][] remove = used; int secondBest = Integer.MAX_VALUE;
			for(int i = 0; i < n-1; i++) {
				taken = new int[n]; 
				pq.clear();
				used = new int[n][3]; 
				id = 0; 
				int u = remove[i][0]; int v = remove[i][1]; int w = remove[i][2]; 
				int a1 = -1; int a2 = -1;  
				for(int j = 0; j < graph[u].size(); j++) {
					if(graph[u].get(j).destination == v && graph[u].get(j).weight == w) {
						a1 = j; 
						break; 
					}
				}
				for(int j = 0; j < graph[v].size(); j++) {
					if(graph[v].get(j).destination == u && graph[v].get(j).weight == w) {
						a2 = j; 
						break; 
					}
				}
				//killing the edge
				int save = graph[u].get(a1).weight; 
				graph[u].get(a1).weight = 1000000000; 
				graph[v].get(a2).weight = 1000000000; 
				int temp = prim(n);
				secondBest = Math.min(secondBest, temp); 
				graph[u].get(a1).weight = save; 
				graph[v].get(a2).weight = save; 
			}
			System.out.println(best + " " + secondBest); 
		}
	}
	
	public static int prim(int n) {
		int mst_cost  = 0; 
		process(0); 
		while(pq.isEmpty() == false) {
			pair front = pq.remove(); 
			int u = front.destination; 
			int w = front.weight;
			if(taken[u] == 0) {
				used[id][0] = front.from; used[id][2] = w; used[id++][1] = u; 
				mst_cost += w; process(u); 
			}
		}
		return mst_cost; 
	}
	
	public static void process(int vtx) {
		taken[vtx] = 1; 
		for(int j = 0; j < graph[vtx].size(); j++) {
			pair v =  graph[vtx].get(j); 
			if(taken[v.destination] == 0) {
				pq.add(new pair(vtx, v.destination, v.weight));
			}
			
		}
	}
	public static class pair implements Comparator<pair> {
		int from; 
		int destination; 
		int weight; 
		public pair() {
		}
		public pair(int a, int b) {
			destination = a; 
			weight = b; 
		}
		public pair(int a, int b, int c) {
			from = a; 
			destination = b; 
			weight = c; 
		}
		@Override
		public int compare(pair o1, pair o2) {
			return o1.weight - o2.weight;
		}
	}
}
