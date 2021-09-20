package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: crypt1
 */

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class crypt1 {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		
		//input
		int N = Integer.parseInt(f.readLine());
		StringTokenizer in = new StringTokenizer(f.readLine());
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(in.nextToken());
		}
		Arrays.sort(nums);
		
		//brute force approach works since only 9 possible input values 
		int[] three = new int[N*N*N];
		int[] two = new int[N*N];
		
		//assign three
		int counter = 0;
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length; j++) {
				for(int z = 0; z < nums.length; z++) {
					//System.out.println(counter + " " + "" + nums[i] + nums[j] + nums[z]); //delete
					three[counter] = Integer.parseInt("" + nums[i] + nums[j] + nums[z]);
					counter++;
				}
			}
		}
		//for two 
		counter = 0;
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length; j++) {
					two[counter] = Integer.parseInt("" + nums[i] + nums[j]);
					counter++;
			}
		}
		
		//first partial sum
		counter = 0;
		for(int i = 0; i < three.length; i++) {
			for(int j = 0; j < two.length; j++) {
				//first partial sum
				if( (""+((three[i])*(two[j]%10))).length() == 3 && good(""+((three[i])*(two[j]%10)), nums) == true) {
					//second partial sum
					if( (""+((three[i])*((two[j]%100)/10))).length() == 3 && good(""+((three[i])*((two[j]%100)/10)), nums) == true) {
						//product
						if( (""+(three[i]*two[j])).length() == 4 && good((""+(three[i]*two[j])), nums) == true) {
							counter++;
						}
					}
				}
					
			}
		}
		
		out.println(counter);
		out.close();
		
	}
	
	public static boolean good(String num, int[] nums) {
		boolean status = true;
		for(int i = 0; i < num.length(); i++) {
			if( isIn(num.substring(i, i+1), nums) == false) status = false; 
		}
		return status; 
	}
	
	public static boolean isIn(String one, int[] num) {
		boolean answer = false;
		for(int i = 0; i < num.length; i++) {
			if(one.equals("" + num[i]) == true ) answer = true;
		}
		return answer;
	}

}
