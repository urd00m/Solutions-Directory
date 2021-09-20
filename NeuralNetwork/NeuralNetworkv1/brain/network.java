package brain;
//the entire network 
public class network {
	int numInput, numOutput;
	int numHidden;
	int totalNodes; 
	public double[][] neural; //structure input hidden layer output 
	double[] nodeValues; 
	
	//hidden inital values 
	double[] hiddenMiddle; 
	double[] hiddenOutput; 
	
	//input for back propgagation
	double[] input; 
	public network(int a, int b) {
		numInput = a; numOutput = b; 
		numHidden = (int) Math.round((double)((2.0*numInput)/3.0+(double)(numOutput)))+1; 
		totalNodes = numInput + numOutput + numHidden; 
		neural = new double[totalNodes][totalNodes]; 
		//random distrubtion no normal distrubution yet
		random(); 
	}
	
	
	//forward progerssion functions 
	public int prediction(double[] input) {
		this.input = input; 
		double[] results = calculate(input);
		System.out.println(results[0]);
		return (int) Math.round(results[0]); 
	}
	
	public double[] calculate(double[] input) {
		nodeValues = new double[totalNodes]; 
		double[] output = new double[numOutput];  
		hiddenMiddle = new double[numHidden]; 
		hiddenOutput = new double[numOutput]; 
		
		//translating input 
		for(int i = 0; i < numInput; i++) {
			nodeValues[i] = input[i]; 
		}
		/*
		for(double item : nodeValues) System.out.print(item + " " );
		System.out.println(); System.out.println();
		*/
		
		//to hidden layer 
		for(int i = numInput; i < numInput+numHidden; i++) {
			double sum = 0.0; 
			for(int j = 0; j < numInput; j++) {
				sum += (nodeValues[j]*neural[j][i]); 
			}
			nodeValues[i] = sum; 
		}
		
		//running sigmoid 
		int id = 0; 
		for(int i = numInput; i < numInput+numHidden; i++) {
			hiddenMiddle[id++] = nodeValues[i]; //stores the hidden values 
			nodeValues[i] = sigmoid(nodeValues[i]); 
		}
		/*
		for(double item : nodeValues) System.out.print(item + " " );
		System.out.println(); System.out.println();
		*/
		
		//hidden to output 
		for(int i = numInput+numHidden; i < totalNodes; i++) {
			double sum = 0.0; 
			for(int j = numInput; j++ < numInput+numHidden; j++) {
				sum+=nodeValues[j]*neural[j][i]; 
			}
			nodeValues[i] = sum; 
		}
		
		//running sigmoid
		id = 0; 
		hiddenOutput = new double[numOutput]; 
		for(int i = numHidden+numInput; i < totalNodes; i++) {
			hiddenOutput[id] = nodeValues[i]; //stores the hidden values 
			nodeValues[i] = sigmoid(nodeValues[i]);
			output[id++] = nodeValues[i]; 
		}
		/*
		for(double item : nodeValues) System.out.print(item + " " );
		System.out.println(); System.out.println();
		*/
		return output; 
	}
	
	public double sigmoid(double in) {
		return (1.0)/(Math.pow(Math.E, -1.0*in)+1.0); 
	}
	
	
	
	
	//training neural network 
	//back propagation 
	
	public void train(double[] input, double[] output, int iterations) {
		for(int i = 0; i < iterations; i++) {
			double[] actual = calculate(input); 
			backPropagation(output, actual); 
			//toString(neural); 
		}
	}
	
	public void toString(double[][] a) {
		String ret = ""; 
		for(double[] ary : a) {
			for(double item : ary) {
				ret += item + " "; 
			}
			ret += "\n"; 
		}
		System.out.println(ret); 
	}
	public void toString(double[] a) {
		String ret = "[";
		for(double item : a) {
			ret += item + " "; 
		}
		ret +="]"; 
		System.out.println(ret); 
	}
	
	public void backPropagation(double[] expected, double[] actual) {
		//output to hidden 
		//calculating the error on each output   (delta output sum) 
		double[] outputSum = new double[numOutput]; 
		for(int i = 0; i < numOutput; i++) {
			outputSum[i] = sigmoidPrime(hiddenOutput[i]) * (expected[i]-actual[i]); 
		}
		
		//output to hidden 
		double[][] deltaWeights = new double[numOutput][numHidden];
		for(int j = 0; j < numOutput; j++)
			for(int i = 0; i < numHidden; i++) {
				deltaWeights[j][i] = outputSum[j]/hiddenMiddle[i];  
			}
		
		
	
		
		//changing hidden to input 
		///calculating delta hidden sum     delta output sum / hidden-to-outer weights * S'(hidden sum)
		double[] deltaHidden = new double[numHidden]; 
		for(int i = 0; i < numOutput; i++) {
			for(int j = 0; j < numHidden; j++) {
				deltaHidden[j] = (outputSum[i]/neural[j+numInput][i+numInput+numHidden])*sigmoidPrime(hiddenMiddle[j]);
			}
		}
		
		//calculating deltaWeigths 
		double[][] deltaWeights2 = new double[numInput][numHidden];
		for(int i = 0; i < numInput; i++) {
			for(int j = 0; j < numHidden; j++) {
				deltaWeights2[i][j] = deltaHidden[j]/(input[i]);
				//deltaWeights2[i][j] = deltaHidden[j];
			}
		}
	
		//changing the weights at the end so that we can still access hidden to outside weights 
		//changing input to hidden 
		for(int i = 0; i < numInput; i++) {
			for(int j = 0; j < numHidden; j++) {
				neural[i][j+numInput] += deltaWeights2[i][j]; 
			}
		}
		//changing hidden to output 
		for(int i = 0; i < numOutput; i++) {
			for(int j = 0; j < numHidden; j++) {
				neural[j+numInput][i+numInput+numHidden]+=deltaWeights[i][j]; 
			}
		}
		
	}
	
	public double sigmoidPrime(double in) {
		return Math.pow(Math.E, in)/Math.pow(Math.pow(Math.E, in)+1, 2);
	}
	
	
	public void random() {
		//input to hidden 
		for(int i = 0; i < numInput; i++) {
			for(int j = numInput; j < numInput+numHidden; j++) {
				neural[i][j] = Math.random(); 
			}
		}
		
		//hidden to output 
		for(int i = numInput; i < numInput+numHidden; i++) {
			for(int j = numInput+numHidden; j < totalNodes; j++) {
				neural[i][j] = Math.random(); 
			}
		}
	}

}
