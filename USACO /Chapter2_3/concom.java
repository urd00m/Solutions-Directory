package Chapter2_3;
/*
ID: alan.li2
LANG: JAVA
TASK: concom
 */

import java.util.*;
import java.io.*;

public class concom {
	static int n;
	// 0's are dummy values
	static int[][] ownership = new int[101][101]; // x,y, means x owns pct, of y
	static ArrayList<String> output = new ArrayList<String>();

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("concom.in"));
		n = Integer.parseInt(f.readLine());
		StringTokenizer input;
		for (int i = 0; i < n; i++) {
			input = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(input.nextToken());
			int b = Integer.parseInt(input.nextToken());
			int pct = Integer.parseInt(input.nextToken());
			ownership[a][b] = pct;
		}
		f.close();
		// algorithm
		// first go through all the values in the array and figure out the pct ownership
		// of all companies
		// then go through all the companies and if owns more than 50% add to list
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (i != j) {
					if (ownership[i][j] > 50) { // if owns the company than transfer all assets
						for (int z = 1; z < 101; z++) {
							if (i != z)
								ownership[i][z] += ownership[j][z];
						}
					}
				}
			}
		}

		// accessing values
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (i != j) {
					if (ownership[i][j] > 50) {
						output.add(i + " " + j);
						for (int z = 1; z < 101; z++) {
							if (z != i) {
								if (ownership[j][z] > 50 && ownership[i][z] < 50) {
									output.add(i + " " + z);
									ownership[i][z] = 51; 
								}
								
							}
						}
					}
				}
			}
		}
		// sorts
		Collections.sort(output, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				StringTokenizer a1 = new StringTokenizer(a);
				StringTokenizer b1 = new StringTokenizer(b);
				int dif = Integer.parseInt(a1.nextToken()) - Integer.parseInt(b1.nextToken());
				if (dif == 0)
					dif = Integer.parseInt(a1.nextToken()) - Integer.parseInt(b1.nextToken());
				return dif;
			}
		});
		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
		for (String val : output)
			out.println(val);
		out.close();
	}
}
