package USACO;
/*
ID: alan.li2 
LANG: JAVA
TASK: castle
 */

import java.util.*;
import java.io.*;

public class castle2 {
	static int x,y;
	static room[][] rooms; 
	static int maxSize = 0;
	static int roomCount = 0;
	static ArrayList<Integer> sizes  = new ArrayList<Integer>();
	static int removeMax = 0;
	static int removex;
	static int removey;
	static String removePosition; 
	
	
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("castle.in"));
		StringTokenizer in = new StringTokenizer(f.readLine());
		x = Integer.parseInt(in.nextToken());
		y = Integer.parseInt(in.nextToken());
		rooms = new room[y][x]; 
		//getting rid of the 0 in the list size
		sizes.add(0);
		//take in input and put in into rooms
		for(int i = 0; i < y; i++) {
			in = new StringTokenizer(f.readLine());
			for(int j = 0; j < x; j++) {
				rooms[i][j] = new castle2().new room(Integer.parseInt( in.nextToken()));
			}
		}
		//flood fill all rooms 
		find();
		
		//by going through each module and determining wall weight
		//look at the paint on the two neighboring nums, in size and add if bigger then max size then change
		weightWalls();
		
		
		//output
		PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("castle.out" ) ) );
		out.println(roomCount);
		out.println(maxSize);
		out.println(removeMax);
		out.println((removex+1) + " " + (removey+1) + " " + (removePosition));
		//for the wall coordinates, make sure to add one to each
		out.close();
		
	}
	//weights the walls 
	public static void weightWalls() {
		for(int i = 0; i < rooms.length; i++) { //goes through each module
			for(int j = 0; j < rooms[i].length; j++) {
				room store = rooms[i][j]; //temporary store
				if(store.getE() == true) { //east wall weight
					if(j+1 != rooms[i].length) {
						measureWall(i, j, i, j+1, "E");
					}
					else {
						measureWall(i, j, -1, j+1, "E");
					}
				}
				if(store.getW() == true) { //west wall weight
					if(j-1 != -1) {
						measureWall(i, j, i, j-1, "W");
					}
					else {
						measureWall(i, j, -1, j+1, "W");
					}
				}
				if(store.getN() == true) { //north wall weight
					if(i-1 != -1) {
						measureWall(i, j, i-1, j, "N");
					}
					else {
						measureWall(i, j, -1, j+1, "N");
					}
				}
				if(store.getS() == true) { //south wall weight
					if(i+1 != rooms.length) {
						measureWall(i, j, i+1, j, "S");
					}
					else {
						measureWall(i, j, -1, j+1, "S");
					}
				}
			}
		}
	}
	public static void measureWall(int indexX, int indexY, int index2X, int index2Y, String Wall) {
		int sum = 0;
		sum += sizes.get(rooms[indexX][indexY].getPaint()); //gets the size of room 
		if(index2X != -1 && rooms[index2X][index2Y].getPaint() != rooms[indexX][indexY].getPaint()) sum += sizes.get(rooms[index2X][index2Y].getPaint());  //gets 2nd room size
		if (sum > removeMax) {
			removex = indexX;
			removey = indexY;
			removePosition = Wall; 
			removeMax = sum;
		}
		if (sum == removeMax) {
			//tie breaker checks
			/*
			 *   further west module first wins
			 *   then further south module
			 *   furtherest north wall
			 *   then east wall
			 */
			if(indexY < removey) {
				//first tie breaker  
				removex = indexX;
				removey = indexY;
				removePosition = Wall; 
				removeMax = sum;
			}
			else if(indexY == removey) {
				//second tie breaker
				if(indexX > removex) {
					removex = indexX;
					removey = indexY;
					removePosition = Wall; 
					removeMax = sum;
				}
				else if(indexX == removex) {
					//third tiebreaker
					if( !removePosition.equals("N") == true && Wall.equals("N") == true) {
						removex = indexX;
						removey = indexY;
						removePosition = Wall; 
						removeMax = sum;
					}
				}
			}
		}
	}
	public static void find() {
		int paintNum = 1;
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				if(rooms[i][j].getPaint() == -1) {
					int a = flood(i, j, paintNum);
					sizes.add(a);
					roomCount++;
					if( a > maxSize) maxSize = a;
					paintNum++;
				}
						
			}
		}
	}
	
	public static int flood(int index1, int index2, int paintNum) {
		//base case, if all around it has been painted then stop
		room store = rooms[index1][index2];
		if( (store.getE() == true || rooms[index1][index2+1].getPaint() > 0) && (store.getN() == true || rooms[index1-1][index2].getPaint() > 0) && (store.getS() == true || rooms[index1+1][index2].getPaint() > 0) && (store.getW() == true || rooms[index1][index2-1].getPaint() > 0)) {
			rooms[index1][index2].changePaint(paintNum);
			return 1;
		}
		int length = 1;
		//paint this module
		rooms[index1][index2].changePaint(paintNum);
		if( (store.getE() == false && rooms[index1][index2+1].getPaint() < 0) ) //east traverse
			length += flood(index1, index2+1, paintNum);
		if(store.getN() == false && rooms[index1-1][index2].getPaint() < 0) //north traverse
			length += flood(index1-1, index2, paintNum);
		if(store.getS() == false && rooms[index1+1][index2].getPaint() < 0) //south traverse
			length += flood(index1+1, index2, paintNum);
		if(store.getW() == false && rooms[index1][index2-1].getPaint() < 0) //west traverse
			length += flood(index1, index2-1, paintNum);
		
		return length;
	}
	
	public class room { //internal class room
		/*
		1: wall to the west
		2: wall to the north
		4: wall to the east
		8: wall to the south
		 */
		boolean w,n,e,s;  //walls
		int paint = -1; //for flood fill
		
		
		public room(int a) { //Initialize
			if(a >= 8) { //south wall
				s = true;
				a -= 8;
			}
			if(a >= 4) {
				e = true;
				a -= 4;
			}
			if(a >= 2) {
				n = true;
				a -= 2;
			}
			if(a == 1) 
				w = true;
		}
		
		public void changePaint(int a) {
			paint = a;
		}
		public int getPaint() {
			return paint;
		}
		public boolean getS() {
			return s;
		}
		public boolean getW() {
			return w;
		}
		public boolean getN() {
			return n;
		}
		public boolean getE() {
			return e;
		}
		
	}

}
