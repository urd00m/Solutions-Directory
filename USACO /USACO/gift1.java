package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: gift1
 */

import java.util.*;
import java.io.*;
public class gift1 {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		int NP = Integer.parseInt(f.readLine());
		String[] names = new String[NP];
		int[] cash = new int[NP];
		for(int i = 0; i < NP; i++) {
			names[i] = f.readLine();
		}
		
		int cashG = 0;
		int x;
		int y;
		for(int i = 0; i < NP; i++) {
			f.readLine();
			StringTokenizer a = new StringTokenizer(f.readLine());
			x = Integer.parseInt(a.nextToken());
			y = Integer.parseInt(a.nextToken());
			cash[i] = x%y;
			if( y != 0 ) {
				for(int j = 0; j < y; j++) {
					String c = f.readLine();
					for(int b = 0; b < names.length; b++) {
						if(names[b].equals(c)) cash[b] += (int)(x/y); 
					}
				}
			}
		}
		
		for(int i = 0; i < NP; i++) {
			out.println(names[i] + " " + cash[i]);
		}
	}

}
