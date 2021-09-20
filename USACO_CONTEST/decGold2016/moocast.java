//package decGold2016;
/*
ID: alwang
LANG: JAVA
TASK: moocast
 */
import java.util.*;
import java.io.*;

public class moocast {
	static int n; 
	static int[][] points; 
	static ArrayList<edge> edges = new ArrayList<edge>(); 
	static int[] parent; 
	static int output; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("moocast.in")); StringTokenizer input; 
		n = Integer.parseInt(f.readLine()); 
		points = new int[n][2]; parent = new int[n]; //init 
		for(int i = 0; i < n; i++) {
			input = new StringTokenizer(f.readLine()); 
			points[i][0] = Integer.parseInt(input.nextToken()); points[i][1] = Integer.parseInt(input.nextToken()); 
		}
		f.close();
		
		//preparation 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				int weight = (int) (Math.pow(points[i][0]-points[j][0], 2) + Math.pow(points[i][1]-points[j][1], 2)); 
				edges.add(new edge(i, j, weight)); 
			}
		}
		Collections.sort(edges, new Comparator<edge>(){
			@Override 
			public int compare(edge a, edge b) {
				return a.weight-b.weight; 
			}
		});
		
		//algorithm: UFDS after sorting the possible edges 
		int counter = 0; 
		for(int i = 0; i < n; i++) parent[i] = i; 
		for(edge item : edges) {
			if(find(item.x) != find(item.y)) {
				output = item.weight; 
				merge(item.x, item.y); 
				counter++; 
			}
			if(counter == n-1) break; 
		}
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		out.println(output);
		out.close();
	}
	public static int find(int curNode) {
		return (parent[curNode] == curNode) ? curNode : (parent[curNode] = find(parent[curNode])); 
	}
	public static void merge(int a, int b) {
		int pa = find(a);
		int pb = find(b); 
		parent[pb] = pa; 
	}
	
	public static class edge {
		int x, y;
		int weight; 
		public edge(int a, int b, int w) {
			x = a; 
			y = b; 
			weight = w; 
		}
	}
}
