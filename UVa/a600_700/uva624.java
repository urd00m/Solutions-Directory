package a600_700;

/*
ID: urd00m
LANG: JAVA
TASK: uva624
 */
import java.io.*;
import java.util.*;

public class uva624 {
	static int n = -1, numTracks = -1;
	static int[] trackLengths;
	static int max;
	static String output;

	public static void main(String args[]) throws IOException, InterruptedException {
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		Thread.sleep(3000);
		StringTokenizer input;
		while (f.ready() == true) {
			max = -1;
			output = "";
			input = new StringTokenizer(f.readLine());
			n = Integer.parseInt(input.nextToken());
			numTracks = Integer.parseInt(input.nextToken());
			trackLengths = new int[numTracks];
			for (int i = 0; i < numTracks; i++) {
				trackLengths[i] = Integer.parseInt(input.nextToken());
			}
			recur(0, 0, "");
			System.out.println(output);
		}
	}

	public static void recur(int idx, int sum, String ret) {
		if (idx < numTracks) {
			if (sum + trackLengths[idx] <= n) {
				recur(idx + 1, sum + trackLengths[idx], ret + trackLengths[idx] + " ");
			}
			recur(idx + 1, sum, ret);
		}
		if (sum > max) {
			max = sum;
			output = ret + "sum:" + max;
		}

	}
}
