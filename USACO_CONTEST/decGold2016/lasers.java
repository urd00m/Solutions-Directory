//package decGold2016;
/*
ID: alwang
LANG: JAVA
TASK: lasers
 */
import java.util.*;
import java.io.*;

public class lasers {
	static point laser; static point barn; 
	static int n; 
	static HashMap<Integer, ArrayList<Integer>> xs = new HashMap<Integer, ArrayList<Integer>>(); 
	static HashMap<Integer, ArrayList<Integer>> ys = new HashMap<Integer, ArrayList<Integer>>(); 
	static HashMap<String, Boolean> visited = new HashMap<String, Boolean>(); 
	static int output = Integer.MAX_VALUE; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("lasers.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n  = Integer.parseInt(input.nextToken()); 
		laser = new point(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken())); 
		barn = new point(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken())); 
		xs.put(barn.x, new ArrayList<Integer>()); xs.get(barn.x).add(barn.y); 
		ys.put(barn.y, new ArrayList<Integer>()); ys.get(barn.y).add(barn.x); 
		for(int i = 0; i < n; i++) {
			input = new StringTokenizer(f.readLine()); 
			point temp = new point(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken())); 
			if(xs.containsKey(temp.x)) xs.get(temp.x).add(temp.y); 
			else {
				xs.put(temp.x, new ArrayList<Integer>()); 
				xs.get(temp.x).add(temp.y); 
			}
			if(ys.containsKey(temp.y)) ys.get(temp.y).add(temp.x); 
			else {
				ys.put(temp.y, new ArrayList<Integer>()); 
				ys.get(temp.y).add(temp.x); 
			}
		}
		f.close();
		
		//algorithm: bfs type search (dfs search is harder to implement) 
		Queue<pair> q = new LinkedList<pair>(); 
		q.add(new pair(laser.x, laser.y, -1, -1)); 
		while(q.isEmpty() == false) { //w = 0 means coming from vertical and w = 1 means coming from horizontal 
			pair cur = q.remove(); 
			if(cur.x == barn.x && cur.y == barn.y) {
				output = Math.min(output, cur.fencesUsed); 
				break; 
			}
			else {
				if(cur.w == 0 || cur.w == -1) {
					if(ys.containsKey(cur.y))
						for(int item : ys.get(cur.y)) {
							if(visited.containsKey(cur.x + " " + cur.y + " " + item + " " + cur.y) == false && cur.x != item) {
								visited.put(cur.x + " " + cur.y + " " + item + " " + cur.y, true); //marks that path as visited 
								visited.put( item + " " + cur.y + " " + cur.x + " " + cur.y, true); 
								q.add(new pair(item, cur.y, 1, cur.fencesUsed+1)); 
							}
						}
				}
				if(cur.w == 1 || cur.w == -1) {
					if(xs.containsKey(cur.x))
						for(int item : xs.get(cur.x)) {
							if(visited.containsKey(cur.x + " " + cur.y + " " + cur.x + " " + item) == false && cur.y != item) {
								visited.put(cur.x + " " + cur.y + " " + cur.x + " " + item, true); //marks the path as visited
								visited.put(cur.x + " " + item + " " + cur.x + " " + cur.y , true); 
								q.add(new pair(cur.x, item, 0, cur.fencesUsed+1)); 
							}
						}
				}
			}
		}
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lasers.out"))); 
		out.println(output);
		out.close();
	}
	public static class pair {
		int x, y; 
		int w; 
		int fencesUsed; 
		public pair(int a, int b, int c, int d) {
			x = a; 
			y = b; 
			w = c; 
			fencesUsed = d; 
		}
	}

	
	public static class point {
		int x, y; 
		public point(int a, int b) {
			x = a; 
			y = b;
		}
	}
}
