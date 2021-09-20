package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: frac1
 */

import java.util.*;
import java.io.*;
public class frac1 {
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
		int n = Integer.parseInt(f.readLine());
		int size = (int)(2+ (((n-1)*n)/2));
		//method
		//generate all possible fractions, have two arrays, one for fractions, one for double value, then sort and print the fractions
		point[] values = new point[size];
		String[] fracs = new String[size];
		values[0] = new point(0, 0, 0);
		fracs[0] = "0/1";
		values[1] = new point(1, 1, 1);
		fracs[1] = "1/1";
		int counter = 2; 
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j < i; j++) {
				fracs[counter] = j + "/" + i;
				values[counter] = new point( (j/(i*1.0)), counter, j);
				counter++;			
			}
		}

		//sort 
		//can use bubble sort
		for (int i = 0; i < size; i++)       
	       for (int j = i; j < size; j++)  {
	           if (values[i].getValue() > values[j].getValue()) 
	              swap(values, i, j); 
	           else if(values[i].getValue() == values[j].getValue()) //get it to put simplest form first
	        	   if(values[i].getNumerator() > values[j].getNumerator())
	        		   swap(values, i, j);
	        	   
	       }
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		for(int i = 0; i < size; i++) {  //need to prune
			if(i == 0 || values[i].getValue() != values[i-1].getValue()) out.println(fracs[values[i].getIndex()]);
		}
		out.close();
		
	}
	
	public static void swap(point[] a, int i, int j)
	{ 
		point store = a[i];
		a[i] = a[j];
		a[j] = store;
	} 
	
	public static class point {
		double value;
		int pointIndex; 
		int numerator;
		public point(double v, int p, int num) {
			value = v;
			pointIndex = p; 
			numerator = num;
		}
		
		public double getValue() {
			return value; 
		}
		
		public int getIndex() {
			return pointIndex;
		}
		
		public int getNumerator() {
			return numerator;
		}
	}

}
