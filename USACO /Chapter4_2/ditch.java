//package Chapter4_2;
/*
ID: alan.li2
LANG: JAVA
TASK: ditch
 */
import java.util.*;
import java.io.*;

public class ditch {
	static int n, m; 
	static int[][] graph; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("ditch.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken());
		m = Integer.parseInt(input.nextToken());
		graph = new int[m][m]; 
		for(int i = 0; i < n; i++) {
			input = new StringTokenizer(f.readLine()); 
			graph[Integer.parseInt(input.nextToken())-1][Integer.parseInt(input.nextToken())-1] += Integer.parseInt(input.nextToken()); 
		}
		f.close();
		
		//algorithm: graph theory, maximum network flow 
		int maxFlow = maxCap(0, m-1, m);
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ditch.out"))); 
		out.println(maxFlow);
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
				graph[curNode][nextNode] = graph[curNode][nextNode] + pathCapacity;
				curNode = nextNode; 
			}
		}
		return totalFlow; 
	}
}
