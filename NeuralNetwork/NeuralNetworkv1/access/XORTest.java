package access;

import brain.network;

public class XORTest {
	public static void main(String args[]) {
		network test = new network(2, 1);
		double[] input = { 1, 1 };
		double[] output = { 0 };
		int iterations = 1;

		System.out.println("No training");
		System.out.println(test.prediction(input));
		test.train(input, output, iterations);
		System.out.println("After training " + iterations + " iteration");
		System.out.println(test.prediction(input));
		System.out.println();

		// different data set
		System.out.println("No traing {1 , 0}");
		input[0] = 1;
		input[1] = 0;
		output[0] = 1;
		System.out.println(test.prediction(input));
		test.train(input, output, iterations);
		System.out.println("After training " + iterations + " iterations");
		System.out.println(test.prediction(input));
		System.out.println();

		// different data set
		System.out.println("No traing {0 , 1}");
		input[0] = 0;
		input[1] = 1;
		output[0] = 1;
		System.out.println(test.prediction(input));
		test.train(input, output, iterations);
		System.out.println("After training " + iterations + " iterations");
		System.out.println(test.prediction(input));
		System.out.println();

		// different data set
		System.out.println("No traing {1 , 1}");
		input[0] = 1;
		input[1] = 1;
		output[0] = 0;
		System.out.println(test.prediction(input));
		System.out.println();
	}
}
