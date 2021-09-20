//package a100;

/*
ID: urd00m
LANG: JAVA
TASK: uva10054
 */
import java.io.*;
import java.util.*;

public class Main {
	static int t;
	static int n;
	static ArrayList<pair>[] graph;
	static ArrayList<Integer> tour = new ArrayList<Integer>();

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		t = Integer.parseInt(f.readLine());
		for (int caseNumber = 1; caseNumber < t + 1; caseNumber++) {
			// input
			tour.clear(); // reset
			n = Integer.parseInt(f.readLine());
			graph = new ArrayList[51]; // 0 is null value
			int[] degrees = new int[51];
			for (int i = 0; i < 51; i++)
				graph[i] = new ArrayList<pair>();
			for (int i = 0; i < n; i++) {
				input = new StringTokenizer(f.readLine());
				int a = Integer.parseInt(input.nextToken());
				int b = Integer.parseInt(input.nextToken());
				graph[a].add(new pair(b));
				graph[b].add(new pair(a));
				degrees[a]++;
				degrees[b]++;
			}

			// Euler tour
			System.out.println("Case #" + caseNumber);
			boolean impossible = false;
			int node = -1;
			for (int i = 1; i < 51; i++) {
				if (degrees[i] % 2 == 1) {
					System.out.println("some beads may be lost");
					impossible = true;
					break;
				} else {
					if (degrees[i] != 0)
						node = i;
				}
			}
			if (impossible == false) {
				eulerTour(node, 0);
				if (tour.size() != n) {
					System.out.println("some beads may be lost");
				} else {
					for (int i = 0; i < tour.size(); i++) {
						System.out.println(tour.get(i) + " " + tour.get( (i + 1)%(tour.size())));
					}
				}
			}
			if(caseNumber != t) System.out.println();
		}
	}

	public static void eulerTour(int cur, int idxinsert) {
		for (int j = 0; j < graph[cur].size(); j++) {
			pair v = graph[cur].get(j);
			if (v.status == 1) {
				v.status = 0;
				for (int k = 0; k < graph[v.destination].size(); k++) {
					pair uu = graph[v.destination].get(k);
					if (uu.destination == cur && uu.status == 1) {
						uu.status = 0;
						break;
					}
				}
				tour.add(idxinsert, cur);
				eulerTour(v.destination, idxinsert + 1);
			}
		}
	}

	public static class pair {
		int status = 1;
		int destination;

		public pair(int a) {
			destination = a;
		}
	}
}
