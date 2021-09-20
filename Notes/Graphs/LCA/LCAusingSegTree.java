package LCA;

import java.util.ArrayList;

public class LCAusingSegTree {
	int[] height, first, segtree;
	ArrayList<Integer> euler = new ArrayList<Integer>();
	boolean[] visited;
	int n;
	ArrayList<Integer>[] adj;

	public LCAusingSegTree(int a, ArrayList<Integer>[] graph) {
		n = a; 
		adj = graph; 
		n = adj.length;
		height = new int[n]; // size n
		first = new int[n]; // size n*2
		visited = new boolean[n];
		dfs(0, 0); 
		int m = euler.size();
		segtree =  new int[m*4]; //size m*4
		build(1, 0, m-1);
	}

	public void dfs(int node, int h) {
		visited[node] = true;
		height[node] = h;
		first[node] = euler.size();
		euler.add(node);
		for (int to : adj[node]) {
			if (visited[to] == false) {
				dfs(to, h+1);
				euler.add(node);
			}
		}
	}

	public void build(int node, int b, int e) {
		if (b == e) {
            segtree[node] = euler.get(b);
        } else {
            int mid = (b + e) / 2;
            build(node << 1, b, mid);
            build(node << 1 | 1, mid + 1, e);
            int l = segtree[node << 1], r = segtree[node << 1 | 1];
            segtree[node] = (height[l] < height[r]) ? l : r;
        }
	}
	
	public int query(int node, int b, int e, int L, int R) {
		if (b > R || e < L)
            return -1;
        if (b >= L && e <= R)
            return segtree[node];
        int mid = (b + e) >> 1;

        int left = query(node << 1, b, mid, L, R);
        int right = query(node << 1 | 1, mid + 1, e, L, R);
        if (left == -1) return right;
        if (right == -1) return left;
        return height[left] < height[right] ? left : right;
	}
	
	public int lca(int u, int v) {
		int left = first[u], right = first[v];
        if (left > right) {
            int temp = right; 
            right = left;
            left = temp; 
        }
        return query(1, 0, euler.size() - 1, left, right);
	}
	public static void main(String args[]) {
		long time = System.currentTimeMillis(); 
		ArrayList<Integer>[] graph = new ArrayList[6]; 
		for(int i = 0; i < 6; i++) graph[i] = new ArrayList<Integer>(); 
		graph[0].add(5);
		graph[0].add(1); 
		graph[0].add(2); 
		graph[5].add(0); 
		graph[1].add(0); 
		graph[2].add(0); 
		graph[2].add(3);
		graph[2].add(4); 
		graph[3].add(2);
		graph[4].add(2); 
		LCAusingSegTree test = new LCAusingSegTree(6, graph); 
		System.out.println(test.lca(3, 4)); 
		System.out.println( (System.currentTimeMillis()-time) );
	}
}
