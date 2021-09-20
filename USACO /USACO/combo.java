package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: combo
 */
import java.util.*;
import java.io.*;
public class combo {
	public static void main(String args[]) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		
		//input
		int n = Integer.parseInt(f.readLine());
		StringTokenizer in = new StringTokenizer(f.readLine());
		StringTokenizer in1 = new StringTokenizer(f.readLine());
		int[] comb1 = new int[3];
		int[] comb2 = new int[3];
		for(int i = 0; i < 3; i++) {
			comb1[i] = Integer.parseInt(in.nextToken());
			comb2[i] = Integer.parseInt(in1.nextToken());
		}
		
		//algorithm
		//count the overlap and subtract from 2*5*5*5 = 250
		int[] overlap = new int[3];
		int a; 
		int b;
		for(int i = 0; i < 3; i++) {
			a = comb1[i]%n;
			b = comb2[i]%n;
			if(a >= b) {
				overlap[i] = (a-2)-(b+2);
			}
			else {
				overlap[i] = (b-2)-(a+2);
			}
		}
		int sub = 0;
		for(int g : overlap) {
			if(g > 1) continue;
			int num = Math.abs(g)+1;
			if(sub == 0) {
				sub = 1;
				sub = sub*num;
			}
			else {
				sub = sub*num;
			}
		}
		out.println( "" + (250-sub));
		out.close();
	}
}
