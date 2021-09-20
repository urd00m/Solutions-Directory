//package Chapter4_1;
/*
ID: alan.li2
LANG: JAVA
TASK: fence6
 */
import java.io.*;
import java.util.*;

public class fence6 {
	static int n; 
	static line[] lines; 
	static int minPerim = Integer.MAX_VALUE; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("fence6.in")); 
		n = Integer.parseInt(f.readLine());
		lines = new line[n+1]; //ignore the 0 spot 
		StringTokenizer input; 
		for(int i = 1; i < n+1; i++) {
			input = new StringTokenizer(f.readLine()); 
			int id = Integer.parseInt(input.nextToken()); 
			int len = Integer.parseInt(input.nextToken());
			int lim1 = Integer.parseInt(input.nextToken());
			int lim2 = Integer.parseInt(input.nextToken()); 
			boolean[] store = new boolean[101];
			boolean[] store2 = new boolean[101]; 
			ArrayList<Integer> store3 = new ArrayList<Integer>(); 
			ArrayList<Integer> store4 = new ArrayList<Integer>(); 
			input = new StringTokenizer(f.readLine()); 
			for(int j = 0; j < lim1; j++) {
				int temp = Integer.parseInt(input.nextToken());
				store[temp] = true; 
				store3.add(temp);
			}
			input = new StringTokenizer(f.readLine()); 
			for(int j = 0; j < lim2; j++) {
				int temp = Integer.parseInt(input.nextToken());
				store2[temp] = true; 
				store4.add(temp); 
			}
			lines[id] = new line(id, len, store, store2, store3, store4);
		}
		f.close();
		
		//algorithm
		//brute force approach with dfs search, 
		for(int i = 1; i < n+1; i++) {
			boolean[][] temp = new boolean[n+1][n+1];
			dfs(lines[i], temp, lines[i].start, 0, -1); 
		}
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence6.out")));
		out.println(minPerim); 
		out.close();
	}
	
	//recursive
	public static void dfs(line current, boolean[][] visited, boolean[] lookingFor, int total, int comeFrom) { 
		if(lookingFor[current.id] == true) {
			if(total+current.length < minPerim) minPerim = total+current.length; 
		}
		else if(total+current.length < minPerim) { //if it has the possibility of still being a min 
			if(comeFrom == -1 || current.start[comeFrom] == true) { //attached to the start side
				for(int i = 0; i < current.endItems.size(); i++) {
					if(visited[current.id][current.endItems.get(i)] == false) {
						visited[current.id][current.endItems.get(i)] = true; 
						visited[current.endItems.get(i)][current.id] = true; 
						dfs(lines[current.endItems.get(i)], visited, lookingFor, total+current.length, current.id);
					}
				} 
			}
			else { //attached  to the end side 
				for(int i = 0; i < current.startItems.size(); i++) {
					if(visited[current.id][current.startItems.get(i)] == false) {
						visited[current.id][current.startItems.get(i)] = true; 
						visited[current.startItems.get(i)][current.id] = true; 
						dfs(lines[current.startItems.get(i)], visited, lookingFor, total+current.length, current.id);
					}
				}
			}
		}
			
	}
	
	public static class line {
		int id;
		int length; 
		boolean[] start = new boolean[101]; 
		boolean[] end = new boolean[101]; 
		ArrayList<Integer> startItems = new ArrayList<Integer>(); 
		ArrayList<Integer> endItems = new ArrayList<Integer>(); 
		public line(int a0, int a, boolean[] b, boolean[] c, ArrayList<Integer> d, ArrayList<Integer> e) {
			id = a0;
			length = a; 
			start = b; 
			end = c;
			startItems = d;
			endItems = e; 
		}
	}
}
