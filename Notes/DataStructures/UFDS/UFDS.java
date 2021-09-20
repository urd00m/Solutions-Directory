package UFDS;
//This is the main UFDS library for competitive programmign
import java.util.*;

public class UFDS {
	public static void main(String args[]) {
		long time = System.currentTimeMillis();
		UnionFind test = new UnionFind(5); 
		test.unionSet(0, 1);
		test.unionSet(2, 3);
		test.unionSet(2, 4);
		test.unionSet(0, 4);
		System.out.println(test.numDisjointSets());
		System.out.println(test.isSameSet(0, 4));
		System.out.println("Total time used " + (System.currentTimeMillis()-time)); 
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
