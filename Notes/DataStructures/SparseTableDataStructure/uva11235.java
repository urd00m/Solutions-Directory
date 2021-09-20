
import java.util.*;
import java.io.*;

public class Main {
	static int[] v, count, start; 
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in) ); //  FileReader("Main.in")
		while(f.ready()) {
			String temp = f.readLine(); 
			if(temp.trim().equals("0")) break; 
			StringTokenizer input = new StringTokenizer(temp);
			int n = Integer.parseInt(input.nextToken()); int q = Integer.parseInt(input.nextToken()); 
			input = new StringTokenizer(f.readLine()); 
			v = new int[n]; count = new int[n]; start = new int[n]; //add +100000 due to negatives 
			int curStarti = 0; 
			int freq = 0; 
			for(int i = 0; i <= n; i++) {
				if(i != n) v[i] = Integer.parseInt(input.nextToken()); 
				if(i == n || v[i] != v[curStarti]) {
					for(int j = i-1; j >= curStarti; j--) {
						count[j] = freq;
						start[j] = curStarti; 
					}
					freq = 1; 
					curStarti = i; 
				}
				else {
					freq++; 
				}
			}
			sparseTableDT rmq = new sparseTableDT(n, count); 
			for(int k = 0; k < q; k++) {
				input = new StringTokenizer(f.readLine()); 
				int i = Integer.parseInt(input.nextToken())-1; int j = Integer.parseInt(input.nextToken())-1;
				if(v[i] != v[j]) {
					int c1 = start[i]+count[i]-i; 
					int c2 = j-start[j]+1; 
					int i1 = i+c1; 
					int i2 = start[j]-1; 
					int c3 = 0; 
					if(i1 < i2) c3 = count[rmq.query(i1, i2)];
					System.out.println(Math.max(c1, Math.max(c2, c3)));
				}
				else {
					System.out.println( (j-i+1) );
				}
			}
		}
	}
	public static class sparseTableDT {
		public int MAX_N = 1000000;
		public int LOG_TWO_N = 20;
		public int[] _A; int[][] SpT; 
		public sparseTableDT(int n, int[] A) {
			_A = new int[n]; 
			SpT = new int[n][(int)(Math.log10(n*1.0)/Math.log10(2.0) +.99999999)]; 
			for(int i = 0; i < n; i++) {
				_A[i] = A[i]; 
				SpT[i][0] = i; //RMQ of sub array starting at index i+length 2^0=1
			}
			for(int j = 1; (1<<j) <= n; j++) {
				for(int i = 0; i + (1<<j)-1 < n; i++) {
					if(_A[SpT[i][j-1]] > _A[SpT[i+(1<<(j-1))][j-1]]) {
						SpT[i][j] = SpT[i][j-1]; 
					}
					else {
						SpT[i][j] = SpT[i+(1<<(j-1))][j-1]; 
					}
				} 
			}
		}
		public int query(int i, int j) {
			int k = (int)Math.floor(Math.log10((double)j-i+1)/Math.log10(2.0)); 
			if(_A[SpT[i][k]] >= _A[SpT[j-(1<<k)+1][k]]) return SpT[i][k]; 
			else return SpT[j-(1<<k)+1][k];
		}
	}
	
}
