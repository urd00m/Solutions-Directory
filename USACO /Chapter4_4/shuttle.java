//package Chapter4_4;
/*
ID: alan.li2
LANG: JAVA
TASK: shuttle
 */
import java.io.*;
import java.util.*;

public class shuttle {
	static int n = 0; 
	static LinkedList<char[]> states = new LinkedList<char[]>(); 
	static char[] board; 
	static String solution = ""; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("shuttle.in")); 
		n = Integer.parseInt(f.readLine());
		board = new char[2*n+1]; 
		f.close();
		
		//init
		for(int i = 0; i < n; i++) {
			board[i] = 'w'; 
		}
		board[n] = ' '; 
		for(int i = n+1; i < 2*n+1; i++) {
			board[i] = 'b'; 
		}
		
		//algorithm  you always jump two if you can and you only move 1 space once per color turn 
		boolean colorWhite = true; 
		int spaceLoc = n; 
		while(check(board) == false) {
			int oneMoves = 0; 
			if(colorWhite == true) { //for white moves 
				for(int i = 0; i < n; i++) {
					if(spaceLoc-1 >= 0 && oneMoves == 0 && board[spaceLoc-1] == 'w') {
						oneMoves++; 
						board[spaceLoc] = 'w';
						board[spaceLoc-1] = ' '; 
						spaceLoc--; 
						solution = solution + (spaceLoc+1) + " "; 
					}
					else if(spaceLoc-2 >= 0 && board[spaceLoc-1] !='w' && board[spaceLoc-2] =='w') {
						board[spaceLoc] = 'w';
						board[spaceLoc-2] = ' '; 
						spaceLoc-=2;
						solution = solution + (spaceLoc+1) + " ";
					}
					else {
						break; 
					}
				}
			}
			else { //for black moves 
				for(int i = 0; i < n; i++) {
					if(spaceLoc+1 < 2*n+1 && oneMoves == 0 && board[spaceLoc+1] == 'b') {
						oneMoves++; 
						board[spaceLoc] = 'b';
						board[spaceLoc+1] = ' '; 
						spaceLoc++; 
						solution = solution + (spaceLoc+1) + " "; 
					}
					else if(spaceLoc+2 < 2*n+1 && board[spaceLoc+1] !='b' && board[spaceLoc+2] =='b') {
						board[spaceLoc] = 'b';
						board[spaceLoc+2] = ' '; 
						spaceLoc+=2;
						solution = solution + (spaceLoc+1) + " ";
					}
					else {
						break; 
					}
				}
			}
			colorWhite = !colorWhite; 
		}
	
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuttle.out"))); 
		StringTokenizer output = new StringTokenizer(solution); 
		int counter = 1; 
		out.print(output.nextElement());
		while(output.hasMoreElements() == true) {
			if(counter%20 ==0) out.print("\n"+output.nextElement());
			else out.print(" " + output.nextElement());
			counter++;
		}
		out.println();
		out.close();
	}
	
	public static boolean check(char[] a) {
		for(char item : a ) System.out.print(item + " ");
		System.out.println();
		boolean isGood = true; 
		for(int i = 0; i < n; i++) {
			if(a[i] != 'b') {
				isGood = false; 
				break; 
			}
		}
		if(isGood == true) {
			if(a[n] != ' ') {
				isGood = false; 
			}
		}
		if(isGood == true) {
			for(int i = n+1; i < 2*n+1; i++) {
				if(a[i] != 'w') {
					isGood = false; 
					break; 
				}
			}
		}
		return isGood; 
	}
}
