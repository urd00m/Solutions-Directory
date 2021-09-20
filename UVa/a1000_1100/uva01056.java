package a1000_1100;

/*
ID: urd00m
LANG: JAnA
TASK: uva01056
 */
import java.io.*;
import java.util.*;

public class uva01056 {
	static int caseNumber = 1;
	static int n, r;
	static HashMap<String, Integer> convert = new HashMap<String, Integer>();
	static int[][] graph;
	static int touched = 0;
	static int diameter;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		input = new StringTokenizer(f.readLine());
		n = Integer.parseInt(input.nextToken());
		r = Integer.parseInt(input.nextToken());
		while (n != 0) {
			graph = new int[n][n];
			int id = 0;
			for (int i = 0; i < n; i++) { //init 
				for (int j = 0; j < n; j++) {
					if (i == j)
						graph[i][j] = 0;
					else
						graph[i][j] = 1000000000;
				}
			}
			for (int i = 0; i < r; i++) {
				while (input.hasMoreTokens() == false)
					input = new StringTokenizer(f.readLine());
				String a = input.nextToken();
				String b = input.nextToken();
				if (convert.containsKey(a) == false)
					convert.put(a, id++);
				if (convert.containsKey(b) == false)
					convert.put(b, id++);
				int id1 = convert.get(a);
				int id2 = convert.get(b);
				graph[id1][id2] = 1;
				graph[id2][id1] = 1;
			}
			// running APSP to get diameter
			// if it doesn't touch every node then it is disconnected
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (graph[i][k] + graph[k][j] < graph[i][j])
							graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}

			// check
			diameter = 0; 
			for(int[] ary : graph) { //delete
				touched = 0; 
				for(int item : ary) {
					if(item != 1000000000) touched++; 
					if(item > diameter && item != 1000000000) diameter = item; 
				}
				if(touched != n) break; 
			}
			if (touched == n)
				System.out.println("Network " + caseNumber++ + ": " + diameter);
			else
				System.out.println("Network " + caseNumber++ + ": DISCONNECTED");
			System.out.println();
			input = new StringTokenizer(f.readLine());
			n = Integer.parseInt(input.nextToken());
			r = Integer.parseInt(input.nextToken());
			touched = 0;
			convert.clear();
		}
	}

}
