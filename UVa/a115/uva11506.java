package a115;

/*
ID: urd00m
LANG: JAVA
TASK: uva11506
 */
import java.io.*;
import java.util.*;

public class uva11506 {
	static int m, w;
	static int[][] graph;
	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		String cur = f.readLine();
		while (cur.equals("0 0") == false) {
			input = new StringTokenizer(cur);
			m = Integer.parseInt(input.nextToken());
			w = Integer.parseInt(input.nextToken());
			graph = new int[2*m][2*m]; //vertix splitting   // 0 1 2 3 0out(4) 1out (5) 2out(6) 3out(7)
			//the in and out of 0 and m-1 is Infinity 
			graph[0][m] = Integer.MAX_VALUE; //no vertix flow 
			graph[m-1][2*m-1] = Integer.MAX_VALUE; 
			for (int i = 0; i < m - 2; i++) {
				input = new StringTokenizer(f.readLine());
				int node = Integer.parseInt(input.nextToken()) - 1; 
				graph[node][node+m] = Integer.parseInt(input.nextToken()); //connecting in to out 
			}
			// wires
			for (int i = 0; i < w; i++) {
				input = new StringTokenizer(f.readLine());
				int a = Integer.parseInt(input.nextToken()) - 1;
				int b = Integer.parseInt(input.nextToken()) - 1;
				int c = Integer.parseInt(input.nextToken());
				graph[a+m][b] = c; 
				graph[b+m][a] = c; 
			}
			int ret = maxCap(graph, 0, 2*m - 1, 2*m);
			System.out.println(ret);
			cur = f.readLine();
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
				curNode = nextNode;
			}

		}
		return totalFlow;
	}
}
