package a700_800;

//package a200_300;
/*
ID: urd00m
LANG: JAVA
TASK: uva793
 */
import java.util.*;
import java.io.*;

public class Main {
	static int t;
	static int good = 0;
	static int bad = 0;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		t = Integer.parseInt(f.readLine());
		f.readLine();
		for (int i = 0; i < t; i++) {
			// algorithm use ufds
			int n = Integer.parseInt(f.readLine());
			UnionFind network = new UnionFind(n);
			while (f.ready() == true) {
				try {
					input = new StringTokenizer(f.readLine());
					String type;
					int a;
					int b;
					type = input.nextToken();
					a = Integer.parseInt(input.nextToken()) - 1;
					b = Integer.parseInt(input.nextToken()) - 1;
					if (type.equals("c"))
						network.unionSet(a, b);
					else {
						if (network.isSameSet(a, b))
							good++;
						else
							bad++;
					}
				} catch (Exception NoSuchElementException) {
					break;
				}
			}
			System.out.println(good + "," + bad);
			if(i != t-1) System.out.println();
			good = 0;
			bad = 0;
		}

		// output
		f.close();

	}

	static class UnionFind {
		int[] p, rank, size;
		int numSets;

		UnionFind(int n) {
			p = new int[n];
			rank = new int[n];
			numSets = n;
			size = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = i;
				size[i] = 1;
			}
		}

		int findSet(int i) { // finds parent
			return (p[i] == i) ? i : (p[i] = findSet(p[i]));
		}

		boolean isSameSet(int i, int j) { // checks if they are the same set
			return (findSet(i) == findSet(j));
		}

		void unionSet(int i, int j) { // merges 2 sets
			if (!isSameSet(i, j)) {
				int x = findSet(i);
				int y = findSet(j);
				if (rank[x] > rank[y]) {
					p[y] = x;
					size[x] += size[y];

				} else {
					p[x] = y;
					size[y] += size[x];
					if (rank[x] == rank[y])
						rank[y]++;
				}
				numSets--;
			}
		}

		int sizeOfSet(int i) { // returns the size of the set
			return size[findSet(i)];
		}

		int numDisjointSets() { // returns the total number of sets
			return numSets;
		}
	}
}
