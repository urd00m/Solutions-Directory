//package janGold2017;

/*
ID: alwang
LANG: JAVA
TASK: cownav
 */
import java.io.*;
import java.util.*;

public class cownav {
	static int n;
	static int[][] graph;
	static int output;
	static boolean[][][][][][] visited;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("cownav.in"));
		n = Integer.parseInt(f.readLine());
		graph = new int[n][n];
		visited = new boolean[n][n][4][n][n][4];
		for (int i = n - 1; i >= 0; i--) {
			String input = f.readLine();
			for (int j = 0; j < n; j++) {
				if (input.charAt(j) == 'H') {
					graph[i][j] = 1;
				}
			}
		}
		f.close();

		// algorithm: BFS but maintains if facing up or right and once both are met exit
		// hale bales at 1 in graph
		Queue<state> next = new LinkedList<state>();
		next.add(new state(0, 0, 0, 0, 0, 1, 0));
		while (next.isEmpty() == false) {
			state cur = next.remove();
			if (cur.xf == n - 1 && cur.yf == n - 1 && cur.xr == n - 1 && cur.yr == n - 1) {
				output = cur.steps;
				break;
			}

			// 3 commands forward, left and right for the one starting f and the one
			// starting r
			state movingF = move(cur.xf, cur.yf, cur.facingf);
			state movingR = move(cur.xr, cur.yr, cur.facingr);
			if (visited[movingF.xf][movingF.yf][cur.facingf][movingR.xf][movingR.yf][cur.facingr] == false) {
				next.add(new state(movingF.xf, movingF.yf, cur.facingf, movingR.xf, movingR.yf, cur.facingr,
						cur.steps + 1));
				visited[movingF.xf][movingF.yf][cur.facingf][movingR.xf][movingR.yf][cur.facingr] = true;
			}
			if (visited[cur.xf][cur.yf][(cur.facingf + 1) % 4][cur.xr][cur.yr][(cur.facingr + 1) % 4] == false) {
				next.add(new state(cur.xf, cur.yf, (cur.facingf + 1) % 4, cur.xr, cur.yr, (cur.facingr + 1) % 4,
						cur.steps + 1)); // turning right
				visited[cur.xf][cur.yf][(cur.facingf + 1) % 4][cur.xr][cur.yr][(cur.facingr + 1) % 4] = true;
			}
			if (visited[cur.xf][cur.yf][(cur.facingf + 3) % 4][cur.xr][cur.yr][(cur.facingr + 3) % 4] == false) {
				next.add(new state(cur.xf, cur.yf, (cur.facingf + 3) % 4, cur.xr, cur.yr, (cur.facingr + 3) % 4,
						cur.steps + 1)); // turning left
				visited[cur.xf][cur.yf][(cur.facingf + 3) % 4][cur.xr][cur.yr][(cur.facingr + 3) % 4] = true;
			}
		}

		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownav.out")));
		out.println(output);
		out.close();
	}

	public static state move(int x, int y, int face) {
		if (face == 0) {
			if (y + 1 < n && graph[x][y + 1] != 1 && !(x == n - 1 && y == n - 1))
				return new state(x, y + 1);
			else
				return new state(x, y);
		} else if (face == 1) {
			if (x + 1 < n && graph[x + 1][y] != 1 && !(x == n - 1 && y == n - 1))
				return new state(x + 1, y);
			else
				return new state(x, y);
		} else if (face == 2) {
			if (y - 1 >= 0 && graph[x][y - 1] != 1 && !(x == n - 1 && y == n - 1))
				return new state(x, y - 1);
			else
				return new state(x, y);
		} else {
			if (x - 1 >= 0 && graph[x - 1][y] != 1 && !(x == n - 1 && y == n - 1))
				return new state(x - 1, y);
			else
				return new state(x, y);
		}
	}

	public static class state {
		int xf, yf, facingf; // x-y coordinates and where it is facing 0 is up, 1 is right, 2 is down, 3 is
								// left
		// same thing but for if it starts at the right
		int xr, yr, facingr;
		int steps;

		public state(int a, int b, int c, int d, int e, int f, int g) {
			xf = a;
			yf = b;
			facingf = c;
			xr = d;
			yr = e;
			facingr = f;
			steps = g;
		}

		public state(int a, int b) {
			xf = a;
			yf = b;
			facingf = -1;
			xr = -1;
			yr = -1;
			facingr = -1;
		}
	}
}
