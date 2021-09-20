package SegmentedTree;

//rmq and rsq implementation library 
public class SegTree {
	public static void main(String args[]) {
		int[] arr = {18, 17, 13, 19, 15, 11, 20 };
		SegmentTree test = new SegmentTree(arr);
		System.out.println(test.rmq(1, 3));
		System.out.println(test.rmq(4, 6));
		System.out.println(test.rsq(1, 3)); //good 
		System.out.println(test.rsq(4, 6));
		System.out.println(test.rsq(3, 5));
		test.update(2, 99);
		System.out.println();
		System.out.println(test.rmq(1, 3));
		System.out.println(test.rsq(1, 3));
		System.out.println(test.rsq(4, 6));
		System.out.println(test.rsq(3, 5));
		for(int item : test.sq) System.out.print(item + " " );
	}
	
	
	public static class SegmentTree {
		public int[] st, A, sq; 
		public int n; 
		public int left(int p) { return p<<1; }
		public int right(int p) { return (p<<1)+1; }
		public int parent(int p) { return (p>>1); }
	
		
		public SegmentTree(int[] _A) {
			A = _A; n = _A.length; 
			st = new int[4*n]; 
			sq = new int[4*n]; 
			build(1, 0, n-1); 
		}
		
		public void update(int i , int v) {
			int temp = A[i]; 
			A[i] = v; 
			updatem(1, 0, n-1, i, i, temp); 
			updates(1, 0, n-1, i, i, temp); 
		}
		public void updatem(int p, int L, int R, int i, int j, int temp) { //O(log n)
			if(i > R || j < L) {
				//do nothing
			}
			else if(L >= i && R <= j) {
				st[p] = i; 
			}
			else {
				updatem(left(p), L, (L+R)/2, i, j, temp); 
				updatem(right(p), (L+R)/2+1, R, i, j, temp); 
				int p1 = st[left(p)], p2 = st[right(p)];
				st[p] = (A[p1] <= A[p2]) ? p1 : p2; 
			}
			
		}
		public void updates(int p, int L, int R, int i, int j, int temp) { //O(log n)
			if(i > R || j < L) {
				//do nothing
			}
			else if(L >= i && R <= j) {
				sq[p] = A[i]; 
			}
			else {
				updates(left(p), L, (L+R)/2, i, j, temp); 
				updates(right(p), (L+R)/2+1, R, i, j, temp); 
				sq[p] = sq[left(p)]+sq[right(p)]; 
			}
		}
		public void build(int p, int L, int R) {
			if( L == R) {
				st[p] = L;
				sq[p] = A[L]; 
			}
			else {
				build(left(p), L, (L+R)/2); 
				build(right(p), (L+R)/2+1, R); 
				int p1 = st[left(p)], p2 = st[right(p)];
				int s1 = sq[left(p)], s2 = sq[right(p)]; 
				st[p] = (A[p1] <= A[p2]) ? p1 : p2; 
				sq[p] = s1+s2; 
			}
		}
		public int rmq(int i, int j) {
			return (rmq(1, 0, n-1, i, j)); 
		}
		public int rmq(int p, int L, int R, int i, int j) { //O(log n)
			if(i > R || j < L) return -1; 
			if(L >= i && R <= j) return st[p]; 
			int p1 = rmq(left(p), L, (L+R)/2, i, j); 
			int p2 = rmq(right(p), (L+R)/2+1, R, i, j); 
			
			if(p1 == -1) return p2; 
			if(p2 == -1) return p1; 
			return(A[p1] <= A[p2]) ? p1 : p2; 
		}
		public int rsq(int i, int j) {
			if(i == j) return 0; 
			else return (rsq(1, 0, n-1, i, j)); 
		}
		public int rsq(int p, int L, int R, int i, int j) { //O(log n)
			if(i > R || j < L) return -1; 
			if(L >= i && R <= j) return sq[p]; 
			int p1 = rsq(left(p), L, (L+R)/2, i, j); 
			int p2 = rsq(right(p), (L+R)/2+1, R, i, j); 
			
			if(p1 == -1) return p2; 
			if(p2 == -1) return p1; 
			return p1+p2; 
		}
		
	}
}
