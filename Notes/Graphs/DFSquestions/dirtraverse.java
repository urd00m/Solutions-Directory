package DFSquestions;
//package febGold2018;
/*
ID: alwang
LANG: JAVA
TASK: dirtraverse
 */
import java.io.*;
import java.util.*;

public class dirtraverse {
	static int n; 
	static ArrayList<Integer>[] graph; 
	static int[] sizeOfNode; 
	static long[] dp; 
	static int[] numLeafNodes; 
	static long output = Long.MAX_VALUE; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("dirtraverse.in")); 
		n = Integer.parseInt(f.readLine()); StringTokenizer input; 
		init();
		for(int i = 0; i < n; i++) {
			input = new StringTokenizer(f.readLine()); 
			String a = input.nextToken(); 
			sizeOfNode[i] = a.length(); 
			int b = Integer.parseInt(input.nextToken()); 
			if(b != 0) {
				sizeOfNode[i]++; 
				for(int j = 0; j < b; j++) {
					int x = Integer.parseInt(input.nextToken())-1; 
					graph[i].add(x); 
					graph[x].add(i); 
				}
			}
		}
		f.close();
		
		//algorithm: dfs to find "distance" to files (Leaf nodes) then second dfs to add on distance to leaf nodes in other subtrees of bessie and takes minimum 
		dfs(0, -1); 
		output = dp[0]; 
		dfs2(0, -1); 
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dirtraverse.out"))); 
		out.println(output);
		out.close();
	}
	public static long dfs(int curNode, int parentNode) {
		long total = 0; 
		for(int item : graph[curNode]) {
			if(item != parentNode) {
				total += (long)dfs(item, curNode); 
			}
		}
		if(graph[curNode].size() == 1 && graph[curNode].get(0) == parentNode) {
			numLeafNodes[curNode]++; 
			numLeafNodes[parentNode]++; 
			return sizeOfNode[curNode]; 
		}
		else {
			if(parentNode != -1) numLeafNodes[parentNode] += numLeafNodes[curNode]; 
			dp[curNode] += (long)total; 
			return (long)total + (long)sizeOfNode[curNode]*(long)numLeafNodes[curNode];
		}
		
	}
	
	public static void dfs2(int curNode, int parentNode) {
		if(parentNode != -1 && (graph[curNode].size() != 1 || graph[curNode].get(0) != parentNode)) {
		//	System.out.println(curNode + " " + dp[curNode] + " " + dp[parentNode] + " " + (sizeOfNode[parentNode]*(numLeafNodes[parentNode] - numLeafNodes[curNode])) + " " + (3*(numLeafNodes[0] - numLeafNodes[curNode])));
			dp[curNode] = (long)dp[curNode] + ((long)dp[parentNode]-(long)dp[curNode] - ((long)sizeOfNode[curNode]*(numLeafNodes[curNode])) + ((long)3*(numLeafNodes[0] - numLeafNodes[curNode]))); 
			//System.out.println(dp[curNode]);
			output = Math.min((long)output, (long)dp[curNode]); 
		}
		for(int item : graph[curNode]) {
			if(item != parentNode) dfs2(item, curNode); 
		}
	}
	public static void init() {
		graph = new ArrayList[n]; 
		for(int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>(); 
		sizeOfNode = new int[n]; 
		numLeafNodes = new int[n]; 
		dp = new long[n]; 
	}
}
