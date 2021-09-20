//package a103;
/*
ID: urd00m
LANG: JAVA
TASK: uva10305
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n, m; 
	static ArrayList<Integer>[] graph; 
	static ArrayList<Integer> ret;
	static boolean[] visited; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); m = Integer.parseInt(input.nextToken()); 
		while(n != 0) {
			graph = new ArrayList[n]; 
			visited = new boolean[n]; ret = new ArrayList<Integer>(); 
			for(int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>(); 
			for(int i = 0; i < m; i++) {
				input = new StringTokenizer(f.readLine()); 
				graph[Integer.parseInt(input.nextToken())-1].add(Integer.parseInt(input.nextToken())-1); 
			}
			
			for(int i = 0; i < n; i++) {
				if(visited[i] == false) {
					dfs(i, -1); 
				}
			}
			Collections.reverse(ret);
			for(int i = 0; i < ret.size(); i++) {
				System.out.print((ret.get(i)+1));
				if(i != ret.size()-1) System.out.print(" ");
			}
			System.out.println();
			input = new StringTokenizer(f.readLine()); 
			n = Integer.parseInt(input.nextToken()); m = Integer.parseInt(input.nextToken()); 
		}
	}
	
	public static void dfs(int cur, int par) {
		visited[cur] = true; 
		for(int item : graph[cur]) {
			if(item != par && visited[item] == false) {
				dfs(item, cur); 
			}
		}
		ret.add(cur); 
	}
}
