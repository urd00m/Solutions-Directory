package round1b2020;
import java.util.*;
import java.io.*;
/*
ID: urd00m
LANG: JAVA
TASK: ranks
 */
public class ranks {
	static int t;
	static int r, s; 
	
	static int[] ranks; 
	static int numAdj; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine()); 
		
		for(int cn = 1; cn < t+1; cn++) {
			input = new StringTokenizer(f.readLine()); 
			r = Integer.parseInt(input.nextToken()); 
			s = Integer.parseInt(input.nextToken()); 
			ranks = new int[r*s]; 
			//fill
			int id = 0; 
			for(int i = 0; i < s; i++) {
				for(int j = 1; j <= r; j++) {
					ranks[id++] = j; 
				}
			}

			//running 
			numAdj = r*s-1; //number of adjacent pairs that aren't matched up and must remain greater than r-1 
			//ones until numAdj hits 0 
			ArrayList<String> output = new ArrayList<String>(); 
			while(numAdj > r-1) {
				//finding pile a depth
				int store1 = -1, store2 = -1;
				int pileaDepth = 0; 
				int depth = 0;
				boolean third = false; 
				while(!third) {
					if(store1 == -1) {
						store1 = ranks[depth++];
						pileaDepth++; 
					}
					else if(store2 == -1 && ranks[depth] != store1) {
						store2 = ranks[depth++]; 
					}
					else if(store2 == -1 && store1 == ranks[depth]) {
						depth++;
						pileaDepth++; 
					}
					else if(store2 == ranks[depth]) depth++; 
					else {
						third = true; 
					}
				}
				int pilea = depth; depth = 0; 
				int a = store1;
				boolean found = false; 
				while(!found) {
					if(ranks[depth+pilea] != a) depth++; 
					else {
						//count the number of items equal to a 
						depth++;
						while(depth+pilea < ranks.length && ranks[depth+pilea] == a) depth++; 
						found = true; 
					}
				}
				if(depth+pilea == ranks.length) {
					swap(pileaDepth, ranks.length-pileaDepth);
					output.add(pileaDepth + " " + (ranks.length-pileaDepth)); 
				}
				else {
					swap(pilea, depth);
					output.add(pilea + " " + depth);
				}
				numAdj -= 2; 
			}
			
			System.out.println("Case #" + cn + ": " + output.size());
			for(String item : output) System.out.println(item);
			
		}
	}
	
	//helper function
	//takes in pile depth and then swaps the two pile locations 
	public static void swap(int aD, int bD) {
		int[] temp = new int[aD+bD];
		int id = 0; 
		for(int i = aD; i < aD+bD; i++) {
			temp[id++] = ranks[i];
		}
		for(int i = 0; i < aD; i++) {
			temp[id++] = ranks[i]; 
		}
		for(int i = 0; i < temp.length; i++) {
			ranks[i] = temp[i]; 
		}
	}
}
