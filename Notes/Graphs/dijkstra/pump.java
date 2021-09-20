package dijkstra;
//package goldDec2019;
/*
ID: alwang
LANG: JAVA
TASK: pump
 */
import java.io.*;
import java.util.*;

public class pump {
	static int n, m;
	static ArrayList<pair>[] graph;
	static double maxAnswer = 0;
	static HashMap<String, Integer> pathUsed = new HashMap<String, Integer>(); 
	
	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("pump.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		n = Integer.parseInt(input.nextToken());
		m = Integer.parseInt(input.nextToken());
		graph = new ArrayList[n];
		Queue<Integer> flows = new LinkedList<Integer>(); 
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<pair>();
		}
		for (int i = 0; i < m; i++) {
			input = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(input.nextToken()) - 1;
			int b = Integer.parseInt(input.nextToken()) - 1;
			int c = Integer.parseInt(input.nextToken());
			int d = Integer.parseInt(input.nextToken());
			graph[a].add(new pair(b, c, d));
			graph[b].add(new pair(a, c, d));
			flows.add(d); 
		}
		f.close();

		// graph theory: dijistrika but modified to count for the flow
		boolean[] flowDone = new boolean[1001]; 
		for(int flow : flows) {
			if(flowDone[flow] == false) {
				int minDist = dpq(graph, 0, n, flow); 
				if(minDist != 0) maxAnswer = Math.max(maxAnswer, flow/(minDist*1.0)); 
				flowDone[flow] = true; 
			}
		}
		
		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pump.out")));
		long answer = (long) (maxAnswer * 1000000);
		out.println(answer);
		out.close();
	}
	public static int dpq(ArrayList<pair>[] graph, int src, int n, int f) {
		int[] dist = new int[n];  
		PriorityQueue<pair> next = new PriorityQueue<pair>(n, new pair()); 
		next.add(new pair(src, 0, -1)); 
		dist[src] = 0; 
		while(next.isEmpty() == false) {
			pair curNode = next.remove(); 
			for(pair store : graph[curNode.destination]) {
				if(store.flow >= f) {
					if(pathUsed.containsKey(curNode.destination + " " + store.destination) == false && (dist[store.destination] == 0 || dist[store.destination] > dist[curNode.destination]+store.weight)) {
						dist[store.destination] = dist[curNode.destination]+store.weight; 
						next.add(new pair(store.destination, dist[store.destination], Math.min(curNode.flow, store.flow)));
					}
				}
			}
		}
		return dist[n-1]; 
	}
	public static class pair implements Comparator<pair> {
		int destination; 
		int weight; 
		int flow; 
		public pair() {
		}
		public pair(int a, int b, int c) {
			destination = a; 
			weight = b; 
			flow = c; 
		}
		@Override
		public int compare(pair o1, pair o2) {
			return o1.weight - o2.weight;
		}
	}

}
