package FenwickTree;

public class fenTree {
	public static void main(String args[]) {
		int[] f = { 2,4,5,5,6,6,6,7,7,8,9}; //shifted up by one 
		FenwickTree ft = new FenwickTree(10); 
		for(int i = 0; i < 11; i++) ft.adjust(f[i], 1);
		System.out.println(ft.rsq(1, 1));
		System.out.println(ft.rsq(3, 6));
	}
	
	public static class FenwickTree {
		int[] ft;
		public FenwickTree(int n) {
			ft = new int[n+1]; 
		}
		public int LSOne(int x) {
			return (x & (-x)); 
		}
		public int rsq(int b) {
			int sum = 0; for(; b != 0; b-= LSOne(b)) sum+= ft[b]; 
			return sum; 
		}
		public int rsq(int a, int b) {
			return rsq(b) - (a == 1 ? 0 : rsq(a-1)); 
		}
		public void adjust(int k, int v) {
			for(; k < ft.length; k += LSOne(k)) ft[k] += v; 
		}
	}
}
