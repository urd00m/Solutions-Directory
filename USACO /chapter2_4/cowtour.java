//package chapter2_4;
/*
ID: alan.li2
LANG: JAVA
TASK: cowtour
 */
import java.io.*;
import java.util.*;

public class cowtour {
	static int n; 
	static point[] pastures; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("cowtour.in"));
		n = Integer.parseInt(f.readLine());
		StringTokenizer input; 
		pastures = new point[n]; 
		for(int i = 0; i < n; i++) {
			input = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(input.nextToken()); 
			int b = Integer.parseInt(input.nextToken()); 
			pastures[i] = new point(a, b);
		}
		int[][] adjMatrix = new int[n][n]; 
		for(int i = 0; i < n; i++) {
			String inputString = f.readLine(); 
			for(int j = 0; j < n; j++) {
				adjMatrix[i][j] = Integer.parseInt(inputString.substring(j, j+1));
			}
		}
		f.close();

		//algorithm 
		//first we need to floyd-walsh it 
		double[][] pastureDis = new double[n][n]; 
		//initialize 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(adjMatrix[i][j] == 1) {
					//distance formula 
					double distance = Math.sqrt(Math.pow(pastures[j].y-pastures[i].y, 2) + Math.pow(pastures[j].x-pastures[i].x, 2));
					pastureDis[i][j] = distance; 
				}
				else if(i == j)
					pastureDis[i][j] = 0;
				else 
					pastureDis[i][j] = Double.POSITIVE_INFINITY; 
			}
		}
		
		//floyd-walsh 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if (pastureDis[j][i] + pastureDis[i][k] < pastureDis[j][k]) 
                        pastureDis[j][k] = pastureDis[j][i] + pastureDis[i][k]; 
				}
			}
		}
		
		//After getting shortest distance we need to find the max difference for each of the pastures
		double[] max = new double[n]; 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(pastureDis[i][j] != Double.POSITIVE_INFINITY) {
					if(max[i] < pastureDis[i][j])
						max[i] = pastureDis[i][j]; 
				}
			}
		}
		 
		//find the best connection point
		double smallestDiameter = 99999999999.9; 
		int connection1 = -1, connection2 = -1; 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n ; j++) {
				if(pastureDis[i][j] == Double.POSITIVE_INFINITY) { //different groups, means i and j aren't connected 
					double thisDiameter = max[i] + Math.sqrt(Math.pow(pastures[i].y-pastures[j].y, 2) + Math.pow(pastures[i].x-pastures[j].x, 2)) + max[j]; 
					if(thisDiameter < smallestDiameter) {
						smallestDiameter = thisDiameter; 
						connection1 = i;
						connection2 = j; 
					}
				}
				
			}
		}
		
		
		

		
		
		//the max of the first group and the second group 
		double max1 = max[connection1], max2 = max[connection2]; 
		for(int i = 0; i < n; i++) {
			//for connection 1 find the ones connected to it 
			if(pastureDis[connection1][i] != Double.POSITIVE_INFINITY)
				if(max1 < max[i])
					max1 = max[i]; 
			
			if(pastureDis[connection2][i] != Double.POSITIVE_INFINITY)
				if(max2 < max[i])
					max2 = max[i]; 
		}
		
		//the max of the the previous values is the output 
		double output = Math.max(Math.max(max1, max2), smallestDiameter); 
		String outputString = String.format("%.6f", output); 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out"))); 
		out.println(outputString);
		out.close();
	}
	
	public static class point {
		int x, y; 
		public point(int a, int b) {
			x = a; 
			y = b; 
		}
	}
}
