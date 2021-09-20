package a1000_1100;

/*
ID: urd00m
LANG: JAVA
TASK: uva1047
 */
import java.io.*;
import java.util.*;

public class uva1047 {
	static int caseNumber = 1;

	public static void main(String args[]) throws IOException, InterruptedException {
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		String store = f.readLine();
		while (store.equals("0 0") == false) {
			StringTokenizer input = new StringTokenizer(store);
			int n;
			int c; // num of towers and number of towers to be built
			n = Integer.parseInt(input.nextToken());
			c = Integer.parseInt(input.nextToken());
			int[] towers = new int[n];
			input = new StringTokenizer(f.readLine());
			for (int i = 0; i < n; i++)
				towers[i] = Integer.parseInt(input.nextToken());
			int m = Integer.parseInt(f.readLine());
			common[] commonSpace = new common[m];
			for (int i = 0; i < m; i++) {
				input = new StringTokenizer(f.readLine());
				int up = Integer.parseInt(input.nextToken());
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int j = 0; j < up; j++) {
					temp.add(Integer.parseInt(input.nextToken()) - 1);
				}
				commonSpace[i] = new common(temp, Integer.parseInt(input.nextToken()));
			}

			// subsequences
			ArrayList<Integer> locations = new ArrayList<Integer>();
			int maxCust = 0;
			for (int i = 1; i < (1 << n); i++) {
				int numTowers = 0;
				int total = 0;
				ArrayList<Integer> temp = new ArrayList<Integer>(); // indices in the sub sequence
				for (int j = 0; j < n; j++) {
					if (((1 << j) & i) > 0) {
						numTowers++;
						temp.add(j);
						total += towers[j];
					}
				}
				if (numTowers == c) { // counts
					// subtract common
					for (common item : commonSpace) { // going through the common space
						int numOverlap = 0;
						for (int idxes : item.idx) {
							if (temp.contains(idxes) == true) {
								numOverlap++;
							}
						}
						if (numOverlap > 1) {
							// System.out.println(total + " " + ((item.num)*(item.idx.size()-1)) + " " +
							// temp.toString() + " " + item.idx.toString() + " " + item.num);
							total -= ((numOverlap-1)*item.num);
						}
					}
					if (total > maxCust) {
						maxCust = total;
						Collections.sort(temp);
						locations = temp;
					} 
					/* else if (total == maxCust) {
						Collections.sort(temp);
						if (temp.toString().compareTo(locations.toString()) < 0)
							locations = temp;
					}*/
				}
			}
			String output = "";
			for (int i = 0; i < c; i++) {
				output += (locations.get(i) + 1);
				if (i != c - 1)
					output += " ";
			}
			System.out.println("Case Number  " + caseNumber++);
			System.out.println("Number of Customers: " + maxCust);
			System.out.println("Locations recommended: " + output + "\n");
			store = f.readLine();
		}
	}
	public static class common {
		ArrayList<Integer> idx = new ArrayList<Integer>();
		int num = 0;

		public common(ArrayList<Integer> a, int b) {
			idx = a;
			num = b;
		}
	}
}
