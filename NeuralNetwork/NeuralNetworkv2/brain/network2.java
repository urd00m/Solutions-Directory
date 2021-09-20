package brain;

public class network2 {
	int numInput, numOutput, numHidden, totalNodes;
	double[][] w1, w2;

	// hidden matrices
	double[][] hiddenOutput;
	double[][] hiddenMiddle;
	double[][] a2;

	public network2(int input, int output) {
		numInput = input;
		numOutput = output;
		numHidden = (int) Math.round((double) ((2.0 * numInput) / 3.0 + (double) (numOutput))) + 1;
		totalNodes = numInput + numOutput + numHidden;
		w1 = new double[numInput][numHidden];
		w2 = new double[numHidden][numOutput];
		// random weight values to start
		fill(w1);
		fill(w2);
	}

	public void fill(double[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = Math.random();
			}
		}
	}

	public double[][] sigmoid(double[][] in) {
		double[][] ret = new double[in.length][in[0].length];
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[0].length; j++) {
				ret[i][j] = (1.0) / (Math.pow(Math.E, -1.0 * in[i][j]) + 1.0);
			}
		}
		return ret;
	}

	public double[][] sigmoidPrime(double[][] in) {
		double[][] ret = new double[in.length][in[0].length];
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[0].length; j++) {
				ret[i][j] = Math.pow(Math.E, in[i][j]) / Math.pow(Math.pow(Math.E, in[i][j]) + 1, 2);
			}
		}
		return ret;
	}

	public double[][] forwardProp(double[][] input) {
		double[][] activation2;
		// input to hidden
		double[][] xw = dotp(input, w1);
		hiddenMiddle = xw;
		double[][] activation1 = sigmoid(xw);
		a2 = activation1;
		// hidden to output
		double[][] aw = dotp(activation1, w2);
		hiddenOutput = aw;
		activation2 = sigmoid(aw);
		return activation2;
	}
	
	public int[] calculate(double[][] input) {
		double[][] output = forwardProp(input);
		assert(output[0].length == 1); 
		int[] ret = new int[output.length];
		for(int i = 0; i < output.length; i++) {
			ret[i] = (int) Math.round(output[i][0]); 
		}
		return ret; 
	}

	public void backwardProp(double[][] input, double[][] output, int iterations) {
		for (int count = 1; count <= iterations; count++) {
			double[][] prediction = forwardProp(input);
			// calculate error
			double[][] error = new double[output.length][output[0].length];
			for (int i = 0; i < error.length; i++) {
				for (int j = 0; j < error[0].length; j++) {
					error[i][j] = -1.0 * (output[i][j] - prediction[i][j]);
				}
			}

			// w2 first
			double[][] fz2 = sigmoidPrime(hiddenOutput);
			double[][] delta2 = scalarM(error, fz2);
			double[][] dzdw = a2;
			double[][] djdw2 = dotp(transpose(dzdw), delta2);
			// w1 second
			double[][] fz1 = sigmoidPrime(hiddenMiddle);
		//	toString(delta2); toString(transpose(w2)); toString(fz1); 
			double[][] delta1 = dotp(dotp(delta2, transpose(w2)), transpose(fz1));
			double[][] djdw1 = dotp(transpose(input), delta1);

			// apply the changes
			//apply to w1 
			for(int i = 0; i < djdw1.length; i++) {
				for(int j = 0; j < djdw1[0].length; j++) {
					for(int k = 0; k < w1[0].length; k++) {
						w1[i][k]-=djdw1[i][j]; 
					}
				}
			}
			//apply to w2
			w2 = addition(w2, djdw2, -1); 
		}
	}
	
	//not complete 
	public void numericalGradientChecking() {
	} 
	
	public double[][] addition(double[][] a, double[][] b, int factor) {
		assert (a.length == b.length && a[0].length == b[0].length);
		double[][] ret = new double[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				ret[i][j] = a[i][j] + factor*b[i][j];
			}
		}
		return ret;
	}

	public double[][] scalarM(double[][] a, double[][] b) {
		assert (a.length == b.length && a[0].length == 1 && b[0].length == 1);
		double[][] ret = new double[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			ret[i][0] = a[i][0] * b[i][0];
		}
		return ret;
	}

	public double[][] transpose(double[][] a) {
		double[][] ret = new double[a[0].length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				ret[j][i] = a[i][j];
			}
		}
		return ret;
	}

	public double[][] dotp(double[][] a, double[][] b) {
		assert (a[0].length == b.length); // or else you can't do dot products
		double[][] ret = new double[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int k = 0; k < b[0].length; k++) {
				for (int j = 0; j < a[0].length; j++) {
					ret[i][k] += a[i][j] * b[j][k];
				}
			}
		}
		return ret;
	}

	public void toString(double[][] a) {
		for (double[] ary : a) {
			for (double item : ary) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void toString(int[] a) {

		for (double item : a) {
			System.out.print(item + " ");
		}
		System.out.println();
		
		System.out.println();
	}

}
