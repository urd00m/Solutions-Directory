//package Chapter3_1;
/*
ID: alan.li2
LANG: JAVA
TASK: stamps
 */
import java.io.*;
import java.util.*;

public class stamps {
	static int[] stamps; 
	static int n, k; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("stamps.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		k = Integer.parseInt(input.nextToken()); 
		n = Integer.parseInt(input.nextToken()); 
		stamps = new int[n]; 
		for(int i = 0; i < n; i++) {
			if(input.hasMoreElements() == false) 
				input = new StringTokenizer(f.readLine()); 
			stamps[i] = Integer.parseInt(input.nextToken()); 
		}
		f.close();
		
		//modified butterfly
		int[] dp = new int[3000000]; //0 means can't get to that value 1 means it can 
		int[] minStamps = new int[3000000]; 
		dp[0] = 1; 
		int retVal = -1;
		for(int i = 0; i < dp.length; i++) {
			if(dp[i] == 0) {
				retVal = i-1; //the previous value is the last unbroken stamp sum
				break; 
			}
			else 
				for(int stamp : stamps) {
					if(minStamps[i]+1 <= k) { //makes sure it has the correct number of stamps 
						if(dp[i+stamp] == 0) { //if hasn't been visited then the minimum is set 
							minStamps[i+stamp] = minStamps[i]+1; 
							dp[i+stamp] = 1;
						}
						else //has been visited, then it chooses the one that took the least amount of stamps 
							minStamps[i+stamp] = Math.min(minStamps[i+stamp], minStamps[i]+1); //minimum stamps needed 
						
					}
				}
		}
		
		
		//ouput: return retVal 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stamps.out"))); 
		out.println(retVal);
		out.close();
	}
}
