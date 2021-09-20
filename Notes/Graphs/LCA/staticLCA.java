package LCA;
import java.util.*;

public class staticLCA {
	static ArrayList<Integer>[] graph;
	static sparseTableDT rmq; 
	public static void main(String args[]) {
		graph = new ArrayList[6]; 
		for(int i = 0; i < 6; i++) {
			graph[i] = new ArrayList<Integer>(); 
		}
		graph[0].add(1); 
		graph[1].add(0); 
		
		graph[0].add(2); 
		graph[2].add(0); 
		
		graph[2].add(4);
		graph[4].add(2); 
		
		graph[1].add(3); 
		graph[3].add(1); 
		
		graph[1].add(5); 
		graph[5].add(1); 
		buildRMQ(); 
		System.out.println(rmq.query(3, 4));         
		
	}
	static int maxN = 6; 
	static int[] l = new int[2*maxN], e = new int[2*maxN], h = new int[maxN]; 
	static int idx; 
	
	
	public static void buildRMQ() {
		idx = 0; 
		dfs(0,0, -1); 
		rmq = new sparseTableDT(2*maxN, l); 
	}
	
	public static void dfs(int cur, int depth, int par) {
		h[cur] = idx;
		e[idx] = cur; 
		l[idx++] = depth; 
		for(int i = 0; i  < graph[cur].size(); i++) {
			if(graph[cur].get(i) != par) {
				dfs(graph[cur].get(i), depth+1, cur); 
				e[idx] = cur; 
				l[idx++] = depth; 
			}
		}
	}
	//sparse table data structure
	public static class sparseTableDT {
		public int MAX_N = 1000000;
		public int LOG_TWO_N = 20;
		public int[] _A; int[][] SpT; 
		public sparseTableDT(int n, int[] A) {
			_A = new int[n]; 
			SpT = new int[n][(int)(Math.log10(n*1.0)/Math.log10(2.0) + 1)]; 
			for(int i = 0; i < n; i++) {
				_A[i] = A[i]; 
				SpT[i][0] = i; //RMQ of sub array starting at index i+length 2^0=1
			}
			for(int j = 1; (1<<j) <= n; j++) {
				for(int i = 0; i + (1<<j)-1 < n; i++) {
					if(_A[SpT[i][j-1]] < _A[SpT[i+(1<<(j-1))][j-1]]) {
						SpT[i][j] = SpT[i][j-1]; 
					}
					else {
						SpT[i][j] = SpT[i+(1<<(j-1))][j-1]; 
					}
				} 
			}
		}
		public int query(int i, int j) {
			i = h[i]; 
			j = h[j]; 
			int k = (int)Math.floor(Math.log10((double)j-i+1)/Math.log10(2.0)); 
			if(_A[SpT[i][k]] <= _A[SpT[j-(1<<k)+1][k]]) return e[SpT[i][k]]; 
			else return e[SpT[j-(1<<k)+1][k]];
		}
	}
}
