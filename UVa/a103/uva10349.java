//package a103;

/*
ID: urd00m
LANG: JAVA
TASK: uva10349
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int ret;
	static int h, w;
	static int[][] inputgraph; // 0 = open space and 0 < == important
	static int[][] graph;
	static int spacesToCover;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		n = Integer.parseInt(f.readLine());
		// mvc type problem
		// create a bipartite graph
		// max matching while removing the nodes that are matched
		// add back on the single nodes to the final solution
		for (int counter = 0; counter < n; counter++) {
			// input
			input = new StringTokenizer(f.readLine());
			h = Integer.parseInt(input.nextToken());
			int w = Integer.parseInt(input.nextToken());
			inputgraph = new int[h][w];
			spacesToCover = 0;
			ret = 0;
			for (int i = 0; i < h; i++) {
				String input2 = f.readLine();
				for (int j = 0; j < w; j++) {
					if (input2.charAt(j) == 'o')
						inputgraph[i][j] = 0;
					else {
						inputgraph[i][j] = ++spacesToCover;
					}
				}
			}

			// generating flow graph
			int numNodes = spacesToCover * 2 + 2;
			graph = new int[numNodes][numNodes];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					int curNode = inputgraph[i][j];
					if (curNode > 0) {
						if (i > 0) { // top
							if (inputgraph[i - 1][j] > 0)
								graph[curNode][inputgraph[i - 1][j]+spacesToCover] = 1; // there is a connection
						}
						if (j > 0) { // left
							if (inputgraph[i][j - 1] > 0)
								graph[curNode][inputgraph[i][j - 1]+spacesToCover] = 1;
						}
						if (j < w - 1) { // right
							if (inputgraph[i][j + 1] > 0)
								graph[curNode][inputgraph[i][j + 1]+spacesToCover] = 1;
						}
						if (i < h - 1) { // down
							if (inputgraph[i + 1][j] > 0)
								graph[curNode][inputgraph[i + 1][j]+spacesToCover] = 1;
						}
						graph[0][curNode] = 1; // establishes connection from sources
						graph[spacesToCover + curNode][numNodes - 1] = 1; // establishes connetion to sink
					}
				}
			}
			
			// running modified MCBM
			int numMatches = maxCap(graph, 0, numNodes - 1, numNodes);
			numMatches += (spacesToCover - numMatches*2); // adds the island nodes
			
			// output
			System.out.println(numMatches);
		}
	}

	public static int maxCap(int[][] graph, int sourceLoc, int sinkLoc, int numNodes) {
		if (sourceLoc == sinkLoc) {
			return Integer.MAX_VALUE; // if the source is the same as the sink
		}
		int totalFlow = 0;
		int[] prevnode = new int[numNodes];
		int[] flow = new int[numNodes];
		boolean[] visited = new boolean[numNodes];
		while (true) {
			int maxFlow = 0;
			int maxLoc = -1;
			// find the path with the highest capacity from the source to sink
			for (int i = 0; i < numNodes; i++) {
				prevnode[i] = -1;
				flow[i] = 0;
				visited[i] = false;
			}
			flow[sourceLoc] = Integer.MAX_VALUE; // infinity
			while (true) {
				maxFlow = 0;
				maxLoc = -1;
				// find the unvisited node with the highest capacity to it
				for (int i = 0; i < numNodes; i++) {
					if (flow[i] > maxFlow && visited[i] == false) { 
						maxFlow = flow[i];
						maxLoc = i;
					}
				}
				if (maxLoc == -1 || maxLoc == sinkLoc)
					break;
				visited[maxLoc] = true;
				// update its neighbors
				for (int i = 0; i < numNodes; i++) {
					if (flow[i] < Math.min(maxFlow, graph[maxLoc][i])) {
						prevnode[i] = maxLoc;
						flow[i] = Math.min(maxFlow, graph[maxLoc][i]);
					}
				}
			}
			if (maxLoc == -1)
				break; // no more paths

			int pathCapacity = flow[sinkLoc];
			totalFlow += pathCapacity;
			// updating adding flow to the network and updateing the capacities
			// appropriately
			int curNode = sinkLoc;
			// for each arc, prevnode(curNode)
			while (curNode != sourceLoc) {
				
				int nextNode = prevnode[curNode];
				graph[nextNode][curNode] = graph[nextNode][curNode] - pathCapacity;
				graph[curNode][nextNode] = graph[curNode][nextNode] + pathCapacity; // for residual graph and to ensure
																					// that we can go backwards
				// the above line is the most important line in the code allowing the code to
				// work backwards and essentially find what it missed
				if (nextNode != sourceLoc && curNode != sinkLoc) { // making sure to mark nodes used
					//used[((curNode - 1) % spacesToCover) + 1] = true;
					graph[((nextNode - 1) % spacesToCover) + 1 + spacesToCover][sinkLoc] -= 1; graph[sinkLoc][((nextNode - 1) % spacesToCover) + 1 + spacesToCover] += 1;
					graph[((curNode - 1) % spacesToCover) + 1][((nextNode - 1) % spacesToCover) + 1 + spacesToCover] -= 1;  graph[((nextNode - 1) % spacesToCover) + 1 + spacesToCover][((curNode - 1) % spacesToCover) + 1] += 1;
					graph[sourceLoc][((curNode - 1) % spacesToCover) + 1] -= 1; graph[((curNode - 1) % spacesToCover) + 1][sourceLoc] += 1; 
				}
				curNode = nextNode;
			}
			
		}
		return totalFlow;
	}
}
