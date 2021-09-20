
//package src;
/*
ID: urd00m
LANG: JAVA
TASK: mass
*/
import java.io.*;
import java.util.*;
import java.lang.*;

public class mass {
	static String formula;
	static HashMap<String, Integer> to = new HashMap<String, Integer>();

	public static void main(String args[]) throws java.lang.Exception, IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		formula = f.readLine();
		formula = "(" + formula + ")";
		to.put("H", 1);
		to.put("C", 12);
		to.put("O", 16);
		// using a stack is extremely effective for this problem
		Stack<String> q = new Stack<String>();
		for (int i = 0; i < formula.length(); i++) {
			// System.out.println(q.toString());
			if (formula.substring(i, i + 1).equals(")") == true) { // if closed found
				String cur = q.pop(); // removes the next element of the stack
				int temp = 0;
				while (cur.equals("(") == false && q.isEmpty() == false) { // looks for the first open paren
					if (to.containsKey(cur) == true) { // if it is a letter (can't be a closed paren or open paren)
						temp += to.get(cur); // adds that value
					} else if (cur.equals("*") == true) {
						temp += Integer.parseInt(q.pop());
						q.pop();
					} else if (cur.equals(" ")) {
						// do nothing and move on
					} else { // has to be number if it isn't a letter
						String store = "";
						while (to.containsKey(cur) == false) {
							store = cur + store;
							cur = q.pop();
						}
						int scale = Integer.parseInt(store); // uses it as a scale
						temp += scale * (to.get(cur)); // multiplies it to the letter before it
					}
					if (q.isEmpty() == false)
						cur = q.pop(); // finds next element to add
				}
				String store = "";
				int scale = 1; // scale is guarenteed to be at least 1
				while (i + 1 < formula.length() && to.containsKey(formula.substring(i + 1, i + 2)) == false
						&& formula.substring(i + 1, i + 2).equals(")") == false
						&& formula.substring(i + 1, i + 2).equals("(") == false) {
					store = store + formula.substring(i + 1, i + 2); // if the next element after the closed paren is a
																		// number scale is set to that number
					scale = Integer.parseInt(store);
					i++;
				}
				q.add("*");
				q.add("" + (temp * scale));
				q.add("*");
			} else {
				q.add(formula.substring(i, i + 1));
			}
		//	System.out.println(q.toString());
		}
		q.pop();
		int output = Integer.parseInt(q.pop());
		// output
		f.close();
		System.out.println(output);
	}

}