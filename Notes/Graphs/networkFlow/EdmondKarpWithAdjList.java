package networkFlow;


import java.io.*;
import java.util.*;

public class EdmondKarpWithAdjList {
	static int max = 20000;
	static ArrayList<Integer>[] resMap = new ArrayList[max];
	static int[][] res = new int[max][max]; 
	static int mf, f, s, t; //s is source t is sink
	public static void main(String args[]) {
		s = 0; t = 3; 
		for(int i = 0; i < max; i++) resMap[i] = new ArrayList<Integer>(); 
		resMap[0].add(1); //faster than the other edmondkarp but requires almost double the space 
		resMap[0].add(2); 
		resMap[1].add(2); 
		resMap[1].add(3); 
		resMap[2].add(3); 
		res[0][1] = 100; 
		res[0][2] = 100; 
		res[1][2] = 1; 
		res[1][3] = 100; 
		res[2][3] = 100; 
		long time = System.currentTimeMillis(); 
		System.out.println(edmondkarp()); 
		System.out.println("Time: " + (System.currentTimeMillis()-time));
	}

	
	
	static int[] p = new int[max]; 

	public static void augment(int v, int minEdge) {
		if (v == s) {
			f = minEdge;
			return;
		} else if (p[v] != -1) {
			augment(p[v], Math.min(minEdge, res[p[v]][v]));
			res[p[v]][v] -= f;
			res[v][p[v]] += f;
		}
	}

	public static int edmondkarp() {
		mf = 0;
		while(true) {
			f = 0; 
			int[] dist = new int[max]; Arrays.fill(dist, Integer.MAX_VALUE); dist[s] = 0; Queue<Integer> q = new LinkedList<Integer>(); q.add(s); 
			while(q.isEmpty() == false) {
				int u = q.poll(); 
				if(u == t) break; 
				for(int v = 0; v < resMap[u].size(); v++) {
					if(res[u][resMap[u].get(v)] > 0 && dist[resMap[u].get(v)] == Integer.MAX_VALUE) {
						dist[resMap[u].get(v)] = dist[u]+1; q.add(resMap[u].get(v)); p[resMap[u].get(v)] = u; 
					}
				}
			}
			augment(t, Integer.MAX_VALUE); 
			if(f == 0) break; 
			mf += f; 
		} 
		return mf; 
	}
}
