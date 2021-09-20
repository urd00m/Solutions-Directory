package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: ariprog
 */

import java.util.*;
import java.io.*;
public class ariprog {
	static boolean[] marker = new boolean[125001];
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
		int n = Integer.parseInt(f.readLine()); //length of progressions 
		int m = Integer.parseInt(f.readLine()); //upper bound of bisqure
		//calculate bisquares
		int[] bisqr = new int[((m+1)*(m+2))/2];
		
		int counter = 0; 
		for(int i = 0; i <= m; i++) {
			for(int j = i; j <= m; j++) {
				bisqr[counter] = (int)(Math.pow(i, 2) + Math.pow(j, 2));
				marker[(int)(Math.pow(i, 2) + Math.pow(j, 2))] = true;
				counter++;
			}
		}
		Arrays.sort(bisqr);
		//see if it is in the sequence 
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		for(int i = 1; i <= 750; i++) { //step size
			for(int z = 0; z < bisqr.length-n; z++) { // staring position
				boolean answer = true;
				if(z > 0 && bisqr[z-1] == bisqr[z]) answer = false;
				for(int j = 0; j < n; j++) {  //amount of iterations
					//if(bisqr[z] == 1) System.out.println(marker[bisqr[z]+j*i] + " " + (bisqr[z]+j*i));
					if(bisqr[z]+j*i < 125001 && !(marker[bisqr[z]+j*i])) answer = false;  
				}
				if(answer == true) {
					x.add(bisqr[z]);
					y.add(i);
				}
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
		for(int i = 0; i < x.size(); i++) {
			out.println(x.get(i) + " " + y.get(i));
		}
		if(x.size() == 0) {
			out.println("NONE");
		}
		out.close();
	}
		
}


