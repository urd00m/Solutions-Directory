package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: holstein
 */

import java.io.*;
import java.util.*;

public class holstein {
	static int v;
	static int[] vReq;
	static int g;
	static int[][] feedTypes;
	
	/*   BRUTE FORCE
	 *    from position 0 to v-1 is the feed vitamins, from v to 2v-1 is the amount need to statisfy the for that vitamin position -1 feed type if feed vit is zero set to negative one (infinity), 
	 *    the second last is the max of the vitamin satisfication and the last is the overflow, the smaller the better
	 */
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
		v = Integer.parseInt(f.readLine());
		vReq = new int[v];
		StringTokenizer in = new StringTokenizer(f.readLine());
		for(int i = 0; i < v; i++) {
			vReq[i] = Integer.parseInt(in.nextToken());
		}
		g = Integer.parseInt(f.readLine());
		feedTypes = new int[g][2*v+2];
		for(int i = 0; i < g; i++) { //huge input array 
			in = new StringTokenizer(f.readLine());
			for(int j = 0; j < 2*v+2; j++) {
				if(j < v) {
					feedTypes[i][j] = Integer.parseInt(in.nextToken());
				}
				else if(j < 2*v) {
					double store = (vReq[j-v]*1.0)/feedTypes[i][j-v];
					feedTypes[i][j] = (int)(Math.ceil(store)); 
					if(feedTypes[i][j] > feedTypes[i][2*v]) feedTypes[i][2*v] = feedTypes[i][j];
				}
			}
		}
		
		//algorithm
		//find least max positions
		int min = 99999999; 
		ArrayList<Integer> minPosition = new ArrayList<Integer>();
		for(int i = 0; i < g; i++ ) {
			if(feedTypes[i][2*v] < min) {
				minPosition.clear();
				minPosition.add(i);
			}
			else if(feedTypes[i][2*v] == min) {
				minPosition.add(i);
			}
		}
		//send it to figure out the correct amount of additional scopes needed 
		
	}
	
	public static int[] scoop(int[] a, int minimun) {
		int[] newScoop = new int[minimun+1];
		int overflow = 0; //add at start of return array
		for(int i = v; i < 2*v; i++) {
			if(a[i] > 1) {
				int needed = (int)(Math.ceil(((vReq[i-v]-a[i-v])/(vReq[i-v]*1.0))));
			}
		}
		
	}

}
