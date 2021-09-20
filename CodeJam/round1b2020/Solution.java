package round1b2020;

/*
ID: urd00m
LANG: JAVA
TASK: rhyme
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t;
	static int x, y;
	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		t = Integer.parseInt(f.readLine());
		for (int cn = 1; cn < t + 1; cn++) {
			input = new StringTokenizer(f.readLine()); 
			//always remove one 
			//decrease by 2 every run through 
			x = Integer.parseInt(input.nextToken()); y = Integer.parseInt(input.nextToken()); 
			String cur = find(x, y);
			String ret = ""; 
			boolean impossible = false; 
			if(cur.equals("f")) impossible = true; 
			while(cur.equals("") == false && cur.equals("f") == false) {
				ret += cur;
				cur = find(x, y);
				if(cur.equals("f")) impossible = true; 
			}
			if(impossible) System.out.println("Case #" + cn + ": IMPOSSIBLE"); 
			else System.out.println("Case #" + cn + ": " + ret); 
		}
	}
	
	//returns the direction or f if it doesn't wrok 
	public static String find(int a, int b) {
		if(a == 0 && b == 0) return ""; 
		if( (Math.abs(a)%2 == 1 && Math.abs(b)%2 == 1) || (Math.abs(a)%2 == 0 && Math.abs(b)%2 == 0) ) return "f"; 
		
		if(Math.abs(a)%2 == 1) {
			if(a < 0) {
				if( (a+1 == 0 && b == 0) ||( ((a+1)/2)%2 == -1 && (b/2)%2 == 0) || ( ((a+1)/2)%2 == 0 && (Math.abs(b)/2)%2 == 1)   ) { //if we decrease the distance on a by 1 will it make it possible 
					x++; 
					x /= 2; 
					y /= 2; 
					return "W"; 
				}
				else { //we increase the distance by one 
					x--; 
					x /= 2; 
					y /= 2; 
					return "E"; 
				}
			}
			else {
				if( (a-1 == 0 && b == 0) ||( ((a-1)/2)%2 == 1 && (b/2)%2 == 0) || ( ((a-1)/2)%2 == 0 && (Math.abs(b)/2)%2 == 1)   ) { //if we decrease the distance on a by 1 will it make it possible 
					x--; 
					x /= 2; 
					y /= 2; 
					return "E"; 
				}
				else { //increase the distance by 1
					x++; 
					x /= 2; 
					y /= 2; 
					return "W"; 
				}
			}
			
		}
		else {
			if(b < 0) {
				if( (a == 0 && b+1 == 0) ||( (Math.abs(a)/2)%2 == 1 && ((b+1)/2)%2 == 0) || ( (a/2)%2 == 0 && ((b+1)/2)%2 == -1)   ) { //if we decrease the distance by 1
					y++; 
					x /= 2; 
					y /= 2; 
					return "S"; 
				}
				else { //increase the distance 
					y--; 
					x /= 2; 
					y /= 2; 
					return "N"; 
				}
				
			}
			else {
				if( (a == 0 && b-1 == 0) || ( (Math.abs(a)/2)%2 == 1 && ((b-1)/2)%2 == 0) || ( (a/2)%2 == 0 && ((b-1)/2)%2 == 1)   ) { //if we decrease the distance by 1
					y--; 
					x /= 2; 
					y /= 2; 
					return "N"; 
				}
				else {
					y++; 
					x /= 2; 
					y /= 2; 
					return "S"; 
				}
			}
		}
	}

}
