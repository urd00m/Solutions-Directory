package exampleProbs;
//package febGold2019;
/*
ID: alwang
LANG: JAVA
TASK: dishes
 */
import java.io.*;
import java.util.*;

public class dishes {
	static int n; 
	static int output; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("dishes.in")); 
		n = Integer.parseInt(f.readLine()); 
		//algorithm run through follow rules o(n)
		ArrayList<ArrayList<Integer>> dishes = new ArrayList<ArrayList<Integer>>();
		int maxClean = -1; 
		for(int i = 0; i < n; i++) {
			int cur = Integer.parseInt(f.readLine());
			if(cur < maxClean) {
				output = i; 
				break; 
			}
			int j; 
			for(j = 0; j < dishes.size(); j++) { //finding where to place 
				if(dishes.get(j).get(0) > cur) {
					break; 
				}
			}
			if(j == dishes.size()) { //no place so adds at end 
				dishes.add(new ArrayList<Integer>()); 

			}
			//removing dishes less then it 
			while(dishes.get(j).isEmpty() == false && dishes.get(j).get(dishes.get(j).size()-1) < cur) {
				maxClean = dishes.get(j).remove(dishes.get(j).size()-1); 
			}
			dishes.get(j).add(cur); 
		}
		
		//output 
		f.close();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dishes.out"))); 
		out.println(output);
		out.close();
	}
}
