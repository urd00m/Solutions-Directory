//apackage Chapter3_1;
/*
ID: alan.li2
LANG: JAVA
TASK: contact
 */

import java.io.*;
import java.util.*;

public class contact {
	static int a, b, n;
	static String message; 
	public static void main(String args[]) throws IOException {
		//input 
		//must use string builder 
		BufferedReader f = new BufferedReader(new FileReader("contact.in")); 
		StringBuilder input = new StringBuilder();
		StringTokenizer inputMain = new StringTokenizer(f.readLine());
		a = Integer.parseInt(inputMain.nextToken());
		b = Integer.parseInt(inputMain.nextToken());
		n = Integer.parseInt(inputMain.nextToken()); 
		while (f.ready() == true) {
			input.append(f.readLine()); 
		}
		message = input.toString(); 
		f.close();
		
		//go through the points and add values to a hashtable 
		//this is O(M*N) where n is the difference of a and b and M is the size of the message. 
		Hashtable<String, Integer> pattern = new Hashtable<String, Integer>();
		for(int i = 0; i < message.length(); i++) { //each byte of the message
			String patternRecord = ""; 
			if(i+a <= message.length()) {
				patternRecord = message.substring(i,i+a); 
				if(pattern.putIfAbsent(patternRecord, 1) != null) 
					pattern.put(patternRecord, pattern.get(patternRecord)+1);
				for(int j = a; j < b; j++) { //the look ahead 
					if(i+j < message.length()) {
						patternRecord = patternRecord + message.charAt(i+j);
						if(pattern.putIfAbsent(patternRecord, 1) != null) 
							pattern.put(patternRecord, pattern.get(patternRecord)+1);
					}
					else break; 
				}
			}
		}
		//getting keys 
		Enumeration<String> e = pattern.keys(); 
		slot[] store = new slot[pattern.size()]; 
		int i = 0; 
		while(e.hasMoreElements()) {
			String key = e.nextElement(); 
			store[i] = new slot(key, pattern.get(key)); 
			i++; 
		}
		
		Arrays.sort(store, new Comparator<slot>() {
			@Override
			public int compare(slot a, slot b) { 
				if(a.getVal() == b.getVal()) {
					if((a.getKey()+"").length() == (b.getKey()+"").length()) {
						//lengths are equal then juast return the smallest valued key one
						return Integer.parseInt(a.getKey(),2) - Integer.parseInt(b.getKey(),2); 
					}
					else 
						return (a.getKey()+"").length()-(b.getKey()+"").length(); //if their lengths aren't the same and they have the same value return the one that is shortest length first
				}
				else 
					return b.getVal() - a.getVal(); 
			}
		});
		//print(store); 
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contact.out"))); 
		int idx = 0; 
		for(int count = 0; count < n; count++) {
			if(idx >= store.length)
				break; 
			int masterVal = store[idx].getVal(); 
			out.println(masterVal);
			//finds all the ones with the same index 
			int onTheLine = 0; 
			while(idx < store.length && store[idx].getVal() == masterVal) {
				if(onTheLine == 0) {
					out.print(store[idx].getKey());
				}
				else if(onTheLine != 5) 
					out.print(" " + store[idx].getKey());
				else
					out.println(" " + store[idx].getKey()); 
				onTheLine = (onTheLine+1)%6;
				idx++; 
			}
			if(onTheLine != 0) //hasn't been indented yet 
				out.println();
		}
		out.close();
	}
	
	public static void print(slot[] a) {
		for(slot item : a) {
			System.out.println(item.getKey() + " " + item.getVal()); 
		}
	}
	
	//for storage of the keys 
	public static class slot {
		String key; 
		int val; 
		public slot(String a, int b) {
			key = a;
			val = b; 
		}
		public String getKey() {
			return key; 
		}
		public int getVal() {
			return val; 
		}
	}
}
