package round1c2020;

/*
ID: urd00m
LANG: JAVA
TASK: over
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t;
	static int u;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		t = Integer.parseInt(f.readLine());

		for (int cn = 1; cn < t + 1; cn++) {
			u = Integer.parseInt(f.readLine());
			// run through the values while mapping the lowerbound of the first digit which
			// should tell you the location of each digit
			// length of m and r have to match to tell you any information
			HashMap<String, Integer> convert = new HashMap<String, Integer>();
			HashMap<String, Boolean> stringsFound = new HashMap<String, Boolean>();

			HashMap<String, Integer> occ = new HashMap<String, Integer>();
			int found = 0;
			int id = 0;
			int[] lowerBound = new int[10];
			Arrays.fill(lowerBound, 9);
			long m;
			String r;

			for (int i = 0; i < 10000; i++) {
				input = new StringTokenizer(f.readLine());
				m = Long.parseLong(input.nextToken());
				r = input.nextToken();
				// checked
				if (found != 10)
					for (int j = 0; j < r.length(); j++) {
						if (stringsFound.containsKey(r.substring(j, j + 1)) == false) {
							stringsFound.put(r.substring(j, j + 1), true);
							found++;
						}
					}

				// delete
				int j = 0;
				if (occ.containsKey(r.substring(j, j + 1)) == false) {
					occ.put(r.substring(j, j + 1), 0);
				}
				occ.replace((r.substring(j, j + 1)), occ.get((r.substring(j, j + 1))) + 1);

			}

			// checked
			pair[] output = new pair[9];
			int i = 0; 
			for (String item : occ.keySet()) {
				output[i++] = new pair(item, occ.get(item)); 
				stringsFound.remove(item);
			}
			Arrays.sort(output, new Comparator<pair>() {
				@Override
				public int compare(pair a, pair b) {
					return b.b-a.b; 
				}
			});
			

			System.out.print("Case #" + cn + ": ");
			for (String item : stringsFound.keySet())
				System.out.print(item);
			for (pair item : output)
				System.out.print(item.a);
			System.out.println();

			
		}

	}
	public static class pair {
		String a;
		int b; 
		public pair(String i, int j) {
			a = i; 
			b = j; 
		}
	}
}
