//package JanGold2019;
/*
ID: alwang
LANG: JAVA
TASK: shortcut
 */
import java.io.*;
import java.util.*;
public class shortcut {
	static int n, m, t; 
	static int[] numCows;
	static ArrayList<pair>[] graph; 
	static int[] parent; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("shortcut.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); m = Integer.parseInt(input.nextToken()); t = Integer.parseInt(input.nextToken()); 
		init(); 
		input = new StringTokenizer(f.readLine()); 
		for(int i = 0; i < n; i++) numCows[i] = Integer.parseInt(input.nextToken()); 
		for(int i = 0; i < m; i++) {
			input = new StringTokenizer(f.readLine()); 
			int a = Integer.parseInt(input.nextToken())-1; int b = Integer.parseInt(input.nextToken())-1; int c = Integer.parseInt(input.nextToken()); 
			graph[a].add(new pair(b, c)); 
			graph[b].add(new pair(a, c));
		}
		f.close();
		
		//algorithm
		int[] dist = dpq(graph, 0, n); 
		int[] cowsVisited = new int[n]; 
		for(int i = 0; i < n; i++) {
			int curNode = i; 
			int cows = numCows[curNode]; 
			while(curNode != 0) {
				cowsVisited[curNode] += cows; 
				curNode = parent[curNode]; 
			}
		}
		long maxSaved = 0; 
		for(int i = 0; i < n; i++) { //the barn doesn't make a difference but i added it anyway 
			maxSaved = Math.max(maxSaved, (long)(dist[i]-t)*cowsVisited[i]); 
		}
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shortcut.out"))); 
		out.println(maxSaved);
		out.close();
	}
	public static void init() {
		numCows = new int[n]; 
		graph = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			graph[i] = new ArrayList<pair>(); 
		}
		parent = new int[n]; 
	}
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
					parent[store.destination] = curNode.destination; 
				}
				else if(visited[store.destination] == false && dist[store.destination] == dist[curNode.destination]+store.weight) {
					parent[store.destination] = Math.min(curNode.destination, parent[store.destination]);  
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
