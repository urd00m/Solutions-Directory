package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: transform
 */

import java.util.*;
import java.io.*;

public class transform {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		
		//read data
		int answer = 7; 
		int length = Integer.parseInt(f.readLine());
		char[][] before = new char[length][length];
		char[][] after = new char[length][length];
		for(int i = 0; i < length;i++) {
			String item = f.readLine();
			for(int j = 0; j < length; j++) {
				before[i][j] = item.charAt(j);
			}
		}
		for(int i = 0; i < length;i++) {
			String item = f.readLine();
			for(int j = 0; j < length; j++) {
				after[i][j] = item.charAt(j);
			}
		}
		
		
		char[][] test = new char[length][length];
		//90 degree turn 
		test = aTurn(before, length);
		if(equal(test, after) == true) answer = 1;
		
		//180 degree turn
		if(answer == 7 ) {
			test = bTurn(before, length);
			if(equal(test, after) == true) answer = 2;
		}
		
		//270 degree turn
		if(answer == 7 ) {
			test = cTurn(before, length);
			if(equal(test, after) == true) answer = 3;
		}
		
		if(answer == 7) {
			if(equal(dTurn(before, length, 0), after) == true) answer = 4;
		}
		//d + abc turn
		if(answer == 7) {
			if(equal(dTurn(before, length, 1), after) == true) answer = 5;
			if(equal(dTurn(before, length, 2), after) == true) answer = 5;
			if(equal(dTurn(before, length, 3), after) == true) answer = 5;
		}
		
		if(answer == 7) {
			if(equal(before, after) == true) answer = 6;
		}
		out.println(answer);
		out.close();
		
		
	}
	private static boolean equal(char[][] a, char[][] b) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				if(a[i][j] != b[i][j]) return false;
			}
		}
		return true;
	}
	
	private static char[][] aTurn(char[][] before1, int length) {
		char[][] test = new char[length][length];
		int a = 0;
		for(int i = length-1; i >= 0; i--) {

			for(int j = 0; j < length; j++) {
				test[a][j] = before1[j][i];
			}
			a++;
		}
		return test;
	}
	private static char[][] bTurn(char[][] before1, int length) {
		char[][] test = new char[length][length];
		int a = 0;
		int b = 0;
		for(int i = length-1; i >= 0; i--) {
			for(int j = length-1; j >= 0; j--) {
				test[a][b] = before1[i][j];
				b++;
			}
			b = 0;
			a++;
		}
		return test;
	}
	private static char[][] cTurn(char[][] before1, int length) {
		char[][] test = new char[length][length];
		int a = 0;
		int b = 0;
		for(int i = 0; i < length;i++) {

			for(int j = length-1; j >= 0; j--) {
				test[a][b] = before1[j][i];
				b++;
			}
			b = 0;
			a++;
		}
		return test;
	}
	
	private static char[][] dTurn(char[][] before1, int length, int type) {
		char[][] test = new char[length][length];
		int a = 0;
		int b = 0;
		for(int i = 0; i < length;i++) {
			for(int j = length-1; j  >= 0; j--) {
				test[a][b] = before1[i][j];
				b++;
			}
			b = 0;
			a++;
		}
		if(type == 1) test = aTurn(test, length);
		else if(type == 2) test = bTurn(test, length);
		else if(type == 3) test = cTurn(test, length);

		return test;
	}

}
