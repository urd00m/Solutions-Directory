//package goldDec2019;
/*
ID: alwang
LANG: JAVA
TASK: milkvisits
 */
import java.io.*;
import java.util.*;

public class milkvisits {
	static int n, m; 
	static int cnt = 0; 
	static int[] timeIn, timeOut; 
	static int[] types; //the types at each farm 
	static ArrayList<Integer>[] graph; //adj list 
	static int[][] query; //the query, 0 is start 1 is end 2 is type 
	static ArrayList<Integer>[] nodeToQuery; //given node position all the query numbers for that node 
	static ArrayList<pair>[] store; //the dfs path sorted by cow type
	static ArrayList<Integer> ord  = new ArrayList<Integer>(); //the dfs path 
	static int[] output; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("milkvisits.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); m = Integer.parseInt(input.nextToken()); 
		init(); 
		
		input = new StringTokenizer(f.readLine()); 
		for(int i = 0; i < n; i++) types[i] = Integer.parseInt(input.nextToken()); 
		for(int i = 0; i < n-1; i++) {
			input = new StringTokenizer(f.readLine()); 
			int a = Integer.parseInt(input.nextToken())-1; int b = Integer.parseInt(input.nextToken())-1; 
			graph[a].add(b);
			graph[b].add(a); 
		}
		for(int i = 0; i < m; i++) {
			input = new StringTokenizer(f.readLine()); 
			int a = Integer.parseInt(input.nextToken())-1, b = Integer.parseInt(input.nextToken())-1, c = Integer.parseInt(input.nextToken()); 
			query[i][0] = a; query[i][1] = b; query[i][2] = c; 
			nodeToQuery[a].add(i); nodeToQuery[b].add(i); 
		}
		f.close();
		
		//algorithm: dfs first to determine the timeIn timeOut 
		//then dfs again to determine the array output which solves the queries 
		dfs(0, -1); 
		dfs2(0, -1); 
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		for(int item : output) out.print(item);
		out.println();
		out.close();
	}

	public static void dfs(int x, int y) {
		timeIn[x] = cnt++;
		for(int t : graph[x]) if(t != y) dfs(t,x); 
		timeOut[x] = cnt++;
	}
	
	public static void dfs2(int curNode, int parentNode) {
		store[types[curNode]].add(new pair(curNode, ord.size())); 
		ord.add(curNode); 
		for(int item : nodeToQuery[curNode]) {
			if(store[query[item][2]].size() > 0) {
				pair temp = store[query[item][2]].get(store[query[item][2]].size()-1); 
				if(temp.a == curNode) output[item] = 1; 
				else {
					int temp2 = ord.get(temp.b+1); 
					if(isAncestor(temp2, query[item][0]+query[item][1]-curNode) == false) output[item] = 1;  
				}
			}
		}
		for(int nextNode : graph[curNode]) if(nextNode != parentNode) dfs2(nextNode, curNode); 
		store[types[curNode]].remove(store[types[curNode]].size()-1); 
		ord.remove(ord.size()-1); 
	}
	
	public static boolean isAncestor(int u, int v) {
		boolean ret = false;
		if (timeIn[u] <= timeIn[v] && timeOut[v] <= timeOut[u])
			ret = true;
		return ret;
	}
	
	public static void init() {
		timeIn = new int[n]; timeOut = new int[n]; 
		types = new int[n]; 
		graph = new ArrayList[n]; 
		for(int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>(); 
		query = new int[m][3]; 
		nodeToQuery = new ArrayList[n]; 
		for(int i = 0; i < n; i++) nodeToQuery[i] = new ArrayList<Integer>(); 
		store = new ArrayList[n+1]; 
		for(int i = 0; i < n+1; i++) store[i] = new ArrayList<pair>(); 
		output = new int[m]; 
	}
	
	public static class pair {
		int a; 
		int b; 
		public pair(int x, int y) {
			a = x;
			b = y; 
		}
	}
}
