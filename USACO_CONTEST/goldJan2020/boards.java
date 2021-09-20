//package goldJan2020;
/*
ID: alwang
LANG: JAVA
TASK: boards
 */
import java.io.*;
import java.util.*;
public class boards {
	static int n, p; 
	static int output = Integer.MAX_VALUE; 
	static boolean[] visited; 
	static node[] graph; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("boards.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); p = Integer.parseInt(input.nextToken()); 
		visited = new boolean[p]; graph = new node[p+2]; 
		for(int i = 1; i <= p; i++) {
			input = new StringTokenizer(f.readLine()); 
			int a = Integer.parseInt(input.nextToken()); int b = Integer.parseInt(input.nextToken()); int c = Integer.parseInt(input.nextToken()); int d = Integer.parseInt(input.nextToken()); 
			graph[i] = new node(a, b, c, d); 
		}
		graph[0] = new node(0, 0, -1, -1); 
		graph[p+1] = new node(n, n, -1, -1); //nodes
		f.close();
		
		//algorithm dijistrikas 
		int output = dpq(graph, 0, p+2); 
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("boards.out"))); 
		out.println(output);
		out.close();
	}
	public static int dpq(node[] graph, int src, int n) {
		int[] dist = new int[n];  
		boolean[] visited = new boolean[n]; 
		PriorityQueue<pair> next = new PriorityQueue<pair>(n, new pair()); 
		next.add(new pair(src, 0, 0, 0)); 
		dist[src] = 0; 
		while(next.isEmpty() == false) {
			pair curNode = next.remove();
			if(curNode.weight > dist[curNode.i]) continue; 
			if(curNode.i == p+1) return curNode.weight; 
			visited[curNode.i] = true;
			for(int i = 0; i < p+2; i++) {
				if(visited[i] == false && (dist[i] == 0 || (dist[i] > curNode.weight+(graph[i].x1+graph[i].y1-curNode.x-curNode.y) && curNode.weight+(graph[i].x1+graph[i].y1-curNode.x-curNode.y) > 0))) {
					dist[i] = curNode.weight+(graph[i].x1+graph[i].y1-curNode.x-curNode.y); 
					next.add(new pair(graph[i].x2, graph[i].y2, dist[i], i));  
				}
			}
		}
		return -1; 
	}
	
	public static class pair implements Comparator<pair> {
		int x, y; 
		int weight; 
		int i; 
		public pair() {
		}
		public pair(int a, int c, int b, int d) {
			x = a; 
			y = c;
			weight = b; 
			i = d; 
		}
		@Override
		public int compare(pair o1, pair o2) {
			return o1.weight - o2.weight;
		}
	}
	public static class node {
		int x1, y1; 
		int x2, y2; 
		public node(int a, int b, int c, int d) {
			x1 = a; 
			y1 = b; 
			x2 = c; 
			y2 = d; 
		}
	}
}
