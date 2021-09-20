
//package jan2018gold;
/*
ID: alwang
LANG: JAVA
TASK: atlarge
 */
import java.io.*;
import java.util.*;

public class atlarge {
	static int n, k;
	static ArrayList<Integer>[] graph;
	static int[] distLeaf, distRoot; // distRoot is basically depth from the rootnode
	static int output = 0;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("atlarge.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		n = Integer.parseInt(input.nextToken());
		k = Integer.parseInt(input.nextToken())-1;
		init();
		for (int i = 0; i < n - 1; i++) {
			input = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(input.nextToken()) - 1;
			int b = Integer.parseInt(input.nextToken()) - 1;
			graph[a].add(b);
			graph[b].add(a);
		}
		f.close();

		// algorithm
		// dfs to find the distance from root to all leaf nodes then node to leaf nodes
		// in other subtrees
		// then for all the nodes that bessie can reach before the leaf nodes all of
		// those children subtrees must have farmers in order to make it impossible for
		// bessie to escape
		dfs1(k, -1);
		dfs2(k, -1);
		dfs3(k, -1);

		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("atlarge.out")));
		out.println(output);
		out.close();
	}

	public static void init() {
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++)
			graph[i] = new ArrayList<Integer>();
		distLeaf = new int[n];
		distRoot = new int[n];
		Arrays.fill(distLeaf, Integer.MAX_VALUE);
		Arrays.fill(distRoot, Integer.MAX_VALUE);
	}

	public static void dfs1(int curNode, int parentNode) {
		// depth
		if (parentNode == -1)
			distRoot[curNode] = 0;
		else
			distRoot[curNode] = distRoot[parentNode] + 1;

		// depth in respect to the leaf nodes
		if (graph[curNode].size() == 1 && graph[curNode].get(0) == parentNode)
			distLeaf[curNode] = 0;
		else
			for (int item : graph[curNode]) {
				if (item != parentNode) {
					dfs1(item, curNode);
					distLeaf[curNode] = Math.min(distLeaf[curNode], distLeaf[item] + 1);
				}
			}

	}

	public static void dfs2(int curNode, int parentNode) {
		// modifying the depths incorporating the other subtrees
		if (parentNode != -1)
			distLeaf[curNode] = Math.min(distLeaf[curNode], distLeaf[parentNode] + 1);
		for (int item : graph[curNode])
			if (item != parentNode)
				dfs2(item, curNode);
	}

	public static void dfs3(int curNode, int parentNode) {
		if (parentNode != -1 && (distLeaf[parentNode] > distRoot[parentNode]) && distRoot[curNode] >= distLeaf[curNode])
			output++;
		else
			for (int item : graph[curNode])
				if (item != parentNode)
					dfs3(item, curNode);
	}
}
