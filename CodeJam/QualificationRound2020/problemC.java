//package QualificationRound2020;
/*
ID: urd00m
LANG: JAVA
TASK: parenting partnering returns
 */
import java.io.*;
import java.util.*;
//offline: sort then run 


public class Solution {
	static int t, n; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine()); 
		for(int cn = 1; cn  < t+1; cn++) {
			n = Integer.parseInt(f.readLine()); 
			pair[] intervals = new pair[n]; 
			for(int i = 0; i < n; i++) {
				input = new StringTokenizer(f.readLine()); 
				intervals[i] = new pair(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken()), i); 
			}
			Arrays.sort(intervals, new Comparator<pair>() {
				@Override 
				public int compare(pair a, pair b) { //increasing 
					return a.l - b.l; 
				}
			});
			
			//if at any time an interval has 2 or more intervals then it fails print impossible 
			//simply simulation 
			//only 1440 maybe there is a faster way to do this but simulation is fast enough 
			String[] ret = new String[n]; //so the specific locations are marked
			int i = 0; 
			int cEnd = -1, jEnd = -1; 
			boolean works = false; 
			for(int time = 0; time < 1441; time++) {
				if(cEnd == time) cEnd = -1; //freed to do things now 
				if(jEnd == time) jEnd = -1;
				if(i < n && cEnd == -1 && intervals[i].l == time) {
					cEnd = intervals[i].r; 
					ret[intervals[i].i] = "C"; 
					i++; 
				}
				if(i < n && jEnd == -1 && intervals[i].l == time) {
					jEnd = intervals[i].r; 
					ret[intervals[i].i] = "J"; 
					i++; 
				}
				if(i < n && time == intervals[i].l && (cEnd != -1 && jEnd != -1)) {
					works = true; 
					break; 
				}
			}
			
			if(works == true) System.out.println("Case #" + cn + ": IMPOSSIBLE");
			else {
				System.out.print("Case #" + cn + ": ");
				for(i = 0; i < n; i++) {
					System.out.print(ret[i]);
				}
				System.out.println();
			}
			
		}
	}
	
	public static class pair {
		int l, r, i; 
		public pair(int a, int b, int c) {
			l = a; 
			r = b; 
			i = c; 
		}
	}
	
}
