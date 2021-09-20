//package Chapter3_2;
/*
ID: alan.li2
LANG: JAVA
TASK: ratios
 */
import java.util.*;
import java.io.*;
public class ratios {
	static vector solutionVector; 
	static vector aVector;
	static vector bVector; 
	static vector cVector;
	public static void main(String args[]) throws IOException {
		//input 
		
		BufferedReader f = new BufferedReader(new FileReader("ratios.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine());
		solutionVector = new vector(Integer.parseInt(input.nextToken()),Integer.parseInt(input.nextToken()),Integer.parseInt(input.nextToken())); 
		input = new StringTokenizer(f.readLine());
		aVector = new vector(Integer.parseInt(input.nextToken()),Integer.parseInt(input.nextToken()),Integer.parseInt(input.nextToken())); 
		input = new StringTokenizer(f.readLine());
		bVector = new vector(Integer.parseInt(input.nextToken()),Integer.parseInt(input.nextToken()),Integer.parseInt(input.nextToken())); 
		input = new StringTokenizer(f.readLine());
		cVector = new vector(Integer.parseInt(input.nextToken()),Integer.parseInt(input.nextToken()),Integer.parseInt(input.nextToken())); 
		f.close();
		
		/*
		solutionVector = new vector(3,4,5); 
		aVector = new vector(1,2,3);
		bVector = new vector(3,7,1); 
		cVector = new vector(2,1,2); 
		*/
		//brute force
		int besta = -1, bestb = -1, bestc = -1, bests = Integer.MAX_VALUE; 
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				for(int k = 0; k < 100; k++) {
					//i is coefficient of a mixture, j is coefficient of b mixture, k is coefficient of c mixture 
					int scale = check(i, j, k); 
					if(scale > 0 && scale < bests) {
						bests = scale;
						besta = i;  
						bestb = j; 
						bestc = k; 
					}
				}
			}
		}
		

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ratios.out")));
		if(besta == -1) {
			out.println("NONE");
		}
		else
			out.println(besta + " " + bestb + " " + bestc + " " + bests);
		out.close();
		
		
	}
	public static int check(int i, int j, int k) { //takes in the mixtures, if it works returns the scale of the final if not returns -1
		int masterFactor = -1; 
		int xIndex = (i*aVector.x)+(j*bVector.x)+(k*cVector.x); 
		double storexFactor = (xIndex / (solutionVector.x*1.0)); 
		if((xIndex != 0 && solutionVector.x != 0) && storexFactor != (int)storexFactor) return -1; 
		if(solutionVector.x != 0) masterFactor = (int)(storexFactor);
		int yIndex = (i*aVector.y)+(j*bVector.y)+(k*cVector.y); 
		double storeyFactor = (yIndex / (solutionVector.y*1.0)); 
		if((yIndex != 0 && solutionVector.y != 0) && storeyFactor != (int)storeyFactor) return -1; 
		if(solutionVector.y != 0) masterFactor = (int)(storeyFactor);
		int zIndex = (i*aVector.z)+(j*bVector.z)+(k*cVector.z); 
		double storezFactor = (zIndex / (solutionVector.z*1.0));
		if((zIndex != 0 && solutionVector.z != 0) && storezFactor != (int)storezFactor) return -1; 
		if(solutionVector.z != 0) masterFactor = (int)(storezFactor);
		if( (xIndex == 0 && solutionVector.x == 0) || masterFactor == (int)(storexFactor)) {
			if( (yIndex == 0 && solutionVector.y == 0) || masterFactor == (int)(storeyFactor)) {
				if( (zIndex == 0 && solutionVector.z == 0) || masterFactor == (int)(storezFactor)) {
					return masterFactor; 
				}
			}
		}
		return -1;
	}
	public static class vector {
		public int x;
		public int y;
		public int z; 
		public vector(int a, int b, int c) {
			x = a;
			y = b;
			z = c; 
		}
		public String toString() {
			return x + " " + y + " " + z; 
		}
	}
}
