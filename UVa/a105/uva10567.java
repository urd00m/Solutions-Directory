package a105;
/*
ID: urd00m
LANG: JAVA
TASK: uva10567
 */
import java.io.*;
import java.util.*;

public class uva10567 {
	static int n; 
	static ArrayList<Integer>[] graph = new ArrayList[58]; 
	public static void main(String args[]) throws IOException, InterruptedException {
		Thread.sleep(3000);
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); 
		StringBuilder input = new StringBuilder(f.readLine());
		for(int i = 0; i < 58; i++) graph[i] = new ArrayList<Integer>();
		for(int i = 0; i < input.length(); i++) graph[input.charAt(i)-'A'].add(i);
		n = Integer.parseInt(f.readLine()); 
		for(int i = 0; i < n; i++) {
			input = new StringBuilder(f.readLine()); 
			int idx = 0; int min = Integer.MAX_VALUE; int max = -1;  
			for(int j = 0; j < input.length(); j++) { 
				int a = binarySearch(0, graph[input.charAt(j)-'A'].size()-1, idx, graph[input.charAt(j)-'A']);
				if(a == -1) {
					System.out.println("Not matched");
					break; 
				}
				else {
					min = Math.min(min, a); max = Math.max(max, a); 
					idx = a+1; 
					if(j == input.length()-1) {
						System.out.println("Matched " + min + " " + max);
					}
				}
			}
		}
	}
	
	public static int binarySearch(int l, int r, int idx, ArrayList<Integer> graph) {
		//System.out.println(l + " " + r + " " + idx);
        int start = 0, end = graph.size() - 1;  
        int ans = -1;  
        while (start <= end) {  
            int mid = (start + end) / 2;  
    
            
            if(graph.get(mid) == idx) return idx; 
            // Move to right side if target is  
            // greater.  
            if (graph.get(mid) < idx) {  
                start = mid + 1;  
            }  
            // Move left side.  
            else {  
                ans = mid;  
                end = mid - 1;  
            }  
        }  
        if(ans == -1) return -1; 
        else return graph.get(ans);  
		
	}
}
