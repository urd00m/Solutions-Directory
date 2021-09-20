package a101;

import java.io.*;
import java.util.*;

public class uva10149 {

	static int[][] round, memo;
	static int[][] roundInfo;
	static pair[][] parent; 
	static int dp(int idx, int used, int fSum) {
		if (idx == 13) {
			parent[used][fSum] = new pair(-1, -1); 
			memo[used][fSum] = fSum >= 63 ? 35 : 0; 
			return fSum >= 63 ? 35 : 0;
			
		}

		if (memo[used][fSum] != -1)
			return memo[used][fSum];
		int rSum = roundInfo[idx][0], ret = -1;

		// Category 7
		if ((used & 1<<6) == 0) {
			int a = rSum + dp(idx + 1, used | 1<<6, fSum); 
			if(a > ret) {
				ret = a;
				parent[used][fSum] = new pair(used | 1<<6, fSum); 
			}
		}

		// Categories 1 - 6
		for (int i = 1; i <= 6; ++i)
			if ((used & 1 << (i-1)) == 0) {
				int x = roundInfo[idx][i];
				int a = x + dp(idx + 1, used | 1 << (i-1), fSum + x); 
				if(a > ret) {
					ret = a;
					parent[used][fSum] = new pair(used | 1 << (i-1), fSum+x); 
				}
			}

		int maxSimilar = roundInfo[idx][8];
		// Category 8
		if ((used & 1 << 7) == 0) {
			int a = (maxSimilar >= 3 ? rSum : 0) + dp(idx + 1, used | 1 << 7, fSum); 
			if(a > ret) {
				ret = a;
				parent[used][fSum] = new pair(used | 1 << 7, fSum); 
			}
		}

		// Category 9
		if ((used & 1 << 8) == 0) {
			int a = (maxSimilar >= 4 ? rSum : 0) + dp(idx + 1, used | 1 << 8, fSum); 
			if(a > ret) {
				ret = a;
				parent[used][fSum] = new pair(used | 1 << 8, fSum); 
			}
		}

		// Category 10
		if ((used & 1 << 9) == 0) {
			int a = (maxSimilar >= 5 ? 50 : 0) + dp(idx + 1, used | 1 << 9, fSum); 
			if(a > ret) {
				ret = a;
				parent[used][fSum] = new pair(used | 1 << 9, fSum); 
			}
		}

		int seq = roundInfo[idx][9];

		// Category 11
		if ((used & 1 << 10) == 0) {
			int a = (seq >= 4 ? 25 : 0) + dp(idx + 1, used | 1 << 10, fSum); 
			if(a > ret) {
				ret = a; 
				parent[used][fSum] = new pair(used | 1 << 10, fSum); 
			}
		}

		// Category 12
		if ((used & 1 << 11) == 0) {
			int a = (seq >= 5 ? 35 : 0) + dp(idx + 1, used | 1 << 11, fSum); 
			if(a > ret) {
				ret = a;
				parent[used][fSum] = new pair(used | 1 << 11, fSum); 
			}
		}
		

		// Category 13
		if ((used & 1 << 12) == 0) {
			int a = (maxSimilar == 3 && roundInfo[idx][7] == 1 ? 40 : 0) + dp(idx + 1, used | 1 << 12, fSum); 
			if(a > ret) {
				ret = a;
				parent[used][fSum] = new pair(used | 1 << 12, fSum); 
			}
		}

		return memo[used][fSum] = ret;
	}
	static int[] sol;
	static int maxSimilar(int[] x) {
		int ret = 0;
		int[] f = new int[6];
		for (int y : x)
			f[y - 1]++;
		for (int y : f)
			ret = Math.max(ret, y);
		return ret;
	}

	static int pairExists(int[] x) {
		int[] f = new int[6];
		for (int y : x)
			f[y - 1]++;
		for (int y : f)
			if (y == 2)
				return 1;
		return 0;
	}

	static int longestSequence(int[] x) {
		int[] f = new int[6];
		for (int y : x)
			f[y - 1]++;
		int ans = 0;
		for (int i = 0; i < 3; ++i) {
			int cur = 0;
			for (int j = i; j < 6; ++j)
				if (f[j] >= 1)
					++cur;
				else
					break;
			ans = Math.max(ans, cur);
		}
		return ans;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while (sc.ready()) {
			round = new int[13][5];
			roundInfo = new int[13][10];
			for (int i = 0; i < 13; ++i) {
				int s = 0, r[] = round[i];
				for (int j = 0; j < 5; ++j) {
					int x = sc.nextInt();
					s += r[j] = x;
					roundInfo[i][x] += x;
				}
				roundInfo[i][0] = s;
				roundInfo[i][7] = pairExists(r);
				roundInfo[i][8] = maxSimilar(r);
				roundInfo[i][9] = longestSequence(r);
			}
			memo = new int[1 << 13][106];
			parent = new pair[1 << 13][106]; 
			for (int i = 0; i < 1 << 13; ++i)
				Arrays.fill(memo[i], -1);
			sol = new int[14];
			int opt = dp(0, 0, 0); 
			//assembling sol
			pair cur = new pair(0, 0); 
			while(cur.state != -1) {
				pair par = parent[cur.state][cur.fsum]; 
				int cat = par.state & ~cur.state; int i; 
				for( i = 0; i < 13; i++) {
					if( (cat & (1 << i)) > 0) break;   
				}
				if(par.state == -1) sol[13] = memo[cur.state][cur.fsum];  
				else sol[i] = memo[cur.state][cur.fsum] - memo[par.state][par.fsum];
				cur = par; 
			}
			for (int x : sol)
				out.print(x + " ");
			out.println(opt);
		}
		out.flush();
		out.close();
	}
	public static class pair {
		int state, fsum; 
		public pair(int a, int b) {
			state = a; 
			fsum = b; 
		}
	}
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}