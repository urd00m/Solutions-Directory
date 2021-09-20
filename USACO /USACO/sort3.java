package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: sort3
 */

import java.util.*;
import java.io.*;
public class sort3 {
	static int[] nums;
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
		int n = Integer.parseInt(f.readLine());
		nums = new int[n];
		int[] sortedNums = new int[n];
		for(int i = 0; i < n; i++) {
			int store = Integer.parseInt(f.readLine());
			nums[i] = store;
			sortedNums[i] = store;
		}
		
		//method:
		//step 1: sort the elements 
		//then match it up to the sort and count 
		Arrays.sort(sortedNums);
		
		//matching 
		int count = 0;
		for(int i = 0; i < n; i++) { //quick matches
			if(nums[i] != sortedNums[i]) {
				int scan = nums[0];
				int index = 0;
				boolean connected = true;
				if(scan == sortedNums[i] && scan != sortedNums[index] && nums[i] == sortedNums[index]) connected = false;
				while(index < n-1 && (scan != sortedNums[i] || connected)) { //make sure it finds something that isn't connected
					connected = true;
					index++;
					scan = nums[index];
					if(scan == sortedNums[i] && scan != sortedNums[index] && nums[i] == sortedNums[index]) connected = false;
				}
				if(index != n-1) {
					swap(nums, i, index); //swap
					count++;
				}
				
			}
		}
		for(int i = 0; i < n; i++) {
			if(nums[i] != sortedNums[i]) {
				int scan = nums[0];
				int index = 0;
				boolean connected = true;
				if(scan == sortedNums[i] && scan != sortedNums[index]) connected = false;
				while(scan != sortedNums[i] || connected ) { //make sure it finds something that isn't connected
					connected = true;
					index++;
					scan = nums[index];
					if(scan == sortedNums[i] && scan != sortedNums[index]) connected = false;
				}
				swap(nums, i, index); //swap
				count++;
			}
		}

		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		 out.println(count);
		out.close();
	}
	public static void swap(int[] a, int first, int last) { //swap
		int save = a[first];
		a[first] = a[last];
		a[last] = save;
	}

}
