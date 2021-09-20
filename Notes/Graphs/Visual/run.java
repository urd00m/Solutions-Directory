package Visual;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class run {
	static int n;
	static ArrayList<Integer>[] graph; 
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("file.in"));
		n = Integer.parseInt(f.readLine());
		StringTokenizer input; 
		init(); 
		for (int i = 0; i < n - 1; i++) {
			input = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(input.nextToken()) - 1;
			int b = Integer.parseInt(input.nextToken()) - 1;
			graph[a].add(b);
			graph[b].add(a);
		}
		testGraphDraw a = new testGraphDraw(); 
		a.n=n; 
		a.init();
		a.frame.setSize(1000, 1000);
		a.frame.setVisible(true);
		a.graph=graph; 
		a.set(0, a.frame);
		f.close();
	}
	
	
	public static void init() {
		graph = new ArrayList[n]; 
		for(int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>(); 
	}
}
