//package Chapter3_1;
/*
ID: alan.li2
LANG: JAVA
TASK: inflate
 */
import java.io.*;
import java.util.*;

public class inflate {
	static int length;
	static int numOfCats; 
	static int[][] cats; 
	static int maxPoints = 0; 
	static double[] equal; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("inflate.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		length = Integer.parseInt(input.nextToken());
		numOfCats = Integer.parseInt(input.nextToken()); 
		cats = new int[numOfCats][2]; //first number is points, then time 
		equal = new double[numOfCats]; 
		for(int count = 0; count < numOfCats; count++) {
			input = new StringTokenizer(f.readLine());
			String a = input.nextToken(); 
			String b = input.nextToken(); 
			cats[count][0] = Integer.parseInt(a);
			cats[count][1] = Integer.parseInt(b);
			equal[count] = Double.parseDouble(a); //just want to know score 
		}
		f.close();
		
		//greedy algorithm 
		//find the max points, create array that equalizes all the time values then choose the highest value 
		boolean foundAFit = true; 
		int timeLeft = length; 
		boolean[] fits = new boolean[numOfCats]; 
		while (foundAFit == true && timeLeft != 0) {
			foundAFit = false; 
			//fits = stillFits(fits, timeLeft); //finding all the ones that still fit 
			int maxValIdx = equalize(timeLeft); //create chart to assess best possible choice 
			if(maxValIdx != -1) {
				foundAFit = true; 
				//calculating points recieved and time 
				//int points = (int) (Math.floor((timeLeft/cats[maxValIdx][1])*1.0)*cats[maxValIdx][0]); 
				//int time = (int) (Math.floor((timeLeft/cats[maxValIdx][1])*1.0)*cats[maxValIdx][1]); 
				timeLeft -= cats[maxValIdx][1];
				maxPoints += cats[maxValIdx][0]; 
			}
		}
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
		out.println(maxPoints);
		out.close();
	}
	
	//takes in time and boolean array of still fitting cats, returns idx of the max value still fitting 
	//returns -1 if nothing fits 
	public static int chooseMax(int timeLeft) {
		
		double maxVal = Integer.MIN_VALUE; 
		int indx = -1; 
		for(int i = 0; i < numOfCats; i++) {
			if(equal[i] > maxVal && cats[i][1] <= timeLeft) {
				maxVal = equal[i]; 
				indx = i; 
			}
		}
		
		return indx; 
	}
	
	
	public static int equalize(int timeLeft) {
		double maxVal = Integer.MIN_VALUE; 
		int indx = -1; 
		for(int i = 0; i < numOfCats; i++) { //set all timse to 10 
			double scaleFact = Math.floor(timeLeft/cats[i][1]*1.0); 
			equal[i] = cats[i][0]*scaleFact; 
			if(equal[i] > maxVal && cats[i][1] <= timeLeft) {
				maxVal = equal[i];
				indx = i;
			}
		}
		return indx; 
	}
	public static void print(double[] a) {
		for(double item : a) {
			System.out.println(item); 
		}
	}
	
	//utility function to determine whether or not the problem cat still can be used 
	public static boolean[] stillFits(boolean[] a, int timeLeft) {
		for(int i = 0; i < numOfCats; i++) {
			if(cats[i][1] <= timeLeft)
				a[i] = true; 
			else 
				a[i] = false; 
		}
		return a; 
	}
}
