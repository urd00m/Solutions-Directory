//package Chapter3_2;
/*
ID: alan.li2
LANG: JAVA
TASK: kimbits
 */

import java.io.*;
import java.util.*;

public class kimbits {
	static long n,l,i; //size of strings, total 1's, and ith output 
	static long[][] sizeofs = new long[32][32];
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("kimbits.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		n = Long.parseLong(input.nextToken());
		l = Long.parseLong(input.nextToken());
		i = Long.parseLong(input.nextToken());
		f.close();
		
		//Algorithm: finding out it based on last digit 
	    initsizeofs();
		String binNum = recur(n, l, i);
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")));
		out.println(binNum); 
		out.close();
	}
	public static void initsizeofs() { //this is really genius, I had to look this up but it is really cool 
		for(int i = 0; i < 32; i++)
			sizeofs[0][i] = 1; 
		
		for(int i = 1; i < 32; i++) { //number of bits
			for(int j = 0; j < 32; j++) { //max number of 1's allowed 
				if(j == 0)
					sizeofs[i][j] = 1; 
				else
					sizeofs[i][j] = sizeofs[i-1][j-1] + sizeofs[i-1][j]; //it is the sum of the sets ending with a one and without a one 
			}
		}
	}
	
	public static String recur(long nbits, long nones, long index) {
		if(nbits == 0) 
			return ""; 
		if(index <= sizeofs[(int)(nbits-1)][(int)(nones)]) {
			return "0" + recur(nbits-1, nones, index); 
		}
		else 
			return "1" + recur(nbits-1, nones-1, index-sizeofs[(int)(nbits-1)][(int)(nones)]); 
	}
}
