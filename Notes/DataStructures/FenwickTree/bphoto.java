package FenwickTree;
//package janGold2017;
/*
ID: alwang
LANG: JAVA
TASK: bphoto
 */
import java.util.*;
import java.io.*;

public class bphoto {
	static int n; 
	static pair[] heights; 
	static int[] BItree; 
	static int output = 0; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("bphoto.in")); 
		n = Integer.parseInt(f.readLine()); 
		heights = new pair[n]; BItree = new int[n+1]; 
		for(int i = 0; i < n; i++) {
			heights[i] = new pair(Integer.parseInt(f.readLine()), i+1); 
		}
		f.close();
		
		//sorting
		Arrays.sort(heights, new Comparator<pair>() { //decreasing order 
			@Override
			public int compare(pair a, pair b) {
				return b.v-a.v; 
			}
		});
		
		//algorithm: sort it in decreasing order and fenwick tree to figure out the ones after and before so the algorithm is O(3NLogN) which is 48 million operations  
		for(int i = 0; i < n; i++) {
			pair cur = heights[i]; 
			int l = sum(cur.i); //total greater on the left 
			int r = sum(n) - l; //total greater on the right 
			int a = Math.max(l, r); int b = Math.min(l, r);
			if(b*2<a) output++;  
			update(cur.i); 
		}
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bphoto.out"))); 
		out.println(output); 
		out.close();
	}
	
	public static void update(int cur) {
		while(cur < n+1) {
			BItree[cur]++; 
			cur += (cur)&(-cur); 
		}
	}
	public static int sum(int cur) {
		int sum = 0; 
		while(cur > 0) {
			sum += BItree[cur]; 
			cur -= (cur)&(-cur); 
		}
		return sum; 
	}
	
	
	public static class pair {
		int v, i; 
		public pair(int a, int b) {
			v = a; 
			i = b; 
		}
	}
}
