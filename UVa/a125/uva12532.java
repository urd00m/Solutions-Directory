
//package a125;
/*
ID: urd00m
LANG: JAVA
TASK: uva12532
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		//BufferedReader f = new BufferedReader(new FileReader("Main.in"));
		StringTokenizer input;
		while (f.ready()) {
			input = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(input.nextToken());
			int q = Integer.parseInt(input.nextToken());
			FenwickTree game = new FenwickTree(n);
			int[] save = new int[n + 1];
			input = new StringTokenizer(f.readLine());
			for (int i = 1; i <= n; i++) {
				int temp = change(Integer.parseInt(input.nextToken()));
				game.adjust(i, temp, 1);
				save[i] = temp;
			}
			for (int i = 0; i < q; i++) {
				input = new StringTokenizer(f.readLine());
				if (input.nextToken().equals("C")) {
					int a = Integer.parseInt(input.nextToken());
					int b = change(Integer.parseInt(input.nextToken()));
					game.adjust(a, b, save[a]);
					save[a] = b;
				} else {
					int a = Integer.parseInt(input.nextToken());
					int b = Integer.parseInt(input.nextToken());
					int temp = game.rsq(a, b);
					if (temp == -1) {
						System.out.print("-");
					} else if (temp == 1)
						System.out.print("+");
					else
						System.out.print("0");
				}
			}
			System.out.println();
		}
	}

	public static int change(int temp) {
		if (temp > 0) {
			return 1;
		} else if (temp < 0) {
			return -1;
		} else {
			return 2;
		}
	}

	public static class FenwickTree {
		int[] ft;

		public FenwickTree(int n) {
			ft = new int[n + 1];
			Arrays.fill(ft, 1);
		}

		public int LSOne(int x) {
			return (x & (-x));
		}

		public int rsq(int b) {
			int product = 1;
			for (; b != 0; b -= LSOne(b))
				product *= ft[b];
			return product;
		}

		public int rsq(int a, int b) {
			return rsq(b) / (a == 1 ? 1 : rsq(a - 1));
		}

		// if zero multiple by 2
		// if greater than 0 mulitple by 1
		// if less than 0 mulitple by -1
		public void adjust(int k, int v, int original) { // we can assume that the value being updated is different
			for (; k < ft.length; k += LSOne(k)) {
				ft[k] /= original;
				ft[k] *= v;
			}
		}
	}
}
