package networkFlow;

//network flow implementation 
//ford fulkerson algorithm for maximum network flow 
public class NetworkFlow {
	public static void main(String args[]) {
		//given a directed graph find the maximum possible "flow" 
		//int graph[][] = new int[][] { { 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 }, { 0, 4, 0, 0, 14, 0 },
		//		{ 0, 0, 9, 0, 0, 20 }, { 0, 0, 0, 7, 0, 4 }, { 0, 0, 0, 0, 0, 0 } };
		int graph[][] = {{0, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}}; //max matching
		System.out.println(maxCap(graph, 0, 5, 6)); //23 correct answer 
	}
	public static int maxCap(int[][] graph, int sourceLoc, int sinkLoc, int numNodes) {
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
				graph[curNode][nextNode] = graph[curNode][nextNode] + pathCapacity; //for residual graph and to ensure that we can go backwards 
				//the above line is the most important line in the code allowing the code to work backwards and essentially find what it missed 
				curNode = nextNode; 
			}
			
		}
		return totalFlow; 
	}
}
