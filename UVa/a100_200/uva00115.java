package a100_200;
/*
ID: urd00m 
LANG: JAVA
TASK: uva00115
 */
import java.io.*; 
import java.util.*;

public class uva00115 {
	static HashMap<String, Integer> convert = new HashMap<String, Integer>(); 
	static ArrayList<Integer>[] graph; 
	static int maxN;
	static ArrayList<sparseTableDT> rmq = new ArrayList<sparseTableDT>(); //contains the LCA of the different family trees 
	static UnionFind famTree = new UnionFind(300); 
	static int[] treeIds, nodeDepth; 
	public static void main(String args[]) throws IOException, InterruptedException {
		//input 
		Thread.sleep(3000);
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input = new StringTokenizer(f.readLine()); 
		String cur1 = input.nextToken(), cur2 = input.nextToken(); 
		int id = 0; //will number of nodes in the tree 
		int[] in = new int[300]; 
		graph = new ArrayList[305]; 
		for(int i = 0; i < 305; i++) graph[i] = new ArrayList<Integer>(); 
		while(cur1.equals("no.child") == false) {
			int id1 = -1, id2 = -1; 
			if(convert.containsKey(cur1) == false) {
				convert.put(cur1, id);
				id1 = id++; 
			}
			else id1 = convert.get(cur1); 
			if(convert.containsKey(cur2) == false) {
				convert.put(cur2, id);
				id2 = id++; 
			}
			else id2 = convert.get(cur2); 
			if(famTree.isSameSet(convert.get(cur1), convert.get(cur2)) == true) {
				graph[id2].add(id1); 
			}
			else {
				famTree.unionSet(id1, id2);
				graph[id2].add(id1); 
			}
			in[id1]++; 
			input = new StringTokenizer(f.readLine()); 
			cur1 = input.nextToken(); cur2 = input.nextToken(); 
		}
		//determining the different trees 
		int idOfTree = 0; 
		treeIds = new int[id]; 
		nodeDepth = new int[id]; 
		maxN = id; 
		for(int i = 0; i < id; i++) {
			if(in[i] == 0) {
				buildRMQ(i, idOfTree++); 
			}
		}
		//queries 
		while(f.ready() == true) {
			input = new StringTokenizer(f.readLine()); 
			cur1 = input.nextToken(); cur2 = input.nextToken(); 
			if(convert.containsKey(cur1) == true && convert.containsKey(cur2) == true) { //both have been mentioned 
				int id1 = convert.get(cur1); int id2 = convert.get(cur2); 
				if(famTree.isSameSet(id1, id2) == true) {
					int lca = rmq.get(treeIds[id1]).query(id1, id2); 
					//determining parent relation 
					if(lca == id1 && (Math.abs(nodeDepth[id1]-nodeDepth[id2]) == 1)) System.out.println("parent"); 
					else if(lca == id2 && (Math.abs(nodeDepth[id1]-nodeDepth[id2]) == 1)) System.out.println("child");
					else if(lca == id1) { //grand parent 
						System.out.println(gen("great", "grand parent", nodeDepth[id2]-nodeDepth[id1]));
					}
					else if(lca == id2) {
						System.out.println(gen("great", "grand child", nodeDepth[id1]-nodeDepth[id2])); 
					}
					else if(lca != id1 && lca != id2) {
						if(nodeDepth[id1]-nodeDepth[lca] == 1 && nodeDepth[id2]-nodeDepth[lca] == 1) System.out.println("sibling");
						else {
							int c1 = nodeDepth[id1]-nodeDepth[lca]-1; 
							int c2 = nodeDepth[id2]-nodeDepth[lca]-1; 
							String ret = ""; 
							ret += Math.min(c1, c2) + " cousin"; 
							if(c1 != c2) ret += " removed " + (Math.abs(c1-c2)); 
							System.out.println(ret); 
						}
					}
				}
				else System.out.println("no relation");
			}
			else {
				System.out.println("no relation");
			}
		}
		
	}
	
	
	public static String gen(String rep1, String end, int numTimes) {
		String ret = ""; 
		for(int i = 0; i < numTimes-2; i++) {
			ret += rep1 + " "; 
		}
		ret += end; 
		return ret; 
	}

	static int[] l, e, h;
	static int idx;

	public static void buildRMQ(int source, int idOfTree) {
		l = new int[2 * maxN]; e =  new int[2 * maxN]; h = new int[2 * maxN];  
		idx = 0;
		dfs(source, 0, -1, idOfTree);
		rmq.add(new sparseTableDT(2 * maxN, l, h, e));
	}

	public static void dfs(int cur, int depth, int par, int idOfTree) {
		h[cur] = idx;
		e[idx] = cur;
		l[idx++] = depth;
		nodeDepth[cur] = depth; 
		treeIds[cur] = idOfTree; //every node is stated to be in this specific tree 
		for (int i = 0; i < graph[cur].size(); i++) {
			if (graph[cur].get(i) != par) {
				dfs(graph[cur].get(i), depth + 1, cur, idOfTree);
				e[idx] = cur;
				l[idx++] = depth;
			}
		}
	}

	// sparse table data structure
	public static class sparseTableDT {
		public int MAX_N = 1000000;
		public int LOG_TWO_N = 20;
		public int[] _A;
		int[][] SpT;
		int[] h; int[] e; 
		public sparseTableDT(int n, int[] A, int[] a, int[] b) {
			_A = new int[n];
			SpT = new int[n][(int) (Math.log10(n * 1.0) / Math.log10(2.0) + 1)];
			for (int i = 0; i < n; i++) {
				_A[i] = A[i];
				SpT[i][0] = i; // RMQ of sub array starting at index i+length 2^0=1
			}
			for (int j = 1; (1 << j) <= n; j++) {
				for (int i = 0; i + (1 << j) - 1 < n; i++) {
					if (_A[SpT[i][j - 1]] < _A[SpT[i + (1 << (j - 1))][j - 1]]) {
						SpT[i][j] = SpT[i][j - 1];
					} else {
						SpT[i][j] = SpT[i + (1 << (j - 1))][j - 1];
					}
				}
			}
			h = a; 
			e = b; 
		}

		public int query(int i, int j) { // modified from originally library implementation specifically for LCA
			int i1 = Math.min(h[i], h[j]); 
			int j1 = Math.max(h[i], h[j]); 
			i = i1;
			j = j1;
			int k = (int) Math.floor(Math.log10((double) j - i + 1) / Math.log10(2.0));
			if (_A[SpT[i][k]] <= _A[SpT[j - (1 << k) + 1][k]])
				return e[SpT[i][k]];
			else
				return e[SpT[j - (1 << k) + 1][k]];
		}
	}
	
	public static class UnionFind { 
		public int[] p, rank, size; 
		public int numSets; 
		public UnionFind(int n) {
			p = new int[n]; rank = new int[n]; numSets = n; size = new int[n]; 
			for(int i = 0; i < n; i++) {
				p[i] = i;
				size[i] = 1; 
			}
		}
		public int findSet(int i) { //finds parent
			return (p[i] == i) ? i : (p[i]= findSet(p[i])); 
		}
		public boolean isSameSet(int i, int j) {		//checks if they are the same set
			return (findSet(i) == findSet(j)); 
		}
		public void unionSet(int i, int j) {		//merges 2 sets
			if(!isSameSet(i, j)) {
				int x = findSet(i); int y = findSet(j); 
				if(rank[x] > rank[y]) {
					p[y] = x;
					size[x]+=size[y]; 
					
				}
				else {
					p[x] = y;
					size[y] += size[x]; 
					if(rank[x] == rank[y]) rank[y]++; 
				}
				numSets--; 
			}
		}
		public int sizeOfSet(int i) { 		//returns the size of the set
			return size[findSet(i)]; 
		}
		public int numDisjointSets() {		//returns the total number of sets 
			return numSets; 
		}
	}
}
