//package goldFeb2020;
/*
ID: alwang
LANG: JAVA
TASK: timeline
 */
import java.util.*;

import java.io.*;

public class timeline {
	static int n, m, c; 
	static ArrayList<pair>[] graph;
	
	static int count; 
	static int[] dist;
	static boolean[] explored; 
	static int[] in; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("timeline.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); m = Integer.parseInt(input.nextToken()); c = Integer.parseInt(input.nextToken());
		input = new StringTokenizer(f.readLine()); dist = new int[n]; 
		for(int i = 0; i < n; i++) {
			dist[i] = Integer.parseInt(input.nextToken()); 
		}
		graph = new ArrayList[n]; in = new int[n]; 
		for(int i = 0; i < n; i++) graph[i] = new ArrayList<pair>(); 
		for(int i = 0; i < c; i++) {
			input = new StringTokenizer(f.readLine()); 
			int a = Integer.parseInt(input.nextToken())-1; int b = Integer.parseInt(input.nextToken())-1; 
			graph[a].add(new pair(b, Integer.parseInt(input.nextToken()))); 
			in[b]++; 
		}
		
		//algorithm run Dijistrika's until all nodes visited 
		explored = new boolean[n]; 
		Queue<Integer> next = new LinkedList<Integer>(); 
		for(int i = 0; i < n; i++) {
			if(in[i] == 0) {
				next.add(i); 
			}
		}
		while(next.isEmpty() == false) {
			int curNode = next.remove(); 
			explored[curNode] = true;
			for(pair store : graph[curNode]) {
				if(--in[store.destination] == 0) next.add(store.destination); 
				dist[store.destination] = Math.max(dist[store.destination], dist[curNode]+store.weight); 
			}
		}
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("timeline.out"))); 
		for(int item : dist) out.println(item);
		out.close();
		
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
