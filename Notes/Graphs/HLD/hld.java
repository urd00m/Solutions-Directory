package HLD;

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

//original code at https://ideone.com/EeDdrA
//RMQ w/ max edge weight not node RSQ 
public class hld {
	// problem specific variables
	static ArrayList<Integer> adj[];
	static int[] nodeVal;

	// HLD stuff
	static int subtree_size[], chain[], chainHead[], position[], chainId = 0, pos = 0;

	// LCA stuff
	static int parent[][], level[], MAX;

	// Segment tree related stuff
	static int n, arr[], tree[];

	public static void main(String[] args) {
		n = 5;
		adj = new ArrayList[n + 1];
		nodeVal = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			adj[i] = new ArrayList<Integer>();
		}
		nodeVal[1] = 1;
		nodeVal[2] = 2;
		nodeVal[3] = 4;
		nodeVal[4] = 8;
		nodeVal[5] = 16;
		adj[1].add(2);
		adj[2].add(1);
		adj[1].add(3);
		adj[3].add(1);
		adj[3].add(4);
		adj[4].add(3);
		adj[3].add(5);
		adj[5].add(3);
		init();
		
		
		String s = "QUERY"; 
		int u = 1; int v = 5; 
		if (s.equals("QUERY")) {
			int LCA = lca(u, v);
			int max = 0;
			max = max + queryUp(u, LCA) + queryUp(v, LCA) + nodeVal[LCA];
			System.out.println(max);
		} else {
			update(position[u], v); 
		}
		 u = 2;  v = 4; 
		if (s.equals("QUERY")) {
			int LCA = lca(u, v);
			int max = 0;
			max = max + queryUp(u, LCA) + queryUp(v, LCA) + nodeVal[LCA];
			System.out.println(max);
		} else {
			update(position[u], v); 
		}
		s = "UPDATE";
		u = 1; v = 16; 
		if (s.equals("QUERY")) {
			int LCA = lca(u, v);
			int max = 0;
			max = max + queryUp(u, LCA) + queryUp(v, LCA)+ nodeVal[LCA];
			System.out.println(max);
		} else {
			update(position[u], v); 
		}
		s = "QUERY";
		u = 3; v = 5; 
		if (s.equals("QUERY")) {
			int LCA = lca(u, v);
			int max = 0;
			max = max + queryUp(u, LCA) + queryUp(v, LCA)+ nodeVal[LCA];
			System.out.println(max);
		} else {
			update(position[u], v); 
		}
		s = "QUERY";
		u = 1; v = 5; 
		if (s.equals("QUERY")) {
			int LCA = lca(u, v);
			int max = 0;
			max = max + queryUp(u, LCA) + queryUp(v, LCA)+ nodeVal[LCA];
			System.out.println(max);
		} else {
			update(position[u], v); 
		}
		s = "QUERY";
		u = 1; v = 3; 
		if (s.equals("QUERY")) {
			int LCA = lca(u, v);
			int max = 0;
			max = max + queryUp(u, LCA) + queryUp(v, LCA)+ nodeVal[LCA];
			System.out.println(max);
		} else {
			update(position[u], v); 
		}

	}

	public static void init() { //* 
		chainId = 0;
		pos = 0;
		MAX = (int) (log(n) / log(2));
		parent = new int[n + 1][MAX + 1];
		chain = new int[n + 1];
		chainHead = new int[n + 1];
		position = new int[n + 1];
		subtree_size = new int[n + 1];
		arr = new int[n];
		level = new int[n + 1];
		int sz = (int) pow(2, ceil(log(n) / log(2)) + 1);
		tree = new int[sz];
		dfs(1, 0, 0);
		chainHead[0] = 1;
		arr[0] = nodeVal[1]; 
		HLD(1, 0);
		// print the array
		build(1, 0, n - 1);
	}

	static void dfs(int v, int par, int l) { //*
		parent[v][0] = par;
		for (int i = 1; i <= MAX; ++i) {
			if (parent[v][i - 1] != 0) {
				parent[v][i] = parent[parent[v][i - 1]][i - 1];
			}
		}
		subtree_size[v] += 1;
		level[v] = l;
		for (int item : adj[v]) {
			if (item != par) {
				dfs(item, v, l + 1);
				subtree_size[v] += subtree_size[item];
			}
		}
	}

	/**
	 * Decompose the tree into chains, keeping all of all values we need
	 */
	static void HLD(int v, int par) { //*
		int heavyChild = -1, heavySize = 0, heavyNodeWeight = -1;
		chain[v] = chainId;
		position[v] = pos++;
		for (int item : adj[v]) {
			if (item != par) {
				if (subtree_size[item] > heavySize) {
					heavySize = subtree_size[item];
					heavyChild = item;
					heavyNodeWeight = nodeVal[item];
				}
			}
		}
		if (heavyChild != -1) {
			arr[pos] = heavyNodeWeight;
			HLD(heavyChild, v);
		}
		for (int item : adj[v]) {
			if (item != par && item != heavyChild) {
				chainId++;
				chainHead[chainId] = item;
				arr[pos] = nodeVal[item];
				HLD(item, v);
			}
		}
	}

	/**
	 * Returns the maximum in path from node from to node to. Node to should be a
	 * ancestor of from. Uses the decomposition to reduce the number of queries to
	 * at most log(n)
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	static int queryUp(int from, int to) { //* 
		int curr = from;
		int ans = 0; 
		while (chain[curr] != chain[to]) {
			ans = ans + query(position[chainHead[chain[curr]]], position[curr]); //RSQ
			curr = parent[chainHead[chain[curr]]][0];
		}
		ans = ans + query(position[to] + 1, position[curr]); //RSQ
		return ans;
	}

	// calculates lca of node u and node v
	static int lca(int u, int v) { //*   Binary lifting 
		if (level[u] > level[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		int diff = level[v] - level[u];
		for (int i = MAX; i >= 0; --i) {
			if ((diff & (1 << i)) != 0) {
				v = parent[v][i];
			}
		}
		if (u == v) {
			return u;
		}
		for (int i = MAX; i >= 0; --i) {
			if (parent[u][i] != parent[v][i]) {
				u = parent[u][i];
				v = parent[v][i];
			}
		}
		return parent[u][0];
	}

	// segment tree build
	static void build(int treein, int low, int high) { //*
		if (low == high)
			tree[treein] = arr[low];
		else {
			int mid = (low + high) >> 1;
			build(2 * treein, low, mid);
			build(2 * treein + 1, mid + 1, high);
			tree[treein] = tree[2 * treein] + tree[2 * treein + 1]; //RSQ
		}
	}

	// segment tree update
	static void update(int treein, int low, int high, int idx, int val) { //*
		if (low == high)
			tree[treein] = val;
		else {
			int mid = (low + high) >> 1;
			if (idx <= mid)
				update(2 * treein, low, mid, idx, val);
			else
				update(2 * treein + 1, mid + 1, high, idx, val);
			tree[treein] = tree[2 * treein] + tree[2 * treein + 1]; //RSQ 
		}
	}

	// segment tree query
	static int query(int treein, int low, int high, int l, int r) { //*
		if (l <= low && high <= r)
			return tree[treein];
		if (low > r || high < l)
			return 0;
		int mid = (low + high) >> 1;
		return query(2 * treein, low, mid, l, r) + query(2 * treein + 1, mid + 1, high, l, r); //RSQ
	}

	static int query(int l, int r) { //*
		if (l > r) {
			return 0;
		}
		return query(1, 0, n - 1, l, r);
	}

	static void update(int idx, int val) { //*
		update(1, 0, n - 1, idx, val);
	}

	/*
	static class Pair implements Comparable<Pair> { //DELETE
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Pair other) {
			if (this.x != other.x)
				return this.x - other.x;
			return this.y - other.y;
		}

		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
	*/
}