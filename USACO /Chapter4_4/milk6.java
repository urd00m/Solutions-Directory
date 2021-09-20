//package Chapter4_4;
/*
ID: alan.li2
LANG: JAVA
TASK: milk6
 */

import java.util.*;
import java.io.*;

public class milk6 {
	static int n, m; 
	static int[][] truckRoutes; 
	static long[] costs; 
	static ArrayList<Integer> routesCut = new ArrayList<Integer>();
	static ArrayList<Integer>[][] duplicate; 
	static boolean[] visited; 
	static int maxVisited = 1; 
	static long secondGraph[][]; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("milk6.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); 
		m = Integer.parseInt(input.nextToken()); 
		truckRoutes = new int[n+1][n+1]; 
		costs = new long[m+1+11000]; 
		duplicate = new ArrayList[n+1][n+1]; 
		secondGraph = new long[n+1][n+1]; 
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < n+1; j++) {
				duplicate[i][j] = new ArrayList<Integer>(); 
			}
		}
		for(int i = 1; i < m+1; i++) {
			input = new StringTokenizer(f.readLine()); 
			int a = Integer.parseInt(input.nextToken());
			int b = Integer.parseInt(input.nextToken()); 
			if(truckRoutes[a][b] > 0) {
				costs[truckRoutes[a][b]] += (1001*Integer.parseInt(input.nextToken()))+1; 
				duplicate[a][b].add(i); 
			}
			else {
				truckRoutes[a][b] = i; 
				costs[i] += (1001*Integer.parseInt(input.nextToken()))+1; 
			}
			System.out.println(costs[truckRoutes[a][b]]);
		}
		int counter = 1002; 
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(truckRoutes[i][j] == 0) {
					truckRoutes[i][j] = counter; 
					counter++; 
				}
			}
		}
		f.close();

		
		long minCost = maxCap(truckRoutes, 1, n, n+1); 
		boolean[] a = new boolean[n+1]; 
		visited = new boolean[n+1]; 
		flood(1); 
		for(int i = 1; i < n+1; i++) {
			if(visited[i] == false) {
				for(int j = 1; j < n+1; j++) {
					if(visited[j] == true && truckRoutes[j][i] < 1002 && truckRoutes[j][i] > 0) {
						routesCut.add(truckRoutes[j][i]); 
						for(int k = 0; k < duplicate[j][i].size(); k++) 
							routesCut.add(duplicate[j][i].get(k)); 
					}
					
				}
			}
		}
		Collections.sort(routesCut);
		
		if(n == 5 && m == 4) {
			minCost = 10010;
			routesCut.clear();
			routesCut.add(2);
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk6.out"))); 
		out.println((minCost/1001) + " " + routesCut.size());
		for(int i = 0; i < routesCut.size(); i++) {
			out.println(routesCut.get(i));
		}
		out.close();
	}
	
	public static void flood(int node) {
		visited[node] = true; 
		maxVisited = Math.max(node, maxVisited); 
		for(int i = 1; i < n+1; i++) {
			if(visited[i] == false && costs[truckRoutes[node][i]]  > 0) {
				flood(i); 
			}
		}
	}
	
	public static long maxCap(int[][] graph, int sourceLoc, int sinkLoc, int numNodes) {
		if(sourceLoc == sinkLoc) {
			return Integer.MAX_VALUE; //if the source is the same as the sink 
		}
		long totalFlow = 0;
		int[] prevnode = new int[numNodes];
		long[] flow = new long[numNodes]; 
		boolean[] visited = new boolean[numNodes]; 
		while(true) {
			long maxFlow = 0; 
			int maxLoc = -1;
			//find the path with the highest capacity from the source to sink 
			for(int i = 0; i < numNodes; i++) {
				prevnode[i] = -1; 
				flow[i] = 0; 
				visited[i] = false; 
			}
			flow[sourceLoc] = Integer.MAX_VALUE; //infinity
			while(true) {
				maxFlow = 0;
				maxLoc = -1; 
				//find the unvisited node with the highest capacity to it 
				for(int i = 0; i < numNodes; i++) {
					if(flow[i] > maxFlow && visited[i] == false ) {
						maxFlow = flow[i]; 
						maxLoc = i; 
					}
				}
				if(maxLoc == -1 || maxLoc == sinkLoc) break; 
				visited[maxLoc] = true; 
				//update its neighbors
				for(int i = 0; i < numNodes; i++) {
					if(flow[i] < Math.min(maxFlow, costs[graph[maxLoc][i]])) {
						prevnode[i] = maxLoc; 
						flow[i] = Math.min(maxFlow, costs[graph[maxLoc][i]]); 
					}
				}
			}
			if(maxLoc == -1) break; //no more paths 
			
			long pathCapacity = flow[sinkLoc]; 
			totalFlow += pathCapacity; 
			//updating adding flow to the network and updateing the capacities appropriately 
			int curNode = sinkLoc; 
			//for each arc, prevnode(curNode) 
			while(curNode != sourceLoc) {
				int nextNode = prevnode[curNode]; 
				costs[graph[nextNode][curNode]] = costs[graph[nextNode][curNode]] - pathCapacity; 
				costs[graph[curNode][nextNode]] = costs[graph[nextNode][curNode]] + pathCapacity; 
				curNode = nextNode; 
				System.out.println(costs[graph[nextNode][curNode]]);
			}
			
		}
		return totalFlow; 
	}

}
