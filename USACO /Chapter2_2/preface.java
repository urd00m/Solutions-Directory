package Chapter2_2;
/*
ID: alan.li2
LANG: JAVA
TASK: preface
 */

import java.util.*;
import java.io.*;

public class preface {
	static int n;
	static int I;
	static int V;
	static int X;
	static int L;
	static int C;
	static int D;
	static int M;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("preface.in"));
		n = Integer.parseInt(f.readLine());
		f.close();

		// algorithm
		// brute force, go through all page numbers and calculate the pages
		for (int i = 1; i <= n; i++) {
			add(i);
		}

		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
		if (I != 0)
			out.println("I " + I);
		if (V != 0)
			out.println("V " + V);
		if(X != 0)
			out.println("X " + X);
		if(L != 0)
			out.println("L " + L);
		if(C != 0)
			out.println("C " + C);
		if(D != 0)
			out.println("D " + D);
		if(M != 0)
			out.println("M " + M);
		out.close();

	}

	// figures out the number of i's and v's and adds to total value
	public static void add(int page) {
		String pNumber = "" + page;
		int digitNumber = 1;
		for (int i = pNumber.length()-1; i >= 0; i--) {
			int digit = Integer.parseInt(pNumber.substring(i, i + 1));
			switch (digit) {
			case 1:
				if(digitNumber == 1)
					I += 1;
				else if(digitNumber == 2) 
					X += 1; 
				else if(digitNumber == 3) 
					C += 1; 
				else if(digitNumber == 4) 
					M += 1; 
				break;
			case 2:
				if(digitNumber == 1)
					I += 2;
				else if(digitNumber == 2) 
					X += 2; 
				else if(digitNumber == 3) 
					C += 2; 
				else if(digitNumber == 4) 
					M += 2; 
				break;
			case 3:
				if(digitNumber == 1)
					I += 3;
				else if(digitNumber == 2) 
					X += 3; 
				else if(digitNumber == 3) 
					C += 3; 
				else if(digitNumber == 4) 
					M += 3; 
				break;
			case 4:
				if(digitNumber == 1) {
					I += 1;
					V += 1; 
				}
				else if(digitNumber == 2) {
					X += 1; 
					L += 1; 
				}
				else if(digitNumber == 3)  {
					C += 1;
					D += 1; 
				}
				break;
			case 5:
				if(digitNumber == 1) {
					V += 1; 
				}
				else if(digitNumber == 2) {
					L += 1; 
				}
				else if(digitNumber == 3)  {
					D += 1; 
				}
				break;
			case 6:
				if(digitNumber == 1) {
					I += 1;
					V += 1; 
				}
				else if(digitNumber == 2) {
					X += 1; 
					L += 1; 
				}
				else if(digitNumber == 3)  {
					C += 1;
					D += 1; 
				}
				break;
			case 7:
				if(digitNumber == 1) {
					I += 2;
					V += 1; 
				}
				else if(digitNumber == 2) {
					X += 2; 
					L += 1; 
				}
				else if(digitNumber == 3)  {
					C += 2;
					D += 1; 
				}
				break;
			case 8:
				if(digitNumber == 1) {
					I += 3;
					V += 1; 
				}
				else if(digitNumber == 2) {
					X += 3; 
					L += 1; 
				}
				else if(digitNumber == 3)  {
					C += 3;
					D += 1; 
				}
				break;
			case 9:
				if(digitNumber == 1) {
					I += 1;
					X += 1; 
				}
				else if(digitNumber == 2) {
					X += 1; 
					C += 1; 
				}
				else if(digitNumber == 3)  {
					C += 1;
					M += 1; 
				}
				break;
			}
			digitNumber++; 
		}

	}
}
