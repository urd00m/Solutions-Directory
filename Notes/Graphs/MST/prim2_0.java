package MST;

import java.util.*;
import java.io.*;

public class prim2_0 {
	
	
	
	static PriorityQueue<pair> pq = new PriorityQueue<pair>(5, new pair()); 
	static int[] taken;  //size num of nodes
	static ArrayList<pair>[] AdjList; 
	
	public static void main(String args[]) {
		AdjList = new ArrayList[5]; 
		for(int i = 0; i < 5; i++) AdjList[i] = new ArrayList<pair>(); 
		AdjList[0].add(new pair(1, 4)); AdjList[0].add(new pair(2, 4)); AdjList[0].add(new pair(3, 6)); AdjList[0].add(new pair(4, 6));
		AdjList[4].add(new pair(0, 6)); AdjList[4].add(new pair(3, 9));  
		AdjList[3].add(new pair(4, 9)); AdjList[3].add(new pair(0, 6)); AdjList[3].add(new pair(2, 8));
		AdjList[2].add(new pair(3, 8)); AdjList[2].add(new pair(0, 4)); AdjList[2].add(new pair(1, 2));
		AdjList[1].add(new pair(0, 4)); AdjList[1].add(new pair(2, 2));
		long time = System.currentTimeMillis(); 
		System.out.println(prim(5)); 
		System.out.println("Time Taken: " + (System.currentTimeMillis()-time));
	}
	
	
	
	public static int prim(int n) {
		int mst_cost  = 0; 
		taken = new int[n]; 
		process(0); 
		while(pq.isEmpty() == false) {
			pair front = pq.remove(); 
			int u = front.destination; 
			int w = front.weight; 
			if(taken[u] == 0) {
				mst_cost += w; process(u); 
			}
		}
		return mst_cost; 
	}
	
	public static void process(int vtx) {
		taken[vtx] = 1; 
		for(int j = 0; j < AdjList[vtx].size(); j++) {
			pair v=  AdjList[vtx].get(j); 
			if(taken[v.destination] == 0) pq.add(new pair(v.destination, v.weight)); 
		}
	}
	public static class pair implements Comparator<pair> {
		int destination; 
		int weight; 
		public pair() {
		}
		public pair(int a, int b) {
			destination = a; 
			weight = b; 
		}
		@Override
		public int compare(pair o1, pair o2) {
			return o1.weight - o2.weight;
		}
	}
}
	
