package Chapter2_2;
/*
ID: alan.li2
LANG: JAVA
TASK: subset
 */

import java.io.*;
import java.util.*;
public class subset {
	static int n; 
	static long[] buckets; 
	static long[] copy; 
	static int max = 1; 
	public static void main(String arg[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("subset.in"));
		n = Integer.parseInt(f.readLine());
		f.close();
		
		//initialize 
		buckets = new long[ (n *(n+1))/4 + 1]; 
		copy = new long[ (n *(n+1))/4 + 1]; 
		buckets[0] = 1;  
		buckets[1] = 1; 
		copy(); 
		
		//algorithm 
		generate();
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out"))); 
		long solution = (buckets[buckets.length-1]); 
		if( ((n*(n+1))/2) % 2 == 0) out.println((solution/2)); 
		else out.println("0");
		out.close();
	}
	
	public static void generate() {
		for(int i = 2; i <= n; i++) { //going through the levels
			for(int j = 0; j < buckets.length-i; j++) { //updating columns 
				buckets[i+j] += copy[j]; 
			}
			copy();
			//print();
		}
	}
	/*
	public static void print() {
		for(int i = 0; i < buckets.length; i++) {
			System.out.print(buckets[i] + " ");
		}
		System.out.println();
	}
	*/
	public static void copy() {
		for(int i = 0; i < buckets.length; i++) {
			copy[i] = buckets[i]; 
		}
	}
	
}
