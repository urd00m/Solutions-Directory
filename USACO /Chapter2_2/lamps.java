package Chapter2_2;
/*
ID: alan.li2
LANG: JAVA
TASK: lamps
 */

import java.io.*;
import java.util.*;

public class lamps {
	static int n;
	static int c;
	static ArrayList<Integer> on = new ArrayList<Integer>();
	static ArrayList<Integer> off = new ArrayList<Integer>();
	static ArrayList<String> statuses = new ArrayList<String>();

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
		n = Integer.parseInt(f.readLine());
		c = Integer.parseInt(f.readLine()); // only reason for C is to make sure you have enough counts and that you
											// have an even or odd amount
		StringTokenizer in = new StringTokenizer(f.readLine()); // ON
		StringTokenizer in2 = new StringTokenizer(f.readLine()); // OFF
		f.close();
		String input = in.nextToken();
		while (Integer.parseInt(input) != -1) {
			on.add(Integer.parseInt(input));
			input = in.nextToken();
		}
		input = in2.nextToken();
		while (Integer.parseInt(input) != -1) {
			off.add(Integer.parseInt(input));
			input = in2.nextToken();
		}

		// algorithm
		// 4 recusive permutes with the 4 different commands if c is less than only for
		// those cs
		// prune the results for those that match the final results
		// sort those results
		// prune those for repeats
		// then output results

		// create status
		String status = "";
		for (int i = 0; i < n + 1; i++) {
			status = status + "1";
		}
		generate(status, 1);

		// prune results
		for (int i = 0; i < statuses.size(); i++) {
			boolean removed = false;
			for (int j = 0; j < on.size(); j++) {
				if (statuses.get(i).substring(on.get(j), on.get(j) + 1).equals("0") == true) {
					statuses.remove(i);
					removed = true;
					i--;
					break;
				}
			}
			if (removed == false)
				for (int j = 0; j < off.size(); j++) {
					if (statuses.get(i).substring(off.get(j), off.get(j) + 1).equals("1") == true) {
						statuses.remove(i);
						i--;
						break;
					}
				}
		}
		ArrayList<String> stat = new ArrayList<String>();
		if (statuses.size() != 0) {
			// sort the list according to size
			Collections.sort(statuses);
			// prune to see if their are any duplicates
			stat.add(statuses.get(0));
			for (int i = 1; i < statuses.size(); i++) {
				if (!(statuses.get(i).equals(statuses.get(i - 1)) == true))
					stat.add(statuses.get(i));
			}
		}

		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
		for (int i = 0; i < stat.size(); i++) {
			out.println(stat.get(i).substring(1, stat.get(i).length())); // make sure dummy var doens't get in
		}
		if (stat.isEmpty() == true)
			out.println("IMPOSSIBLE");
		out.close();

	}
	// needs the start status, n+1 all ones
	// count starts as 1

	public static void generate(String status, int count) {
		if (count == 4 || count > c)
			statuses.add(status);
		else
			for (int i = 0; i < 4; i++) {
				if (i == 0)
					generate(even(status), count + 1);
				else if (i == 1)
					generate(odd(status), count + 1);
				else if (i == 2)
					generate(k3(status), count + 1);
				else
					generate(opp(status), count + 1);
			}
	}

	public static String even(String current) { // even
		String newCurrent = "1";
		for (int i = 1; i < current.length(); i++) { // 0 is the dummy spot
			if (i % 2 == 0) {
				if (current.substring(i, i + 1).equals("0"))
					newCurrent = newCurrent + "1";
				else
					newCurrent = newCurrent + "0";
			} else
				newCurrent = newCurrent + current.substring(i, i + 1);
		}
		return newCurrent;
	}

	public static String odd(String current) { // odd
		String newCurrent = "1";
		for (int i = 1; i < current.length(); i++) { // 0 is the dummy spot
			if (i % 2 == 1) {
				if (current.substring(i, i + 1).equals("1"))
					newCurrent = newCurrent + "0";
				else
					newCurrent = newCurrent + "1";
			} else
				newCurrent = newCurrent + current.substring(i, i + 1);
		}
		return newCurrent;
	}

	public static String k3(String current) { // 3k+1 command
		String newCurrent = "1";
		for (int i = 1; i < current.length(); i++) { // 0 is the dummy spot
			if (i % 3 == 1) {
				if (current.substring(i, i + 1).equals("0"))
					newCurrent = newCurrent + "1";
				else
					newCurrent = newCurrent + "0";
			} else
				newCurrent = newCurrent + current.substring(i, i + 1);
		}
		return newCurrent;
	}

	public static String opp(String current) { // flips everything
		String newCurrent = "1";
		for (int i = 1; i < current.length(); i++) {
			if (current.substring(i, i + 1).equals("0"))
				newCurrent = newCurrent + "1";
			else
				newCurrent = newCurrent + "0";
		}
		return newCurrent;
	}

}
