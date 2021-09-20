package LCA;

import java.util.ArrayList;

public class ancestorDescendantQuery {
	static int n = 8;
	static int cnt = 0;
	static int[] timeIn = new int[n], timeOut = new int[n];

	public static void main(String args[]) {
		ArrayList<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++)
			graph[i] = new ArrayList<Integer>(); // example graph
		graph[0].add(1);
		graph[1].add(0);
		graph[0].add(2);
		graph[2].add(0);
		graph[1].add(3);
		graph[3].add(1);
		graph[1].add(4);
		graph[4].add(1);
		graph[2].add(5);
		graph[5].add(2);
		graph[4].add(6);
		graph[6].add(4);
		graph[5].add(7);
		graph[7].add(5);
		dfs(graph, 0, -1, timeIn, timeOut);
		System.out.println(isAncestor(1, 6));
		System.out.println(isAncestor(1, 1));
	}

	public static void dfs(ArrayList<Integer>[] graph, int curNode, int parentNode, int[] timeIn, int[] timeOut) {
		timeIn[curNode] = cnt++;
		for (int i = 0; i < graph[curNode].size(); i++) {
			int nextNode = graph[curNode].get(i);
			if (nextNode != parentNode)
				dfs(graph, nextNode, curNode, timeIn, timeOut);
		}
		timeOut[curNode] = cnt++;
	}

	public static boolean isAncestor(int u, int v) {
		boolean ret = false;
		if (timeIn[u] <= timeIn[v] && timeOut[v] <= timeOut[u])
			ret = true;
		return ret;
	}
}
