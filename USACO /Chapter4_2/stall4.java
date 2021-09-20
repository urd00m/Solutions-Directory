//package Chapter4_2;
/*
ID: alan.li2
LANG: JAVA
TASK: stall4
 */

import java.io.*;
import java.util.*;

public class stall4 {
	static int n, m; 
	static int[][] graph; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("stall4.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); 
		m = Integer.parseInt(input.nextToken()); 
		graph = new int[n+m+2][n+m+2]; //index 0 = source, index n+m+1 is sink 
		for(int i = m+1; i < m+n+1; i++) {
			input = new StringTokenizer(f.readLine()); 
			graph[0][i] = 1; 
			int limit = Integer.parseInt(input.nextToken()); 
			for(int j = 0; j < limit; j++) {
				graph[i][Integer.parseInt(input.nextToken())] = 1; 
			}
		}
		
		//init the paths to sink 
		for(int i = 1; i < m+1; i++) {
			graph[i][n+m+1] = 1;
		}
		f.close();
		
		//algorithm 
		int max = maxCap(0, n+m+1, n+m+2); 
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stall4.out")));
		out.println(max);
		out.close();
		
	}
	public static int maxCap(int sourceLoc, int sinkLoc, int numNodes) {
		if(sourceLoc == sinkLoc) {
			return Integer.MAX_VALUE; //if the source is the same as the sink 
		}
		int totalFlow = 0;
		int[] prevnode = new int[numNodes];
		int[] flow = new int[numNodes]; 
		boolean[] visited = new boolean[numNodes]; 
		while(true) {
			int maxFlow = 0; 
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
					if(flow[i] < Math.min(maxFlow, graph[maxLoc][i])) {
						prevnode[i] = maxLoc; 
						flow[i] = Math.min(maxFlow, graph[maxLoc][i]); 
					}
				}
			}
			if(maxLoc == -1) break; //no more paths 
			
			int pathCapacity = flow[sinkLoc]; 
			totalFlow += pathCapacity; 
			//updating adding flow to the network and updateing the capacities appropriately 
			int curNode = sinkLoc; 
			//for each arc, prevnode(curNode) 
			while(curNode != sourceLoc) {
				int nextNode = prevnode[curNode]; 
				graph[nextNode][curNode] = graph[nextNode][curNode] - pathCapacity; 
				graph[curNode][nextNode] = graph[curNode][nextNode] + pathCapacity; //don't really need 
				curNode = nextNode; 
			}
			
		}
		return totalFlow; 
	}
}
