package UFDS;

public class UnionFindDisjointSets {
	static int[] parent, size; 
	public static void main(String args[]) {
		//these are just the functions needed to run UFDS 
		//it allows you to find extremely quickly which item belongs to which set
		//it can also be used to find connections in a graph (competitve programming uses) 
		
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
}
