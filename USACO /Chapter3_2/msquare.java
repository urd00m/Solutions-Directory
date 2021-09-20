//package Chapter3_2;

/*
ID: alan.li2
LANG: JAVA
TASK: msquare
 */
//brute force, generate all the transformations up to 8! = 40320 
//then go through and determine the one that takes the shortest amount of moves 
import java.util.*;
import java.io.*;

public class msquare {
	public static String target = ""; 
	// public static String[] transformations = new String[150000];
	// public static int[][] square = new int[150000][8];
	public static Hashtable<String, String> transformations = new Hashtable<String, String>();

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("msquare.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		for (int i = 0; i < 8; i++) {
			target = target + input.nextToken();
		}
		f.close();
		String a = "12345678";
		transformations.put(a, "");
		int[] transformationA = { 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] transformationB = { 3, 0, 1, 2, 5, 6, 7, 4 };
		int[] transformationC = { 0, 6, 1, 3, 4, 2, 5, 7 };
		int minTrans = Integer.MAX_VALUE;
		int minTransIdx = -1;
		// children are at 3i, 3i+1, 3i+2
		Queue<String> q = new LinkedList<>();
		q.add(a);
		for (int i = 0; i < 40320; i++) {
			/*
			 * transformations[3*i+1] = transformations[i]+"A"; //recording the trans
			 * transformations[3*i+2] = transformations[i]+"B"; transformations[3*i+3] =
			 * transformations[i]+"C";
			 */
			a = q.remove();
			String trans = transformations.get(a);
			String store1 = "", store2 = "", store3 = "";
			for (int j = 0; j < 8; j++) {
				store1 = store1 + a.charAt(transformationA[j]);
				store2 = store2 + a.charAt(transformationB[j]);
				store3 = store3 + a.charAt(transformationC[j]);
			}

			if (transformations.containsKey(store1) == false
					|| trans.length() + 1 < transformations.get(store1).length()) {
				transformations.put(store1, trans + "A");
				q.add(store1);
			}
			if (transformations.containsKey(store2) == false
					|| trans.length() + 1 < transformations.get(store2).length()) {
				transformations.put(store2, trans + "B");
				q.add(store2);
			}
			if (transformations.containsKey(store3) == false
					|| trans.length() + 1 < transformations.get(store3).length()) {
				transformations.put(store3, trans + "C");
				q.add(store3);
			}

		}

		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("msquare.out")));
		out.println(transformations.get(target).length());
		out.println(transformations.get(target));
		out.close();
	}

}
