package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: milk2
 */

import java.util.*;
import java.io.*;

public class milk2 {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

		int length = Integer.parseInt(f.readLine());
		String[] input = new String[length];
		for(int i = 0; i< length; i++) {
			input[i] = f.readLine();
		}
		

		StringTokenizer a = new StringTokenizer(input[0]);
		StringTokenizer b = new StringTokenizer("");

		int range1 = Integer.parseInt(a.nextToken());
		int range2 = Integer.parseInt(a.nextToken());
		int rangeb1 = -1;
		int rangeb2 = -1;
		if(length == 1) {
			a = new StringTokenizer(input[0]);
			int d1 = Integer.parseInt(a.nextToken());
			int d2 = Integer.parseInt(a.nextToken());
			range1 = d1;
			range2 = d2;
		}
		for(int i = 1; i < length-1; i++) {
			int saveSize = 0;
			a = new StringTokenizer(input[i]);
			b = new StringTokenizer(input[i+1]);
			int d1 = Integer.parseInt(a.nextToken());
			int d2 = Integer.parseInt(a.nextToken());
			int e1 = Integer.parseInt(b.nextToken());
			int e2 = Integer.parseInt(b.nextToken());
			if((d2 < range2 && d2 > range1) || (d1 < range2 && d1 > range1) || (e2 < range2 && e2 > range1) || (e1 < range2 && e1 > range1)) {
				if(d2 < range2 && d2 > range1 && d1 < range1) range1 = d1;
				if(d1 < range2 && d1 > range1 && d2 > range2) range2 = d2;
				if(e2 < range2 && e2 > range1 && e1 < range1) range1 = e1;
				if(e1 < range2 && e1 > range1 && e2 > range2) range2 = e2;
			}
			else {

			}

		}
		out.print((range2-range1) + " " + (rangeb2 - rangeb1));
		out.println();
		out.close();
		
				
	}

}
