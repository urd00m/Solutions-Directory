//package Chapter3_3;
/*
ID: alan.li2
LANG: JAVA
TASK: fence
 */

import java.util.*;
import java.io.*;

public class fence {
	static int numFences; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("fence.in"));
		numFences = Integer.parseInt(f.readLine()); 
		StringTokenizer input; 
		Fleury graph = new Fleury(501);
		int numVertices = 0;
		for(int i = 0; i < numFences; i++) {
			input = new StringTokenizer(f.readLine()); 
			int a = Integer.parseInt(input.nextToken())-1; 
			int b =  Integer.parseInt(input.nextToken())-1;
			graph.addEdge(a, b); //decrease it to 1 
			if(a > numVertices) numVertices = a+1; 
			if(b > numVertices) numVertices = b+1; 
		}
		graph.vertices = numVertices+1; 
		//sort the adj list to get the smallest possible vertex each time 
		graph.sort(); 
		f.close();
		
		//Fleury's algorithm 
		graph.printEulerTour();
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence.out")));
		for(int i = 0; i < graph.path.size(); i++) {
			out.println(graph.path.get(i));
		}
		out.close();
	}
	
	//algorithm 
	public static class Fleury {
		public int vertices; // No. of vertices
		private ArrayList<Integer>[] adj; // adjacency list
		public ArrayList<Integer> path = new ArrayList<Integer>(); 
		// Constructor
		Fleury(int numOfVertices) {
			this.vertices = numOfVertices;
			initGraph();
		}

		@SuppressWarnings("unchecked")
		private void initGraph() {
			adj = new ArrayList[vertices];
			for (int i = 0; i < vertices; i++) {
				adj[i] = new ArrayList<>();
			}
		}
		
		public void sort() { //to sort each connection 
			for(int i = 0; i < adj.length; i++) {
				Collections.sort(adj[i]);
			}
		}
		// add edge u-v
		private void addEdge(Integer u, Integer v) {
			adj[u].add(v);
			adj[v].add(u);
		}

		// This function removes edge u-v from graph.
		private void removeEdge(Integer u, Integer v) {
			adj[u].remove(v);
			adj[v].remove(u);
		}
		private void printEulerTour() {
			int u = 0;
			for (int i = 0; i < vertices; i++) {
				if (adj[i].size() % 2 == 1) {
					u = i;
					break;
				}
			}
			path.add(u+1); 
			printEulerUtil(u);
		}

		
		
		private void printEulerUtil(Integer u) {
			for (int i = 0; i < adj[u].size(); i++) {
				Collections.sort(adj[u]);
				Integer v = adj[u].get(i);
				if (isValidNextEdge(u, v)) {
					path.add(v+1); 
					removeEdge(u, v);
					printEulerUtil(v);
				}
			}
		}
		private boolean isValidNextEdge(Integer u, Integer v) {
			if (adj[u].size() == 1) {
				return true;
			}
			boolean[] isVisited = new boolean[this.vertices];
			int count1 = dfsCount(u, isVisited);
			removeEdge(u, v);
			isVisited = new boolean[this.vertices];
			int count2 = dfsCount(u, isVisited);
			addEdge(u, v);
			return (count1 > count2) ? false : true;
		}

		private int dfsCount(Integer v, boolean[] isVisited) {
			isVisited[v] = true;
			int count = 1;
			for (int adj : adj[v]) {
				if (!isVisited[adj]) {
					count = count + dfsCount(adj, isVisited);
				}
			}
			return count;
		}

	}
}


