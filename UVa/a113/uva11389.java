package a113;
/*
ID: urd00m
LANG: JAVA
TASK: uva11389
 */
//load balancing, line up morning with the reverse of evening and then add the times 

import java.util.*;
import java.io.*;

public class uva11389 {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); 
		String read = f.readLine(); 
		while(read.equals("0 0 0") == false) {
			StringTokenizer input = new StringTokenizer(read); 
			int n = Integer.parseInt(input.nextToken()); int d = Integer.parseInt(input.nextToken()); int r = Integer.parseInt(input.nextToken());
			int[] morning = new int[n]; 
			int[] evening = new int[n];
			input = new StringTokenizer(f.readLine()); StringTokenizer input2 = new StringTokenizer(f.readLine());  
			for(int i = 0; i < n; i++) {
				morning[i] = Integer.parseInt(input.nextToken()); 
				evening[i] = Integer.parseInt(input2.nextToken()); 
			}
			Arrays.sort(morning); Arrays.sort(evening);
			reverse(evening);
			int total = 0; 
			for(int i = 0; i < n; i++) {
				int add = 0; 
				if(morning[i]+evening[i] > d) add = ((morning[i]+evening[i])-d)*r; 
				total += add; 
			}
			System.out.println(total);
			read = f.readLine(); 
		}
	}
	public static void reverse(int[] a) {
		int j = a.length-1; 
		for(int i = 0; i < a.length/2; i++) {
			int temp = a[j]; 
			a[j] = a[i]; 
			a[i] = temp; 
			j--; 
		}
	}
}
