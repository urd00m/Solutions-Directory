package access;

import brain.network2;

public class XORtest2 {
	public static void main(String args[]) {
		network2 test = new network2(2, 1);
		double[][] input = new double[4][2];
		double[][] output = { { 0 }, { 1 }, { 1 }, { 0 } };
		int iterations = 20;
		input[0][0] = 1;
		input[0][1] = 1;
		input[1][0] = 1;
		input[1][1] = 0;
		input[2][0] = 0;
		input[2][1] = 1;
		input[3][0] = 0;
		input[3][1] = 0;

		for (int i = 1; i < 10000; i++) { //fails to train with 4 input cases 
			test = new network2(2, 1); 
			System.out.println("Before training");
			test.toString(test.calculate(input));

			// training
			test.backwardProp(input, output, i);
			System.out.println("After training " + i);
			test.toString(test.calculate(input));
			if(equals(test.calculate(input), output)) {
				break; 
			}
		}
	}
	
	public static boolean equals(int[] a, double[][] b) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] != (int)b[i][0]) {
				return false; 
			}
			
		}
		return true; 
	}
}
