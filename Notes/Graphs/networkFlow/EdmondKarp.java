package networkFlow;

import java.io.*;
import java.util.*;

public class EdmondKarp {
	static int max = 20000;
	static int[][] res = new int[max][max];
	static int mf, f, s, t; //s is source t is sink
	public static void main(String args[]) {
		s = 0; t = 3; 
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
				for(int v = 0; v < max; v++) {
					if(res[u][v] > 0 && dist[v] == Integer.MAX_VALUE) {
						dist[v] = dist[u]+1; q.add(v); p[v] = u; 
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
