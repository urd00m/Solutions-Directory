package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: wormhole
 */

import java.util.*;
import java.io.*;

public class wormhole {
	static int num;
	static int[] X;
	static int[] Y;
	static int[] partner;
	static int[] nextRight;
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		//input
		num = Integer.parseInt(f.readLine());
		X= new int[num+1];
		Y= new int[num+1];
		partner = new int[num+1];
		nextRight = new int[num+1];
		for(int i = 1; i <= num; i++) {
			StringTokenizer in = new StringTokenizer(f.readLine());
			X[i] = Integer.parseInt(in.nextToken());
			Y[i] = Integer.parseInt(in.nextToken());
		}
		//find next right
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= num; j++) {
				if(X[j] > X[i] && Y[j] == Y[i]) {
					if((X[j] - X[i]) < (X[nextRight[i]]-X[i]) || nextRight[i] == 0)
						nextRight[i] = j;
				}
			}
		}
		/*
		for(int i = 0; i <= num; i++) {
			System.out.println("Index " + i + ": " + X[i] + "," + Y[i] + " " + "partner " + partner[i] + " nextRight " + nextRight[i]);
		}
		*/
		//solving 
		out.println(solve());
		out.close();

	}
	
	public static int solve() {
		int total = 0;
		//look for unpartnered 
		int i = 1;
		for(; i <= num; i++) 
			if(partner[i] == 0) break;
		//base case
		if(i > num) {  //out of unpaired so completely paired up now
			return isCycle();
		}
		//pairing the one that was unpaired with something that also isn't paired
		for(int j = i+1; j <= num; j++) {
			if(partner[j] == 0) {
				//assign the partners
				partner[i] = j;
				partner[j] = i;
				total += solve();
				//reset 
				partner[i] = 0;
				partner[j] = 0;
			}
		}
		
		return total;
	}
	
	public static int isCycle() {
		int pos; 
		for(int i = 1; i <= num; i++) {
			pos = i; 
			for(int count = 1; count <= num; count++) {
					pos = nextRight[partner[pos]]; 
			}
			if(pos != 0) return 1;
		}
		return 0;
	}

}
