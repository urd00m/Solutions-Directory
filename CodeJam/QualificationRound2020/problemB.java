//package QualificationRound2020;
/*
ID: urd00m
LANG: JAVA
TASK: nesting depth
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); 
		t = Integer.parseInt(f.readLine()); 
		
		//algorithm
		for(int cn = 1; cn < t+1; cn++) {
			String cur = f.readLine(); 
			String ret = "";
			int depth = cur.charAt(0)-'0';
			for(int i = 0; i < depth; i++) ret += "("; 
			ret += depth; 
			for(int i = 1; i < cur.length(); i++) {
				int num = cur.charAt(i)-'0';  
				if(num == depth) ret += num; //do nothing 
				else if(num > depth) {
					for(int count = 0; count < (num-depth); count++) ret += "(";
					depth = num; 
					ret += num; 
				}
				else { //num < depth 
					for(int count = 0; count < (depth-num); count++) ret += ")"; 
					depth = num; 
					ret += num; 
				}
			}
			for(int count = 0; count < depth; count++) ret += ")";
			System.out.println("Case #" + cn + ": " + ret);
		} 
	}
}
