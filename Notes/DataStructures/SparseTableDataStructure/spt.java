package SparseTableDataStructure;


//dynamic programming 
//answer to rmq problems in O(n log n) building but O(1) query 
//it must be a static rmq problem if it the rmq problem is dynamic use segment tree 
public class spt {
	public static void main(String args[]) {
		int[] a = {18,17,13,19,15,1,20};
		sparseTableDT temp = new sparseTableDT(7, a); 
		System.out.println(temp.query(0, 6)); 
	}
	
	public static class sparseTableDT {
		public int MAX_N = 1000000;
		public int LOG_TWO_N = 20;
		public int[] _A; int[][] SpT; 
		public sparseTableDT(int n, int[] A) {
			_A = new int[n]; 
			SpT = new int[n][(int)(Math.log10(n*1.0)/Math.log10(2.0))+1]; 
			for(int i = 0; i < n; i++) {
				_A[i] = A[i]; 
				SpT[i][0] = i; //RMQ of sub array starting at index i+length 2^0=1
			}
			for(int j = 1; (1<<j) <= n; j++) {
				for(int i = 0; i + (1<<j)-1 < n; i++) {
					if(_A[SpT[i][j-1]] < _A[SpT[i+(1<<(j-1))][j-1]]) {
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
			if(_A[SpT[i][k]] <= _A[SpT[j-(1<<k)+1][k]]) return SpT[i][k]; 
			else return SpT[j-(1<<k)+1][k];
		}
	}
}
