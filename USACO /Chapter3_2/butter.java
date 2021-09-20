//package Chapter3_2;
/*
ID: alan.li2
LANG: JAVA
TASK: butter
 */
import java.util.*;
import java.io.*;

public class butter {
	static int[] cowLocations;
	static int n, p, c;
	static int dist[];
	static int min = Integer.MAX_VALUE; // minimum distance the cows need to travel

	public static void main(String args[]) throws IOException {
		// input
		long currentTime = System.currentTimeMillis(); 
		BufferedReader f = new BufferedReader(new FileReader("butter.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		n = Integer.parseInt(input.nextToken());
		p = Integer.parseInt(input.nextToken());
		c = Integer.parseInt(input.nextToken());
		List<List<Node>> adjList = new ArrayList<List<Node>>(); // adj list containing vertices
		cowLocations = new int[800]; 
		for (int i = 0; i < n; i++) {
			cowLocations[Integer.parseInt(f.readLine())-1]++;
		}
		for (int i = 0; i < p; i++)
			adjList.add(new ArrayList<Node>());
		for (int i = 0; i < c; i++) {
			input = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(input.nextToken()) - 1; // to fit the indexes of the arrays
			int to = Integer.parseInt(input.nextToken()) - 1;
			int dist = Integer.parseInt(input.nextToken());
			adjList.get(src).add(new Node(to, dist));
			adjList.get(to).add(new Node(src, dist));
		}
		f.close();
		//finding distance 
		//creating data structure
		System.out.println( (System.currentTimeMillis()-currentTime) ); 
		DPQ map = new DPQ(p);
		for(int i = 0; i < p; i++) {
			map.reset();
			map.dijkstra(adjList, i);
			//int totDist = 0;
			//print(dist); 
			//for(int j = 0; j < p; j++) {
			//	if(cowLocations[j] > 0)
			//		totDist += dist[j]*cowLocations[j]; 
		//	}
			//min = Math.min(min, totDist); 
		} 
		// output
		PrintWriter out = new PrintWriter(new FileWriter("butter.out"));
		out.println(min);
		out.close();
		System.out.println( (System.currentTimeMillis()-currentTime) ); 
	}
	
	//delete
	public static void print(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " " + cowLocations[i]);
		}
	}
	//delete
	
	//dijistraka's  with Priority queue from geeksforgeeks with some modifications
	public static class DPQ {
		private Set<Integer> settled;
		private PriorityQueue<Node> pq;
		private int V; // Number of vertices
		List<List<Node>> adj;

		public DPQ(int V) {
			this.V = V;
			dist = new int[V];
			settled = new HashSet<Integer>();
			pq = new PriorityQueue<Node>(V, new Node());
		}
		public void reset() {
			dist = new int[V];
			settled = new HashSet<Integer>();
			pq = new PriorityQueue<Node>(V, new Node());
		}
		// Function for Dijkstra's Algorithm
		public void dijkstra(List<List<Node>> adj, int src) {
			int cowsLeft = n; 
			int totDist = 0; 
			this.adj = adj;

			for (int i = 0; i < V; i++)
				dist[i] = Integer.MAX_VALUE;

			// Add source node to the priority queue
			pq.add(new Node(src, 0));

			// Distance to the source is 0
			dist[src] = 0;
			
			while (settled.size() != V) {
				// remove the minimum distance node
				// from the priority queue
				int u = pq.remove().node;
				
				if(settled.contains(u) == false) totDist += dist[u] * cowLocations[u]; 
				if(settled.contains(u) == false) cowsLeft -= cowLocations[u];
				if(cowsLeft == 0) break; 
				if(totDist + cowsLeft*dist[u] >= min)
					 return;
				
				// adding the node whose distance is
				// finalized
				if(settled.contains(u) == false) {
					settled.add(u);
					e_Neighbours(u);
				}
				
			}
			min = Math.min(min, totDist); 
		}
		// Function to process all the neighbours
		// of the passed node
		private void e_Neighbours(int u) {
			int edgeDistance = -1;
			int newDistance = -1;

			// All the neighbors of v
			for (int i = 0; i < adj.get(u).size(); i++) {
				Node v = adj.get(u).get(i);

				// If current node hasn't already been processed
				if (!settled.contains(v.node)) {
					edgeDistance = v.cost;
					newDistance = dist[u] + edgeDistance;

					// If new distance is cheaper in cost
					if (newDistance < dist[v.node])
						dist[v.node] = newDistance;

					// Add the current node to the queue
					pq.add(new Node(v.node, dist[v.node]));
				}
			}
		}
	}

	// Class to represent a node in the graph
	public static class Node implements Comparator<Node> {
		public int node;
		public int cost;

		public Node() {
		}

		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compare(Node node1, Node node2) {
			if (node1.cost < node2.cost)
				return -1;
			if (node1.cost > node2.cost)
				return 1;
			return 0;
		}
	}

}
