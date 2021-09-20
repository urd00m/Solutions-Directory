package a105;
//package a200_300;
/*
ID: urd00m
LANG: JAVA
TASK: uva10507
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException { //24498549
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); 
		while(f.ready() == true) {
			int n = Integer.parseInt(f.readLine())-3; 
			int m = Integer.parseInt(f.readLine()); 
			boolean[] isAwake = new boolean[26];
			ArrayList<Integer>[] graph = new ArrayList[26];
			for(int i = 0; i < 26; i++) graph[i] = new ArrayList<Integer>(); 
			String input = f.readLine(); 
			isAwake[input.charAt(0)-'A'] = true; isAwake[input.charAt(1)-'A'] = true; isAwake[input.charAt(2)-'A'] = true; 
			for(int i = 0; i < m; i++) {
				input = f.readLine(); 
				int a = input.charAt(0)-'A'; int b = input.charAt(1)-'A'; 
				graph[a].add(b); graph[b].add(a); 
			}
			int years = 0;
			while(n != 0) {
				boolean changed = false; 
				ArrayList<Integer> tempAwake = new ArrayList<Integer>(); 
				for(int i = 0; i < 26; i++) {
					if(isAwake[i] != true && graph[i].size() > 0) {
						int numAwake = 0; 
						for(int item : graph[i]) {
							if(numAwake == 3) break; 
							if(isAwake[item] == true) numAwake++; 
						}
						if(numAwake == 3) {
							changed = true; 
							tempAwake.add(i); 
							n--; 
						}
					}
				}
				if(changed == true) {
					years++;
					for(int item : tempAwake) isAwake[item] = true; 
				}
				else break; 
			}
			if(n == 0) System.out.println("WAKE UP IN, " + years + ", YEARS"); 
			else System.out.println("THIS BRAIN NEVER WAKES UP");
			f.readLine(); 
		}
	}

}
