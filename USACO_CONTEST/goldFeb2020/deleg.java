
//package goldFeb2020;
/*
ID: alwang
LANG: JAVA
TASK: deleg
 */

import java.io.*;
import java.util.*;

public class deleg {
	static int n;
	static ArrayList<Integer>[] graph;
	static int[] sizeOfNode;
	static ArrayList<Integer>[] sizeOfSubtree;

	public static void main(String args[]) throws IOException {
		// input
		long time = System.currentTimeMillis(); 
		BufferedReader f = new BufferedReader(new FileReader("deleg.in"));
		StringTokenizer input;
		n = Integer.parseInt(f.readLine());
		graph = new ArrayList[n];
		sizeOfNode = new int[n];
		sizeOfSubtree = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Integer>();
			sizeOfSubtree[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n - 1; i++) {
			input = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(input.nextToken()) - 1;
			int b = Integer.parseInt(input.nextToken()) - 1;
			graph[a].add(b);
			graph[b].add(a);
		}
		f.close();

		// algorithm: dfs then dp
		// dfs to get information, first about the size of each item
		// and the size of the subtree of each node
		// then from there you know that in order for a specific k size to work
		// you need to have it be able to work in each subtree so just
		// check the size of the subtree of each node and see if it can fit the
		// partition size k
		// also subtrees can mix, so you have to have an array that make sure that
		// specific subtrees can pair with each other
		// also if the size n%k != 0 it won't work
		dfs(0, -1);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("deleg.out")));
		int[] readyToPair = new int[n];
		for (int k = 1; k < n; k++) {
			if ( (n-1) % k != 0)
				out.print("0");
			else {
				boolean good = true;
				for(int i = 0; i < k+1; i++) readyToPair[i] = 0; 
				for (ArrayList<Integer> node : sizeOfSubtree) {
					int numPair = 0; // must be zero after each loop
					for (int subtreeSize : node) {
						int a = subtreeSize % k;
						if (a != 0) { // doesn't perfectly split then
							// check to see if there is a pair that would complete it
							if (readyToPair[k - a] > 0) {
								readyToPair[k - a]--;
								numPair--;
							} else { // no such pair
								readyToPair[a]++;
								numPair++;
							}
						}
					}
					if (numPair != 0) { // didn't fully pair
						out.print("0");
						good = false;
						break;
					}
				}
				if (good == true)
					out.print("1");
			}
		}
		out.println();
		out.close();

	}

	public static void dfs(int curNode, int parentNode) {
		if (graph[curNode].size() == 1 && graph[curNode].get(0) == parentNode) { // if it is a leaf node
			sizeOfNode[curNode] = 0; // zero edges
			sizeOfSubtree[curNode].add(n - 1); // the "subtree" above the node
		} else {
			for (int item : graph[curNode]) {
				if (item != parentNode) {
					dfs(item, curNode);
					sizeOfNode[curNode] += sizeOfNode[item] + 1; // number of edges + 1
					sizeOfSubtree[curNode].add(sizeOfNode[item] + 1);
				}
			}
			sizeOfSubtree[curNode].add(n - sizeOfNode[curNode] - 1); // n-1 total edges, so the total number of edges
														// "above" is n-1- edges below
		}
	}

}
