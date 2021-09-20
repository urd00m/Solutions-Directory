
//package chapter2_4;
/*
ID: alan.li2
LANG: JAVA
TASK: maze1
 */

import java.util.*;
import java.io.*;

public class maze1 {
	static int w;
	static int h;
	static String[][] maze;
	static int opening1X = -1;
	static int opening1Y;
	static int opening2X;
	static int opening2Y;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("maze1.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		w = Integer.parseInt(input.nextToken());
		h = Integer.parseInt(input.nextToken());
		maze = new String[2 * h + 1][2 * w + 1];
		for (int i = 0; i < 2 * h + 1; i++) {
			String inputString = f.readLine();
			for (int j = 0; j < 2 * w + 1; j++) {
				maze[i][j] = inputString.substring(j, j + 1);
				if (onEdge(j, i) == true && inputString.substring(j, j + 1).equals(" ")) {
					if (opening1X == -1) {
						opening1X = j;
						opening1Y = i;
					} else {
						opening2X = j;
						opening2Y = i;
					}
				}
			}
		}
		maze[opening1Y][opening1X] = "0";
		maze[opening2Y][opening2X] = "0";
		f.close();

		// algorithm, DFS and count the total steps it takes, then do another DFS on he
		// second opening, and anything that takes smaller amount of time more
		// overwritten
		// for output, go back in and find the max
		Stack<ordering> moves = new Stack<ordering>();
		int loc1 = opening1Y;
		int loc2 = opening1X;
		while (true) {
			// for first opening
			ArrayList<ordering> posMoves = move(loc1, loc2);
			for (ordering val : posMoves)
				moves.push(val);
			if (moves.isEmpty() == true)
				break;
			ordering move = moves.pop();
			maze[move.a][move.b] = (Integer.parseInt(maze[loc1][loc2]) + 1) + "";
			loc1 = move.a;
			loc2 = move.b;
		}
		loc1 = opening2Y;
		loc2 = opening2X;
		while (true) {
			// for first opening
			ArrayList<ordering> posMoves = move(loc1, loc2);
			for (ordering val : posMoves)
				moves.push(val);
			if (moves.isEmpty() == true)
				break;
			ordering move = moves.pop();
			maze[move.a][move.b] = (Integer.parseInt(maze[loc1][loc2]) + 1) + "";
			loc1 = move.a;
			loc2 = move.b;
		}
		// find max
		int max = 0;
		for (int i = 0; i < 2 * h + 1; i++) {
			for (int j = 0; j < 2 * w + 1; j++) {
				System.out.print(maze[i][j]);
				try {
					int save = Integer.parseInt(maze[i][j]);
					if (save > max)
						max = save;
				} catch (NumberFormatException e) {

				}
			}
			System.out.println(); 
		}

		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));
		out.println(max);
		out.close();

	}

	public static ArrayList<ordering> move(int a, int b) { // given the opening
		ArrayList<ordering> posMoves = new ArrayList<ordering>();
		if (a - 1 > 0 && (maze[a - 1][b].equals(" ")) || (!maze[a - 1][b].equals("-") && !maze[a - 1][b].equals("|")
				&& !maze[a - 1][b].equals("+") && Integer.parseInt(maze[a - 1][b]) > Integer.parseInt(maze[a][b])))
			posMoves.add(new ordering(a - 1, b));
		else if (a + 1 < 2 * h + 1 && (maze[a + 1][b].equals(" "))
				|| (!maze[a + 1][b].equals("-") && !maze[a + 1][b].equals("|") && !maze[a - 1][b].equals("+")
						&& Integer.parseInt(maze[a + 1][b]) > Integer.parseInt(maze[a][b])))
			posMoves.add(new ordering(a + 1, b));
		else if (b - 1 > 0 && (maze[a][b - 1].equals(" "))
				|| (!maze[a][b - 1].equals("-") && !maze[a][b - 1].equals("|") && !maze[a - 1][b].equals("+")
						&& Integer.parseInt(maze[a][b - 1]) > Integer.parseInt(maze[a][b])))
			posMoves.add(new ordering(a, b - 1));
		else if (b + 1 < 2 * w + 1 && (maze[a][b + 1].equals(" "))
				|| (!maze[a][b + 1].equals("-") && !maze[a][b + 1].equals("|") && !maze[a - 1][b].equals("+")
						&& Integer.parseInt(maze[a][b + 1]) > Integer.parseInt(maze[a][b])))
			posMoves.add(new ordering(a, b + 1));
		return posMoves;

	}

	public static boolean onEdge(int xCoor, int yCoor) {
		if ((xCoor == 0 || xCoor == w * 2) || (yCoor == 0 || yCoor == h * 2)) {
			return true;
		}
		return false;
	}

	public static class ordering {
		int a;
		int b;

		public ordering(int x, int y) {
			a = x;
			b = y;
		}
	}
}
