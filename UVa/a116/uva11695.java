//package a116;

/*
ID: urd00m
LANG: JAVA
TASK: uva11695
 */
import java.io.*;
import java.util.*;

public class Main {
	static int t, n;
	static ArrayList<Integer>[] graph;
	static ArrayList<Integer> diameterNodes;
	static ArrayList<Integer> diameterNodesTemp;
	static int diameter, diameterTemp;

	public static void main(String args[]) throws IOException, InterruptedException {
		// input
		// Thread.sleep(3000);
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		t = Integer.parseInt(f.readLine());
		for (int counter = 0; counter < t; counter++) {
			n = Integer.parseInt(f.readLine());
			graph = new ArrayList[n];
			for (int i = 0; i < n; i++)
				graph[i] = new ArrayList<Integer>();
			for (int i = 0; i < n - 1; i++) {
				input = new StringTokenizer(f.readLine());
				int a = Integer.parseInt(input.nextToken()) - 1;
				int b = Integer.parseInt(input.nextToken()) - 1;
				graph[a].add(b);
				graph[b].add(a);
			}

			// determine the diameter
			diameterNodes = new ArrayList<Integer>();
			diameterNodesTemp = new ArrayList<Integer>();
			clear(); 
			dfs(0, -1, -1);
			clear(); 
			dfs(diameterNodes.get(diameterNodes.size() - 1), -1, -1);
			ArrayList<Integer> diameterSave = new ArrayList<Integer>();
			for (int item : diameterNodes)
				diameterSave.add(item);
			// determine the worst edge to remove
			int[] worstEdge;
			int[] addEdge;
			int[] ret1 = null;
			int[] ret2 = null;
			int lowestDist = Integer.MAX_VALUE;
			//long time = System.currentTimeMillis();  //delete
			for (int i = 0; i < diameterSave.size() - 1; i++) {
				// determine the centers of the two sections
				worstEdge = new int[2];
				addEdge = new int[2];
				worstEdge[0] = diameterSave.get(i);
				worstEdge[1] = diameterSave.get(i + 1);
				int leftSize = 0; int rightSize = 0; int totalSize = 0; 
				
				clear(); 
				dfs(worstEdge[0], -1, worstEdge[1]);
				clear(); 
				dfs(diameterNodes.get(diameterNodes.size() - 1), -1, worstEdge[1]);
				leftSize = (diameterNodes.size());
				addEdge[0] = diameterNodes.get((diameterNodes.size() / 2));
				
				clear(); 
				dfs(worstEdge[1], -1, worstEdge[0]);
				clear(); 
				dfs(diameterNodes.get(diameterNodes.size() - 1), -1, worstEdge[0]);
				rightSize = (diameterNodes.size());
				addEdge[1] = diameterNodes.get((diameterNodes.size() / 2));

				totalSize = Math.max((leftSize/2)+(rightSize/2)+1, Math.max(leftSize-1, rightSize-1)); //either it is the size of one of the trees or its the size of the connected graph  
			//	System.out.println(leftSize + " " + rightSize + " " + totalSize + " " + i + " " + diameterSave.toString());
				if (totalSize < lowestDist) {
					lowestDist = totalSize;
					ret1 = worstEdge;
					ret2 = addEdge;
				}
			}

			// output
			Arrays.sort(ret1);
			Arrays.sort(ret2);
			//System.out.println((System.currentTimeMillis()-time));
			
			System.out.println(lowestDist);
			System.out.println((ret1[0] + 1) + " " + (ret1[1] + 1));
			System.out.println((ret2[0] + 1) + " " + (ret2[1] + 1));
			
		}
	}
	public static void clear() {
		diameter = -1; 
		diameterTemp = 0; 
		diameterNodesTemp.clear();
	}

	
	public static void dfs(int curNode, int parNode, int banned) { // determine the diameter of the tree
		diameterNodesTemp.add(curNode); 
		diameterTemp++;
		if ( (graph[curNode].size() == 1) && (graph[curNode].get(0) == banned || graph[curNode].get(0) == parNode) && diameterTemp > diameter) { //only if it is a leaf node could it be the diameter 
			diameterNodes.clear();
			diameter = diameterTemp;
			for(int item : diameterNodesTemp) diameterNodes.add(item); 
		}
		else if (graph[curNode].size() == 2 && (graph[curNode].get(0) == banned || graph[curNode].get(0) == parNode) && (graph[curNode].get(1) == banned || graph[curNode].get(1) == parNode) && diameterTemp > diameter) {
			diameterNodes.clear();
			diameter = diameterTemp;
			for(int item : diameterNodesTemp) diameterNodes.add(item); 
		}
		for (int item : graph[curNode]) {
			if (item != parNode && item != banned) {
				dfs(item, curNode, banned);
			}
		}
		diameterTemp--;
		diameterNodesTemp.remove(diameterNodesTemp.size()-1); 
	}
	
}
