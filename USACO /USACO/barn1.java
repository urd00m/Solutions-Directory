package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: barn1
 */

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class barn1 {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		StringTokenizer in = new StringTokenizer(f.readLine());
		int M = Integer.parseInt(in.nextToken()); //The maximum number of boards
		int S = Integer.parseInt(in.nextToken()); //The total number of stalls 
		int C = Integer.parseInt(in.nextToken()); //The number of cows in the stall and the occupied stall number
		//read 
		int[] stalls = new int[C];
		for(int i = 0; i < C; i++) {
			stalls[i] = Integer.parseInt(f.readLine());
		}
		Arrays.sort(stalls); 
		//find the max difference	
		space[] mdifLocation = new space[M+1];
		for(int i = 0; i < M+1; i++) {
			mdifLocation[i] = new space();
		}
		mdifLocation[M].changeLoc(C-1);
		mdifLocation[0].changeLoc(-1);
		for(int i = 0; i < C-1; i++) {
			fill(stalls[i+1]-stalls[i], i, mdifLocation);
		}

		//total stalls 
		int Stot = 0;
		int index;
		int end; 
		for(int i = 0; i < M; i++) {
			index = mdifLocation[i].getLoc()+1;
			end = mdifLocation[i+1].getLoc();
			Stot = Stot + stalls[end] - stalls[index]+1;
		}
		if(M >= C) {
			out.println(C); 
			out.close();
		}
		else {
			out.println(Stot);
			out.close();
		}
	}
	
	//figures out if the return difference is greater then the ones recorded
	public static void fill(int dif, int loc, space[] a) {
		int dif3, loc3;
		for(int i = a.length-2; i > 0; i--) {
			if(a[i].getDif() < dif) {
				 dif3 = a[i].getDif();
				 loc3 = a[i].getLoc();
				a[i].changeDif(dif);
				a[i].changeLoc(loc);
				dif = dif3;
				loc = loc3;
			}
		}
	}
	
	private static class space {
		int dif = 0;
		int location;
		space(int a, int b) {
			dif =a;
			location =b;
		}
		space() {
			dif =0;
		}
		public int getDif() {
			return dif;
		}
		public void changeDif(int a) {
			dif = a;
		}
		public void changeLoc(int a) {
			location = a;
		}
		public int getLoc() {
			return location; 
		}
	}

}
