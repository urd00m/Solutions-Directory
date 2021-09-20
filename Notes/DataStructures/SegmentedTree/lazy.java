package SegmentedTree;

public class lazy {

	public static void main(String args[]) {
		int[] A = { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0 };
		lazyPropagation test = new lazyPropagation(A);
		test.updateRange(1, 0, A.length - 1, 0, 17, 2);
		test.updateRange(1, 0, A.length - 1, 0, 5, -1);
		System.out.println(test.queryRange(1, 0, A.length - 1, 1, 10));
		test.updateRange(1, 0, A.length - 1, 4, 9, 1); // 1 is 0, 2 is set to 1, -1 is inverse and 0 is do nothing
		System.out.println(test.queryRange(1, 0, A.length - 1, 2, 10));
	}

	public static class lazyPropagation {

		public int[] tree, lazy;
		int[] A;
		int n;

		public int left(int p) {
			return p << 1;
		}

		public int right(int p) {
			return (p << 1) + 1;
		}

		public int parent(int p) {
			return (p >> 1);
		}

		public lazyPropagation(int[] _A) {
			A = _A;
			n = A.length;
			tree = new int[4 * _A.length];
			lazy = new int[4 * _A.length];
			build(1, 0, n - 1);
		}

		public void build(int p, int L, int R) {
			if (L == R) {
				tree[p] = A[L];
			} else {
				build(left(p), L, (L + R) / 2);
				build(right(p), (L + R) / 2 + 1, R);
				int s1 = tree[left(p)], s2 = tree[right(p)];
				tree[p] = s1 + s2;
			}
		}

		void updateRange(int node, int start, int end, int l, int r, int val)
		{
		    if(lazy[node] != 0)
		    { 
		        // This node needs to be updated
		        tree[node] += (end - start + 1) * lazy[node];    // Update it
		        if(start != end)
		        {
		            lazy[node*2] += lazy[node];                  // Mark child as lazy
		            lazy[node*2+1] += lazy[node];                // Mark child as lazy
		        }
		        lazy[node] = 0;                                  // Reset it
		    }
		    if(start > end || start > r || end < l)              // Current segment is not within range [l, r]
		        return;
		    if(start >= l && end <= r)
		    {
		        // Segment is fully within range
		        tree[node] += (end - start + 1) * val;
		        if(start != end)
		        {
		            // Not leaf node
		            lazy[node*2] += val;
		            lazy[node*2+1] += val;
		        }
		        return;
		    }
		    int mid = (start + end) / 2;
		    updateRange(node*2, start, mid, l, r, val);        // Updating left child
		    updateRange(node*2 + 1, mid + 1, end, l, r, val);   // Updating right child
		    tree[node] = tree[node*2] + tree[node*2+1];        // Updating root with max value 
		}

		int queryRange(int node, int start, int end, int l, int r)
		{
		    if(start > end || start > r || end < l)
		        return 0;         // Out of range
		    if(lazy[node] != 0)
		    {
		        // This node needs to be updated
		        tree[node] += (end - start + 1) * lazy[node];            // Update it
		        if(start != end)
		        {
		            lazy[node*2] += lazy[node];         // Mark child as lazy
		            lazy[node*2+1] += lazy[node];    // Mark child as lazy
		        }
		        lazy[node] = 0;                 // Reset it
		    }
		    if(start >= l && end <= r)             // Current segment is totally within range [l, r]
		        return tree[node];
		    int mid = (start + end) / 2;
		    int p1 = queryRange(node*2, start, mid, l, r);         // Query left child
		    int p2 = queryRange(node*2 + 1, mid + 1, end, l, r); // Query right child
		    return (p1 + p2);
		}
	}
}
