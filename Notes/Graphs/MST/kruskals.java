package MST;

import java.util.*;
import java.io.*;


//takes twice as long as prim's algorithm but it is enough to pass the test case and has advantages over prims 
public class kruskals {
	static int n; //num nodes
	static int e; //num edges 
	public static void main(String args[]) {
		ArrayList<pair> edgeList = new ArrayList<pair>(); 
		edgeList.add(new pair(0,1,4));
		edgeList.add(new pair(0,4,6));
		edgeList.add(new pair(0,3,6));
		edgeList.add(new pair(0,2,4));
		edgeList.add(new pair(3,4,9));
		edgeList.add(new pair(3,2,8));
		edgeList.add(new pair(1,2,2));
		n = 5; 
		e = 7;
		long time = System.currentTimeMillis(); 
		System.out.println(kruskals(edgeList));
		System.out.println("Time taken: " + (System.currentTimeMillis()-time));
	}
	
	
	//param: takes in a edgeList (unsorted) 
	//ret: the MST cost (can be modified to also print the path 
	//Note: the num of disjoint sets should be 1 after running 
	//runs slower then prims (due to sorting) 
	public static int kruskals(ArrayList<pair> edgeList) {
		Collections.sort(edgeList, new Comparator<pair>() {
			@Override
			public int compare(pair a, pair b) {
				return a.weight-b.weight; 
			}
		});
		int mst_cost = 0; 
		UnionFind UF = new UnionFind(n);
		for(int i = 0; i < e; i++) {
			pair cur = edgeList.get(i);
			if(!UF.isSameSet(cur.node1, cur.node2)) {
				mst_cost += cur.weight;
				UF.unionSet(cur.node1, cur.node2);
			}
		}
		assert(UF.numDisjointSets() == 1); //debugging purposes the num of disjoint sets has to equal zero when printing out solution 
		return mst_cost;
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
	public static class pair {
		int node1;
		int node2; 
		int weight; 
		public pair() {
		}
		public pair(int a, int b, int c) {
			node1 = a; 
			node2 = b; 
			weight = c; 
		}
	}
}
