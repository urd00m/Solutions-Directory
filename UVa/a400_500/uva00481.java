//package a400_500;
/*
ID: urd00m
LANG: JAVA
TASK: uva00481
 */
import java.io.*;
import java.util.*;
	
public class Main {
	static ArrayList<Integer> set = new ArrayList<Integer>();
	static int n;
	static int[] LIS;
	static int[] p;
	static int[] l_id; 
	public static void main(String args[]) throws IOException, InterruptedException {
		Thread.sleep(3000);
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); 
		while(f.ready() == true) {
			 set.add(Integer.parseInt(f.readLine())); 
		}
		n = set.size(); 
		ArrayList<Integer> L = new ArrayList<Integer>(); p = new int[n]; l_id = new int[n]; 
		//bottom-up DP
		int lis = 0; 
		int lis_end = 0; 
		for (int i = 0; i < n; ++i) {
		      int pos = Collections.binarySearch(L, set.get(i));
		      if (pos < 0) pos = -(pos + 1); // some adjustments are needed
		      if (pos >= L.size()) L.add(set.get(i));
		      else                 L.set(pos, set.get(i));
		      l_id[pos] = i;
		      p[i] = pos > 0 ? l_id[pos - 1] : -1;
		      if (pos + 1 > lis) {
		        lis = pos + 1;
		        lis_end = i;
		      }
		    }
		ArrayList<Integer> ret = new ArrayList<Integer>(); 
		int cur = lis_end; 
		while(cur != -1) {
			ret.add(set.get(cur));
			cur = p[cur]; 
		}
		Collections.reverse(ret);
		System.out.println(lis);
		System.out.println("-");
		for(int item : ret) {
			System.out.println(item);
		}
	}

}
