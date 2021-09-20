//package DecGold2018;
/*
ID: alan.li2
LANG: JAVA
TASK: cowpatilibity
 */
import java.io.*;
import java.util.*;
public class cowpatibility {
	static int n; // possible matches n(n-1)/2
	static HashMap<String, Long> cows = new HashMap<String, Long>();

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("cowpatibility.in"));
		n = Integer.parseInt(f.readLine());
		StringTokenizer input;
		for (int i = 0; i < n; i++) {
			input = new StringTokenizer(f.readLine());
			two store = new two(5, new int[5]); 
			for (int j = 0; j < 5; j++) {
				store.v[j] = Integer.parseInt(input.nextToken());
			}
			Arrays.sort(store.v);
			addSubsets(store);

		}
		f.close();
		// algorithm dp
		int[] sign = { -1, 1, -1, 1, -1 };
		long output = (n * (n - 1)) / 2;
		for (String keys : cows.keySet()) {
			System.out.println(keys);
			output += sign[((int)(keys.charAt(0))) - 49] * cows.get(keys) * (cows.get(keys) - 1) / 2;
		}

		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowpatibility.out")));
		out.println(output);
		out.close();
	}

	public static void addSubsets(two a) {
		for (int i = 1; i < 32; i++) {
			int num = 0; 
			String output = "";
			for (int j = 0; j < 5; j++) {
				if (((1 << j) & i) > 0) {
					output += " " + a.v[j]; 
					num++; 
				}
			}
			if (cows.containsKey(num + output))
				cows.put(num + output, cows.get(num + output) + 1);
			else {
				cows.put(num + output, (long) 1);
			}
		}
	}
	public static class two {
		int[] v;
		int n;

		public two(int a, int[] b) {
			n = a;
			v = b;
		}
		public two(int a) {
			n = a;
			v = new int[5];
		}
	}

}
