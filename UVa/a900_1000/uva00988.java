//package a900_1000;
/*
ID: urd00m
LANG: JAVA
TASK: uva00988
 */
import java.util.*;
import java.io.*;

public class Main {
	static int n; 
	static ArrayList<Integer>[] graph; 
	static long[] paths; 
	static ArrayList<Integer> topo;
	static boolean[] visited; 
	public static void main(String args[]) throws IOException, InterruptedException { 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input;
		Thread.sleep(3000);
		while(f.ready()) {
			n = Integer.parseInt(f.readLine()); 
			graph = new ArrayList[n]; //DAG
			for(int i = 0; i < n; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			for(int i = 0; i < n; i++) {
				input = new StringTokenizer(f.readLine()); 
				int k = Integer.parseInt(input.nextToken());
				for(int j = 0; j < k; j++) {
					int a = Integer.parseInt(input.nextToken()); 
					graph[i].add(a); 
				}
			}
			//running dp  - bottom up 
			int[] paths = new int[n];
			int numDeaths = 0; 
			paths[0] = 1; 
			
			//topological sort 
			visited = new boolean[n]; 
			topo = new ArrayList<Integer>(); 
			dfs(0, -1); 
			Collections.reverse(topo);
			for(int item : topo) {
				for(int next : graph[item]) {
					paths[next] += paths[item]; 
				}
				if(graph[item].size() == 0) numDeaths += paths[item]; 
			}
			System.out.println(numDeaths);
			if(f.ready()) {
				f.readLine();
				System.out.println(); 
			}
		}
	}
	
	public static void dfs(int curNode, int parentNode) {
		visited[curNode] = true; 
		for(int item : graph[curNode]) {
			if(visited[item] == false) {
				dfs(item, curNode); 
			}
		}
		topo.add(curNode); 
	}
}
