//package a300_400;

/*
ID: urd00m
LANG: JAVA
TASK: uva00334
 */
import java.io.*;
import java.util.*;

public class Main {
	static HashMap<String, Integer> convert = new HashMap<String, Integer>();
	static HashMap<Integer, String> convertBack = new HashMap<Integer, String>();
	static int n;
	static int[][] graph;
	static int id = 0;
	static int caseNumber = 0;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input = new StringTokenizer(f.readLine());
		int cur = Integer.parseInt(input.nextToken());
		while (cur != 0) {
			convert.clear();
			convertBack.clear();
			id = 0;
			// assembling input
			graph = new int[200][200];
			n = cur;
			for (int i = 0; i < n; i++) {
				input = new StringTokenizer(f.readLine());
				int k = Integer.parseInt(input.nextToken());
				String temp = input.nextToken();
				if (convert.containsKey(temp) == false) {
					convert.put(temp, id);
					convertBack.put(id++, temp);
				}
				int prev = convert.get(temp);
				for (int j = 1; j < k; j++) {
					String a = input.nextToken();
					fill(prev, a);
					prev = convert.get(a);
				}
			}
			input = new StringTokenizer(f.readLine());
			n = Integer.parseInt(input.nextToken());
			for (int i = 0; i < n; i++) {
				input = new StringTokenizer(f.readLine());
				int k = 2;
				String temp = input.nextToken();
				if (convert.containsKey(temp) == false) {
					convert.put(temp, id);
					convertBack.put(id++, temp);
				}
				int curNode = convert.get(temp);
				for (int j = 1; j < k; j++) {
					fill(curNode, input.nextToken());
				}
			}

			int trans = 0;
			int total = (convert.size() * (convert.size() - 1)) / 2;
			ArrayList<String> ret = new ArrayList<String>();

			// transitive closer

			for (int k = 0; k < id; k++) {
				for (int i = 0; i < id; i++) {
					for (int j = 0; j < id; j++) {
						if (i == j)
							graph[i][j] = 1;
						graph[i][j] |= (graph[i][k] & graph[k][j]);
					}
				}
			}

			for (int i = 0; i < id; i++) {
				for (int j = 0; j < id; j++) {
					if (i != j && graph[i][j] == 1)
						trans++;
					else if (ret.size() < 2 && i > j && graph[j][i] == 0)
						ret.add("(" + convertBack.get(i) + "," + convertBack.get(j) + ")");
				}
			}

			// output
			if ((total - trans) != 0)
				System.out.println("Case " + ++caseNumber + ", " + (total - trans) + " concurrent events:");
			else
				System.out.println("Case " + ++caseNumber + ", " + "no" + " concurrent events.");
			for (int i = 0; i < ret.size(); i++) {
				System.out.print(ret.get(i)+" ");
			}
			if ((total - trans) != 0)
				System.out.println();
			input = new StringTokenizer(f.readLine());
			cur = Integer.parseInt(input.nextToken());

		}

	}

	public static void fill(int curNode, String temp) {
		if (convert.containsKey(temp) == false) {
			convert.put(temp, id);
			convertBack.put(id++, temp);
		}
		graph[curNode][convert.get(temp)] = 1;

	}
}
