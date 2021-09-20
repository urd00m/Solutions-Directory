//package chapter2_4;
/*
ID: alan.li2
LANG: JAVA
TASK: ttwo
 */
import java.util.*;
import java.io.*;

public class ttwo {
	static int minutes = 0;
	static String[][] map = new String[10][10]; 
	static points FJ_position; 
	static String FJ_facing = "north";
	static String C_facing = "north"; 
	static points C_position; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("ttwo.in"));
		for(int i = 0 ; i < 10; i++) {
			String input = f.readLine();
			for(int j = 0; j < 10; j++) {
				map[i][j] = input.substring(j, j+1); 
				if(input.substring(j, j+1).equals("F")) 
					FJ_position = new points(j, i); 
				if(input.substring(j, j+1).equals("C"))
					C_position = new points(j, i); 
			}
		}
		f.close(); 
		
		//we are going map out the paths they take and look for patterns with both cows and FJ if they both are following a patter that never meets we terminate 
		//Queue FJ_movement = new LinkedList<points>(); 
		//Queue C_movement = new LinkedList<points>(); 
		System.out.println(FJ_position.x +  "," + FJ_position.y + " " + C_position.x +  "," + C_position.y);
		while (true) {
			//as we move the cows we mark the squares they have visited with j for FJ and o for Cows 
			//first move the cows and FJ
			newLocation(FJ_position, FJ_facing, 1);
			newLocation(C_position, C_facing, 2);
			System.out.println(FJ_position.x +  "," + FJ_position.y + " " + C_position.x +  "," + C_position.y);
			minutes++; 
			if(minutes == 10000) {
				minutes = 0;
				System.out.println("Not gonna meet");
				break; 
			}
			if(FJ_position.equalTo(C_position) == true) {
				break; 
			}
		}
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out"))); 
		out.println(minutes);
		out.close();
	}
	/*
	 * minutes++; 
			if(map[FJ_position.x][FJ_position.y].equals(".") == true) {
				FJ_movement.clear();
				FJ_pattern = false; 
			}
			if(map[C_position.x][C_position.y].equals(".") == true) { 
				C_movement.clear();
				C_pattern = false; 
			}
			
			if(map[FJ_position.x][FJ_position.y].equals("j") == true) {
				//their is a pattern
				//if gone in circle
				//recyling through pattern
				if(FJ_position.equalTo((points) FJ_movement.peek()) == true) {
					
				}
			}
			
		}
	 */
	public static void newLocation(points curLoc, String facing, int cowOrFJ) { //1 for FJ and 2 for cow 
		int xChange; 
		int yChange; 
		if(facing.equals("north")) {
			xChange = 0;
			yChange = -1; 
		}
		else if(facing.equals("east")) {
			xChange = 1; 
			yChange = 0; 
		}
		else if(facing.equals("south")) {
			xChange = 0; 
			yChange = 1;
		}
		else {
			xChange = -1; 
			yChange = 0; 
		}
		
		//makes sure its within the boundaries 
		if( (xChange+curLoc.x < 0 || xChange+curLoc.x > 9) || (yChange+curLoc.y < 0 || yChange+curLoc.y > 9 ) || map[yChange+curLoc.y][xChange+curLoc.x].equals("*") == true) {
			//not within boundaries change direction facing 
			if(facing.equals("north"))
				facing = "east";
			else if(facing.equals("east"))
				facing = "south"; 
			else if(facing.equals("south")) 
				facing = "west";
			else 
				facing = "north"; 
		}
		else {
			//within boundaries and changes to new location 
			//goes to new location 
			curLoc = new points(curLoc.x + xChange, curLoc.y + yChange ); 
		}
		if(cowOrFJ == 1) {
			FJ_position = curLoc; 
			FJ_facing = facing; 
		}
		else {
			C_position = curLoc;
			C_facing = facing; 
		}
		
	}
	
	static class points {
		public int x; 
		public int y; 
		public points(int a, int b) {
			x = a; 
			y = b;
		}
		
		public boolean equalTo(points a) {
			if(a.x == x && a.y == y)
				return true;
			return false;
		}
	}
}
