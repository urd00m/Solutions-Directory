//package a124;

/*
ID: urd00m
LANG: JAVA
TASK: uva12405
 */
import java.io.*;
import java.util.*;

public class Main {
	static int caseNumber = 1;
	static int n;
	static String input;
	static int k;

	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		n = Integer.parseInt(f.readLine());
		for (int count = 0; count < n; count++) {
			k = Integer.parseInt(f.readLine());
			input = f.readLine();
			int ret = 0; // interval covering problem # are already covered
			int maxRight = 0;
			int curLeft = 0;
			interval best = new interval(-1, -1);
			if (covered(0, k) == false) {
				for (int i = 0; i < k; i++) {
					interval cur = new interval(i - 1, i + 1);
					if ((cur.l <= curLeft || covered(curLeft, cur.l))) { // connected
						if (cur.r > maxRight) {
							maxRight = cur.r;
							best = cur;
						}
						// if(cur.l < 0) cur.l = 0;
						// if(cur.r > 41) cur.r = 41;
						// System.out.println(ret + " " + curLeft + " " + maxRight + " " +
						// input.substring(cur.l, cur.r+1));
					} else {
						curLeft = best.r + 1;
						best = new interval(-1, -1);
						i--;
						ret++;
					}

				}
			}
			if(curLeft != k && covered(curLeft, k) == false) ret++; 
			System.out.println("Case " + caseNumber++ + ": " + ret);
		}
	}

	public static boolean covered(int l, int r) {
		boolean covered = true;
		if (r > k)
			r = k;
		if (l < 0)
			l = 0;
		for (int i = l; i < r; i++) {
			if (input.charAt(i) != '#') {
				covered = false;
				break;
			}
		}
		return covered;
	}

	public static class interval {
		int l, r;

		public interval(int x, int y) {
			l = x;
			r = y;
		}
	}
}
