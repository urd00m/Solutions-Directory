//package Chapter4_2;
/*
ID: alan.li2
LANG: JAVA
TASK: job
 */
import java.io.*;
import java.util.*;
	
public class job {
	static int n; 
	static int aNum, bNum; 
	static int[] aTime, bTime; 
	static int finalTimea, finalTimeb; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("job.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken());
		aNum = Integer.parseInt(input.nextToken()); 
		bNum = Integer.parseInt(input.nextToken()); 
		input = new StringTokenizer(f.readLine()); 
		aTime = new int[aNum]; 
		bTime = new int[bNum]; 
		for(int i = 0; i < aNum; i++) {
			if(input.hasMoreElements() == false) {
				input = new StringTokenizer(f.readLine()); 
			}
			aTime[i] = Integer.parseInt(input.nextToken()); 
		} for(int i = 0; i < bNum; i++) {
			if(input.hasMoreElements() == false) {
				input = new StringTokenizer(f.readLine()); 
			}
			bTime[i] = Integer.parseInt(input.nextToken()); 
		}
		f.close();
		
		//algorithm greedy 
		//create a array of the minimum times it would take for each job and then find the final total time spent, and match it in 
		//reverse order to save time 
		find(); 
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("job.out")));
		out.println(finalTimea + " " + finalTimeb);
		out.close(); 
	}
	
	public static void find() { 
		int[] joba = new int[n]; 
		int[] jobb = new int[n]; 
		
		jobTimes(joba, aTime); 
		jobTimes(jobb, bTime); 
		
		for(int item : joba) {
			finalTimea = Math.max(finalTimea, item); 
		}
		
		for(int i = 0; i < n; i++) { //inorder to save time you match the begginging to joba to the end of jobs in order to save the most amount of time 
			finalTimeb = Math.max(finalTimeb, joba[i]+jobb[n-i-1]); 
		}
	}
	public static void jobTimes(int[] jobs, int[] timeUses)  { //updates jobs
		int[] timeSpent = new int[timeUses.length]; 
		for(int i = 0; i < n; i++) {
			int minTime = Integer.MAX_VALUE;
			int minLoc = -1;
			for(int j = 0; j < timeUses.length; j++) {
				if(timeUses[j] + timeSpent[j] < minTime) {
					minLoc = j; 
					minTime = timeUses[j] + timeSpent[j]; 
				}
			}
			jobs[i] = minTime;  
			timeSpent[minLoc] = minTime; 
		}
	}
}
