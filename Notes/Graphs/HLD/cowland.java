package HLD;
//package febGold2019;
import java.util.*;
import java.io.*;
import static java.lang.Math.*; 
public class cowland {
		static ArrayList<Integer> adj[];
		static int[] nodeVal;
		static int subtree_size[], chain[], chainHead[], position[], chainId = 0, pos = 0;
		static int parent[][], level[], MAX;
		static int n, arr[], tree[];
		static int q; 
		public static void main(String[] args) throws IOException {
			//input
			BufferedReader f = new BufferedReader(new FileReader("cowland.in")); StringTokenizer input = new StringTokenizer(f.readLine()); 
			n = Integer.parseInt(input.nextToken()); q = Integer.parseInt(input.nextToken()); 
			adj = new ArrayList[n + 1];
			nodeVal = new int[n + 1];
			for (int i = 1; i <= n; ++i) {
				adj[i] = new ArrayList<Integer>();
			}
			input = new StringTokenizer(f.readLine()); 
			for(int i = 1; i < n+1; i++) {
				nodeVal[i] = Integer.parseInt(input.nextToken()); 
			}
			for(int i = 0; i < n-1; i++) { //edges 
				input = new StringTokenizer(f.readLine()); 
				int a = Integer.parseInt(input.nextToken()); int b = Integer.parseInt(input.nextToken()); 
				adj[a].add(b); adj[b].add(a); 
			}
			init(); 
			dfs(1, 0, 0);  //HLD
			HLD(1, 0); 
			build(1, 0, n - 1);
		
			//output
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowland.out"))); 
			for(int i = 0; i < q; i++) {
				input = new StringTokenizer(f.readLine()); 
				int type = Integer.parseInt(input.nextToken()); int u = Integer.parseInt(input.nextToken()); int v = Integer.parseInt(input.nextToken()); 
				if (type == 2) {
					int LCA = lca(u, v);
					out.println( (queryUp(u, LCA) ^ queryUp(v, LCA) ^ nodeVal[LCA]) );
				} else {
					update(position[u], v); 
					nodeVal[u] = v; 
				}
			}
			out.close();
		}
		public static void init() { //**
			
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
			chainHead[0] = 1;
			arr[0] = nodeVal[1]; 
		}
		static void dfs(int v, int par, int l) { //**
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
		static void HLD(int v, int par) { //**
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
		static int queryUp(int from, int to) { //* *
			int curr = from;
			int ans = 0; 
			while (chain[curr] != chain[to]) {
				ans = ans ^ query(position[chainHead[chain[curr]]], position[curr]); //xor
				curr = parent[chainHead[chain[curr]]][0];
			}
			ans = ans ^ query(position[to] + 1, position[curr]); //RSQ
			return ans;
		}

		// calculates lca of node u and node v
		static int lca(int u, int v) { //**   Binary lifting 
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
				tree[treein] = tree[2 * treein] ^ tree[2 * treein + 1]; //RSQ
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
				tree[treein] = tree[2 * treein] ^ tree[2 * treein + 1]; //RSQ 
			}
		}

		// segment tree query
		static int query(int treein, int low, int high, int l, int r) { //*
			if (l <= low && high <= r)
				return tree[treein];
			if (low > r || high < l)
				return 0;
			int mid = (low + high) >> 1;
			return query(2 * treein, low, mid, l, r) ^ query(2 * treein + 1, mid + 1, high, l, r); //RSQ
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
}
