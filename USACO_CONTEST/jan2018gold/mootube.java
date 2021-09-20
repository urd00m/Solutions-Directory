//package jan2018gold;
/*
ID: alwang
LANG: JAVA
TASK: mootube
 */
import java.io.*;
import java.util.*;

public class mootube {
	static int n, q; 
	static edge[] edgeList; 
	static query[] queries; 
	static int[] parent;
	static int[] size; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("mootube.in"));
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); q = Integer.parseInt(input.nextToken()); 
		init(); 
		for(int i = 0; i < n-1; i++) {
			input = new StringTokenizer(f.readLine()); 
			int a = Integer.parseInt(input.nextToken())-1; int b = Integer.parseInt(input.nextToken())-1; int c = Integer.parseInt(input.nextToken()); 
			edgeList[i] = new edge(a, b, c); 
		}
		for(int i = 0; i < q; i++) {
			input = new StringTokenizer(f.readLine()); 
			int a = Integer.parseInt(input.nextToken()); int b = Integer.parseInt(input.nextToken())-1; 
			queries[i] = new query(a, b, i); 
		}
		//sorting
		Arrays.sort(queries, new Comparator<query>(){
			@Override
			public int compare(query a, query b) {
				return b.k - a.k; 
			}
		});
		Arrays.sort(edgeList, new Comparator<edge>() {
			@Override
			public int compare(edge a, edge b) {
				return b.w-a.w; 
			}
		}); 
		f.close();
		
		//algorithm UFDS
		parent = new int[n]; 
		size = new int[n]; 
		for(int i = 0; i < n; i++) {
			parent[i] = i; 
			size[i] = 1; 
		}
		int[] output = new int[q]; 
		int idx = 0; 
		for(query cur : queries) {
			while(idx < n-1 && edgeList[idx].w >= cur.k) {
				merge(edgeList[idx].a, edgeList[idx].b); 
				idx++; 
			}
			output[cur.i] = getSize(cur.start)-1; 
		}
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out"))); 
		for(int item : output) out.println(item);
		out.close();
	}
	public static int getSize(int a) {
		return size[find(a)]; 
	}
	public static void merge(int a, int b) {
		int x = find(a); 
		int y = find(b); 
		parent[x] = y; 
		size[y] += size[x]; 
	}
	public static int find(int a) {
		return parent[a] == a ? a : (parent[a] = find(parent[a]));
	}
	public static void init() {
		edgeList = new edge[n-1]; 
		queries = new query[q];
	}
	public static class edge  {
		int a, b, w; 
		public edge(int x, int y, int z) {
			a = x;
			b = y; 
			w = z; 
		}
	}
	public static class query {
		int start, k, i; 
		public query(int a, int b, int c) {
			k = a; 
			start = b; 
			i = c; 
		}
	}
}
