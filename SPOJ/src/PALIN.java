
//package src;
/*
ID: urd00m
LANG: JAVA
TASK: PALIN
 */
import java.io.*;
import java.util.*;
import java.lang.*;

class PALIN {
	static int n;

	public static void main(String args[]) throws java.lang.Exception, IOException {
		// input
		long time = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		n = Integer.parseInt(f.readLine());
		// algorithm
		for (int i = 0; i < n; i++) {
			StringBuilder cur = new StringBuilder(f.readLine());
			if (cur.length() == 1) {
				if (cur.equals("9"))
					System.out.println("11");
				else
					System.out.println((Integer.parseInt(cur.toString()) + 1));
			} else {
				nextPalin(cur);
			}
		}
		f.close();
		System.out.println( (System.currentTimeMillis()-time));
	}

	public static void nextPalin(StringBuilder a) {
		// go through once and switch accordingly
		// then go through again and changing accordly, never decrease unless the one
		// ahead of it has increased already

		StringBuilder ret = new StringBuilder("");
		if (a.length() % 2 == 0) { // even (checked)
			int l = (a.length() / 2) - 1;
			int r = a.length() / 2;
			if (Integer.parseInt(a.substring(l, l + 1)) > Integer.parseInt(a.substring(r, r + 1))) { // good
				StringBuilder temp = new StringBuilder(a.substring(0, l));
				ret.append(temp.toString()).append(a.substring(l, l + 1)).append(a.substring(l, l + 1)).append(temp.reverse().toString());
			} else if (Integer.parseInt(a.substring(l, l + 1)) < Integer.parseInt(a.substring(r, r + 1))) { // good
				StringBuilder temp = new StringBuilder(a.substring(0, l));
				ret.append(temp.toString()).append((Integer.parseInt(a.substring(l, l + 1)) + 1)).append((Integer.parseInt(a.substring(l, l + 1)) + 1)).append(temp.reverse().toString());
			} else { // they are equal
				if (a.length() == 2) { // good
					if (a.equals("99"))
						ret.append("101");
					else
						ret.append((Integer.parseInt(a.substring(l, l + 1)) + 1)).append((Integer.parseInt(a.substring(l, l + 1)) + 1));
				} else { // good
					if (Integer.parseInt(a.substring(l, l + 1)) == 9) {
						while (l >= 0 && a.substring(l, l + 1).equals("9") == true
								&& a.substring(r, r + 1).equals("9")) { // good
							if (l != 0) {
								ret.insert(0, "0");
								ret.append("0");
							} else {
								ret.insert(0, "10");
								ret.append("1");
							}
							l--;
							r++;
						}
						if (l != -1) { // good
							if (Integer.parseInt(a.substring(l, l + 1)) > Integer.parseInt(a.substring(r, r + 1))) { // good
								ret = new StringBuilder("");
								StringBuilder temp = new StringBuilder(a.substring(0, l + 1));
								ret.append(a.substring(0, r)).append(temp.reverse().toString());
							} else if (Integer.parseInt(a.substring(l, l + 1)) <= Integer
									.parseInt(a.substring(r, r + 1))) { // good
								StringBuilder newRet = new StringBuilder("");
								StringBuilder temp = new StringBuilder(a.substring(0, l));
								newRet.append(temp.toString()).append((Integer.parseInt(a.substring(l, l + 1)) + 1)).append(ret.toString()).append((Integer.parseInt(a.substring(l, l + 1)) + 1)).append(temp.reverse().toString());
								ret = newRet;
							}
						}
					} else if (Integer.parseInt(a.substring(l - 1, l)) <= Integer.parseInt(a.substring(r + 1, r + 2))) { // good
						StringBuilder temp = new StringBuilder(a.substring(0, l));
						ret.append(temp.toString()).append((Integer.parseInt(a.substring(l, l + 1)) + 1)).append((Integer.parseInt(a.substring(l, l + 1)) + 1)).append(temp.reverse().toString());
					} else { // good
						StringBuilder temp = new StringBuilder(a.substring(0, l + 1));
						ret.append(a.substring(0, l + 1)).append(temp.reverse().toString());
					}
				}
			}
		} else { // odd (checked)
			int l = (a.length() / 2);
			int r = a.length() / 2; // middle
			if (a.substring(l, l + 1).equals("9") == false) {
				if (Integer.parseInt(a.substring(l - 1, l)) <= Integer.parseInt(a.substring(r + 1, r + 2))) { // good
					StringBuilder temp = new StringBuilder(a.substring(0, l));
					ret.append(temp.toString()).append((Integer.parseInt(a.substring(l, l + 1)) + 1)).append(temp.reverse().toString());
				} else { // good
					StringBuilder temp = new StringBuilder(a.substring(0, l));
					ret.append(a.substring(0, l + 1)).append(temp.reverse().toString());
				}
			} else { // good
				while (l >= 0 && a.substring(l, l + 1).equals("9") == true && a.substring(r, r + 1).equals("9")) { // good
					if (l != 0) {
						ret.insert(0, "0");
						if (l != r)
							ret.append("0");
					} else {
						ret.insert(0, "10");
						ret.append("1");
					}
					l--;
					r++;
				}
				if (l != -1) { //
					if (Integer.parseInt(a.substring(l, l + 1)) > Integer.parseInt(a.substring(r, r + 1))) { // good
						ret = new StringBuilder("");
						StringBuilder temp = new StringBuilder(a.substring(0, l + 1));
						ret.append(a.substring(0, r)).append(temp.reverse().toString());
					} else if (Integer.parseInt(a.substring(l, l + 1)) <= Integer.parseInt(a.substring(r, r + 1))) { // good
						StringBuilder newRet = new StringBuilder("");
						StringBuilder temp = new StringBuilder(a.substring(0, l));
						newRet.append(temp.toString()).append( (Integer.parseInt(a.substring(l, l + 1)) + 1) ).append(ret.toString()).append(Integer.parseInt(a.substring(l, l + 1)) + 1).append(temp.reverse().toString());
						ret = newRet;
					}
				}
			}
		}

		System.out.println(ret.toString());
	}

}
