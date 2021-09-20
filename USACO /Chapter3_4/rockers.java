
//package Chapter3_4;
/*
ID: alan.li2
LANG: JAVA
TASK: rockers
 */
import java.io.*;
import java.util.*;

public class rockers {
	static int N, T, M;
	static int[] songLens;
	static int max = 0;
	static Long time;

	public static void main(String args[]) throws IOException {
		// input
		time = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new FileReader("rockers.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		N = Integer.parseInt(input.nextToken());
		T = Integer.parseInt(input.nextToken());
		M = Integer.parseInt(input.nextToken());
		songLens = new int[N];
		input = new StringTokenizer(f.readLine());
		for (int i = 0; i < N; i++) {
			songLens[i] = Integer.parseInt(input.nextToken());
		}
		f.close();

		// algorithm
		// brute force using recursion
		recur(0, 0, T, 0);

		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rockers.out")));
		out.println(max);
		out.close();
	}

	public static void recur(int diskNum, int total, int space, int songNumber) {
		if (diskNum == M || songNumber == N) {
			if (total > max) {
				max = total;
			}
		} else {
				for (int i = songNumber; i < N; i++) {
					if (songLens[i] <= T) {
						if (songLens[i] > space) {
							if (diskNum != M - 1)
								recur(diskNum + 1, total + 1, T - songLens[i], i + 1); // new disk, same song
							else if (total > max)
								max = total;
						} else if (songLens[i] < space)
							recur(diskNum, total + 1, space - songLens[i], i + 1);
						else
							recur(diskNum + 1, total + 1, T, i + 1);
					}
				}
		}
	}
}
