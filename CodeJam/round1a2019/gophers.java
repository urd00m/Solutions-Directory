//package round1a2019;
/*
ID: urd00m
LANG: JAVA
TASK: gophers
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t, n, m; 
	public static void main(String args[]) throws IOException {
		Scanner input = new Scanner(System.in);
		t = input.nextInt(); n = input.nextInt(); m = input.nextInt(); 
		for(int cn = 1; cn < t+1; cn++) {
			int[] mods = {5,7,9,11,13,16,17}; 
			int[] possiblity = new int[m+1];
			int loc = -1; 
			for(int item : mods) {
				for(int i = 0; i < 18; i++) {
					System.out.print(item);
					if(i != 17) System.out.print(" ");
				}
				System.out.println();
				
				//read 
				int sum = 0; 
				for(int i = 0; i < 18; i++) {
					int a = input.nextInt(); 
					sum = (sum+a)%item;  
				}
				
				for(int i = sum; i < m+1; i += item) {
					possiblity[i]++; 
					if(possiblity[i] == 7) {
						loc = i; 
						break; 
					}
				}
				if(loc != -1) break;
				
			}
			System.out.println(loc);
			int temp = input.nextInt(); 
			assert(temp == 1); 
		}
	}
}
