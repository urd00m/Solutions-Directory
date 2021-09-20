
//package a200_300;
/*
ID: urd00m
LANG: JAVA
TASK: uva11402
 */
import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		//BufferedReader f = new BufferedReader(new FileReader("Main.in"));
		n = Integer.parseInt(f.readLine());
		for (int _i = 1; _i <= n; _i++) {
			// input
			System.out.println("Case " + _i + ":");
			m = Integer.parseInt(f.readLine());
			int[] store = new int[1024000];
			int length = 0;
			for (int __i = 0; __i < m; __i++) {
				int t = Integer.parseInt(f.readLine());
				String temp = f.readLine();
				for (int ___i = 0; ___i < t; ___i++) {
					for (int i = 0; i < temp.length(); i++) {
						store[length] = temp.charAt(i) - '0';
						length++;
					}
				}
			}
			// algorithm Segment tree
			lazyPropagation pirates = new lazyPropagation(store, length); 
			int q = Integer.parseInt(f.readLine());
			StringTokenizer input;
			int totalQ = 1;
			for (int i = 0; i < q; i++) {
				input = new StringTokenizer(f.readLine());
				String a = input.nextToken();
				int l = Integer.parseInt(input.nextToken());
				int r = Integer.parseInt(input.nextToken());
				if (a.equals("F"))
					pirates.updateRange(l, r, 2);
				else if (a.equals("E"))
					pirates.updateRange(l, r, 1);
				else if (a.equals("I"))
					pirates.updateRange(l, r, -1);
				else {
					System.out.println("Q" + totalQ + ": " + pirates.queryRange(l, r));
					totalQ++;
				}
			}
		}
	}
	public static class lazyPropagation {

		public int[] tree, lazy;
		int[] A;
		int n;

		public int left(int p) {
			return p << 1;
		}

		public int right(int p) {
			return (p << 1) + 1;
		}

		public int parent(int p) {
			return (p >> 1);
		}

		public lazyPropagation(int[] _A, int length) {
			A = _A;
			n = length;
			tree = new int[4 * _A.length];
			lazy = new int[4 * _A.length];
			build(1, 0, n - 1);
		}

		public void build(int p, int L, int R) {
			if (L == R) {
				tree[p] = A[L];
			} else {
				build(left(p), L, (L + R) / 2);
				build(right(p), (L + R) / 2 + 1, R);
				int s1 = tree[left(p)], s2 = tree[right(p)];
				tree[p] = s1 + s2;
			}
		}
		public void updateRange(int l, int r, int val) {
			updateRange(1, 0, n-1, l, r, val); 
		}
		public int queryRange(int l, int r) {
			return queryRange(1, 0, n-1, l, r); 
		}
		void updateRange(int node, int start, int end, int l, int r, int val) {
			if (lazy[node] != 0) {
				// This node needs to be updated
				if (lazy[node] == 2)
					tree[node] = (end - start + 1);
				else if (lazy[node] == 1)
					tree[node] = 0;
				else if (lazy[node] == 0)
					tree[node] = tree[node];
				else
					tree[node] = (end - start + 1) - tree[node];
				if (start != end) {
					if (lazy[node * 2] == 1 && lazy[node] == -1)
						lazy[node * 2] = 2; // if it was originally all zero then it becomes all one
					else if (lazy[node * 2] == 2 && lazy[node] == -1)
						lazy[node * 2] = 1; // if all 1's then becomes all 0
					else if (lazy[node * 2] == -1 && lazy[node] == -1)
						lazy[node * 2] = 0; // if inverse then do nothing
					else
						lazy[node * 2] = lazy[node];

					if (lazy[node * 2 + 1] == 1 && lazy[node] == -1)
						lazy[node * 2 + 1] = 2; // if it was originally all zero then it becomes all one
					else if (lazy[node * 2 + 1] == 2 && lazy[node] == -1)
						lazy[node * 2 + 1] = 1; // if all 1's then becomes all 0
					else if (lazy[node * 2 + 1] == -1 && lazy[node] == -1)
						lazy[node * 2 + 1] = 0; // if inverse then do nothing
					else
						lazy[node * 2 + 1] = lazy[node]; // Mark child as lazy
				}
				lazy[node] = 0; // Reset it
			}
			if (start > end || start > r || end < l) // Current segment is not within range [l, r]
				return;
			if (start >= l && end <= r) {
				// Segment is fully within range
				if (val == 2)
					tree[node] = (end - start + 1);
				else if (val == 1)
					tree[node] = 0;
				else if (val == 0)
					tree[node] = tree[node];
				else
					tree[node] = (end - start + 1) - tree[node];
				if (start != end) {
					// Not leaf node
					if (lazy[node * 2] == 1 && val == -1)
						lazy[node * 2] = 2; // if it was originally all zero then it becomes all one
					else if (lazy[node * 2] == 2 && val == -1)
						lazy[node * 2] = 1; // if all 1's then becomes all 0
					else if (lazy[node * 2] == -1 && val == -1)
						lazy[node * 2] = 0; // if inverse then do nothing
					else
						lazy[node * 2] = val;
					if (lazy[node * 2 + 1] == 1 && val == -1)
						lazy[node * 2 + 1] = 2; // if it was originally all zero then it becomes all one
					else if (lazy[node * 2 + 1] == 2 && val == -1)
						lazy[node * 2 + 1] = 1; // if all 1's then becomes all 0
					else if (lazy[node * 2 + 1] == -1 && val == -1)
						lazy[node * 2 + 1] = 0; // if inverse then do nothing
					else
						lazy[node * 2 + 1] = val;
				}
				return;
			}
			int mid = (start + end) / 2;
			updateRange(node * 2, start, mid, l, r, val); // Updating left child
			updateRange(node * 2 + 1, mid + 1, end, l, r, val); // Updating right child
			tree[node] = tree[node * 2] + tree[node * 2 + 1]; // Updating root with max value
		}

		int queryRange(int node, int start, int end, int l, int r) {
			if (start > end || start > r || end < l)
				return 0; // Out of range
			if (lazy[node] != 0) {
				// This node needs to be updated
				if (lazy[node] == 2)
					tree[node] = (end - start + 1);
				else if (lazy[node] == 1)
					tree[node] = 0;
				else if (lazy[node] == 0)
					tree[node] = tree[node];
				else
					tree[node] = (end - start + 1) - tree[node];
				if (start != end) {
					if (lazy[node * 2] == 1 && lazy[node] == -1)
						lazy[node * 2] = 2; // if it was originally all zero then it becomes all one
					else if (lazy[node * 2] == 2 && lazy[node] == -1)
						lazy[node * 2] = 1; // if all 1's then becomes all 0
					else if (lazy[node * 2] == -1 && lazy[node] == -1)
						lazy[node * 2] = 0; // if inverse then do nothing
					else
						lazy[node * 2] = lazy[node];

					if (lazy[node * 2 + 1] == 1 && lazy[node] == -1)
						lazy[node * 2 + 1] = 2; // if it was originally all zero then it becomes all one
					else if (lazy[node * 2 + 1] == 2 && lazy[node] == -1)
						lazy[node * 2 + 1] = 1; // if all 1's then becomes all 0
					else if (lazy[node * 2 + 1] == -1 && lazy[node] == -1)
						lazy[node * 2 + 1] = 0; // if inverse then do nothing
					else
						lazy[node * 2 + 1] = lazy[node]; // Mark child as lazy
				}
				lazy[node] = 0; // Reset it
			}
			if (start >= l && end <= r) // Current segment is totally within range [l, r]
				return tree[node];
			int mid = (start + end) / 2;
			int p1 = queryRange(node * 2, start, mid, l, r); // Query left child
			int p2 = queryRange(node * 2 + 1, mid + 1, end, l, r); // Query right child
			return (p1 + p2);
		}
	}
}
